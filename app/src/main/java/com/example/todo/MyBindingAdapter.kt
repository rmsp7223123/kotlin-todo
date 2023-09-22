package com.example.todo

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

object MyBindingAdapter {

    @JvmStatic
    @BindingAdapter("items")
    fun setItem(recyclerView: RecyclerView, todoList: List<TodoModel>?){
        if(recyclerView.adapter == null){
            val adapter = MainAdapter()
            recyclerView.adapter = adapter
        }

        todoList?.let{
            val myAdapter = recyclerView.adapter as MainAdapter
            myAdapter.submitList(it)
            myAdapter.notifyDataSetChanged()
        }
    }
}