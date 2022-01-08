package com.example.calculator

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.calculator.data.Memory
import com.example.calculator.databinding.MemoryRvItemBinding

class MemoryAdapter : RecyclerView.Adapter<TodoViewHolder>() {

    private var memory = emptyList<Memory>()

    fun submitList(todoList: List<Memory>) {
        memory = todoList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MemoryRvItemBinding.inflate(inflater, parent, false)
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.binding.Memory.text = memory[position].data
    }

    override fun getItemCount() = memory.size

}

class TodoViewHolder(val binding: MemoryRvItemBinding) : RecyclerView.ViewHolder(binding.root)