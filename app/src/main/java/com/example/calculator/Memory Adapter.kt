package com.example.calculator

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MemoryAdapter(
    val context: Context,

    private val noteClickInterface: NoteClickInterface
) :
    RecyclerView.Adapter<MemoryAdapter.ViewHolder>() {


    private val allNotes = ArrayList<Memory>()


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val noteTV = itemView.findViewById<TextView>(R.id.Memory)!!
        val dateTV = itemView.findViewById<TextView>(R.id.Date)!!

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.memory_rv_item,
            parent, false
        )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.noteTV.text = allNotes[position].noteTitle.toString()
        holder.dateTV.text =  allNotes[position].timeStamp.toString()

        holder.itemView.setOnClickListener {

            noteClickInterface.onNoteClick(allNotes[position])
        }
    }

    override fun getItemCount(): Int {

        return allNotes.size
    }


    fun updateList(newList: List<Memory>) {

        allNotes.clear()

        allNotes.addAll(newList)

        notifyDataSetChanged()
    }
}


interface NoteClickInterface {

    fun onNoteClick(note: Memory)
}