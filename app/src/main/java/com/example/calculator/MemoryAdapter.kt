package com.example.calculator

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.calculator.data.Memory
import com.example.calculator.databinding.MemoryBinding

class MemoryAdapter : RecyclerView.Adapter<TodoViewHolder>() {

    private var memOry = emptyList<Memory>()

    fun submitList(memoryList: List<Memory>) {
        memOry = memoryList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MemoryBinding.inflate(inflater, parent, false)
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.binding.meMory.text = memOry[position].memory
    }

    override fun getItemCount() = memOry.size

}

class TodoViewHolder(val binding: MemoryBinding) : RecyclerView.ViewHolder(binding.root)