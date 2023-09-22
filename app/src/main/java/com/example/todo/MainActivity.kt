package com.example.todo

import androidx.lifecycle.ViewModelProvider
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.databinding.ActivityMainBinding
import java.util.Date

class MainActivity : AppCompatActivity() {

//    View : Activity, Fragment
//    viewModel : view가 요청한 데이터를 Model에 요청
//    Model : ViewModel 이 요청한 데이터 반환

    private lateinit var binding : ActivityMainBinding;

    private val viewModel : TodoViewModel by viewModels();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.viewModel = viewModel;
        binding.lifecycleOwner = this;
    }

}