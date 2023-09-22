package com.example.todo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.databinding.RecvItemBinding

class MainAdapter : ListAdapter<TodoModel, RecyclerView.ViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(RecvItemBinding.inflate(LayoutInflater.from(parent.context),parent,false));
    };


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.bind(currentList[position]);
        };
    };

    inner class ViewHolder(private val binding: RecvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(todo: TodoModel) {
            binding.todoModel = todo;
        };
    };

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<TodoModel>() {
            override fun areItemsTheSame(oldItem: TodoModel, newItem: TodoModel): Boolean {
                return oldItem == newItem;
            };

            override fun areContentsTheSame(oldItem: TodoModel, newItem: TodoModel): Boolean {
                return oldItem == newItem;
            };

        };
    };
}