package com.example.todo

import android.arch.lifecycle.ViewModelProvider
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.databinding.ActivityMainBinding
import java.util.Date

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding;

    private lateinit var mainViewModel: MainViewModel; //MainViewModel 인스턴스를 만들고, 이를 관찰

    private lateinit var mainAdapter: MainAdapter;

    private val todoItems : ArrayList<MainModel> = ArrayList();

    private val btn_add: Button by lazy {
        findViewById<Button>(R.id.btn_add)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);
    }

    private fun initViewModel() {
        mainViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(MainViewModel::class.java);
        mainViewModel.getTodoListAll().observe(this, androidx.lifecycle.Observer {
            mainAdapter.setTodoItems(it);
        });
    };

//    private fun initRecyclerview() {
//        mainAdapter =
//            MainAdapter {  }({ todo -> deleteDialog(todo) })  //adapter 에 click 시 해야할 일을 (todo) -> Unit 파라미터로 넘겨준다
//        recyclerview_list.run {
//            setHasFixedSize(true)
//            layoutManager = LinearLayoutManager(this@MainActivity)
//            adapter = todoListAdapter
//        }
//    }


    /*
    * btn_add 설정
    * */
    private fun initBtnAdd() {
        btn_add.setOnClickListener {
            showAddTodoDialog()
        }
    }


    /*
    * Todo 리스트를 추가하는 Dialog 띄우기
    *  TodoModel 을 생성하여 리스트 add 해서 리스트를 갱신
    * */
    private fun showAddTodoDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_add, null)
        val et_add_title: EditText by lazy {
            dialogView.findViewById<EditText>(R.id.et_add_title)
        }
        val et_add_content: EditText by lazy {
            dialogView.findViewById<EditText>(R.id.et_add_content)
        }
        var builder = AlertDialog.Builder(this)
        val dialog = builder.setTitle("Todo 아이템 추가하기").setView(dialogView)
            .setPositiveButton(
                "확인"
            ) { dialogInterface, i ->
                var id: Long? = null
                val title = et_add_title.text.toString()
                val content = et_add_content.text.toString()
                val createdDate = Date().time
                val todoModel = MainModel(
                    id,
                    mainAdapter.getItemCount() + 1,
                    title,
                    content,
                    createdDate
                )
                mainViewModel.insert(todoModel)
            }
            .setNegativeButton("취소", null)
            .create()
        dialog.show()
    }


    /*
    * Todo 리스트를 삭제하는 Dialog 띄우기
    * */
    private fun deleteDialog(todoModel: MainModel) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(todoModel.seq.toString()+" 번 Todo 아이템을 삭제할까요? ")
            .setNegativeButton("취소") { _, _ -> }
            .setPositiveButton("확인") { _, _ ->
                mainViewModel.delete(todoModel)
            }
            .create()
        builder.show()
    }
}