package com.example.todo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodoViewModel : ViewModel() {
    private var _todoList = MutableLiveData<List<TodoModel>>()
    val todoList : LiveData<List<TodoModel>>
        get() = _todoList

    private var items = mutableListOf<TodoModel>()
    init {
        items = arrayListOf(
            TodoModel("테스트1"),
            TodoModel("테스트2")
        )
        _todoList.postValue(items)
    }


    fun addTodo(content: String){
        if(content == ""){
            return
        }
        val todo = TodoModel(content)
        items.add(todo)
        _todoList.postValue(items)
    }
}