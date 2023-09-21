package com.example.todo

import android.arch.lifecycle.ViewModelProvider
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding;

    private lateinit var mainViewModel: MainViewModel; //MainViewModel 인스턴스를 만들고, 이를 관찰

    private lateinit var mainAdapter: MainAdapter;

    private val todoItems : ArrayList<MainModel> = ArrayList();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);
    }

    private fun initViewModel() {
        mainViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(MainViewModel::class.java)
        mainViewModel.getTodoListAll().observe(this, androidx.lifecycle.Observer {
            mainAdapter.setTodoItems(it)
        })
    }
}