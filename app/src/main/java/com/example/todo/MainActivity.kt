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

//    View : 뷰는 사용자 인터페이스를 나타냄
//           사용자에게 데이터를 표시하고 사용자 입력을 받아들이는 역할
//           Activity, Fragment

//    viewModel : 뷰 모델은 뷰와 모델 사이에서 중개자 역할
//                뷰 모델은 뷰에서 필요한 데이터를 관리하고, 뷰에 표시할 데이터를 가공 및 준비
//                뷰 모델은 뷰와 모델 사이의 결합을 제거하고 비즈니스 로직을 뷰에서 분리함으로써 뷰를 더 간단하게 만들어줌
//                주로 라이브 데이터(LiveData) 또는 RxJava와 같은 라이브러리를 사용하여 데이터 변경을 관찰하고 뷰에 업데이트를 푸시하는 역할
//                view가 요청한 데이터를 Model에 요청


//    Model : 모델은 데이터와 비즈니스 로직을 나타냄,
//            데이터베이스에서 데이터를 검색하거나 저장하고, 네트워크를 통해 데이터를 가져오거나 업데이트하는 작업 등을 수행
//            모델은 데이터의 현재 상태를 나타내는 역할을 하며, 보통 데이터 클래스로 표현
//            ViewModel 이 요청한 데이터 반환

//    MVVM 패턴의 핵심은 데이터 바인딩을 통해 뷰와 뷰 모델을 연결 하고, 뷰 모델이 데이터 변경을 감지하고 이를 뷰에 자동으로 반영
//    MVVM 패턴은 코드의 재사용성, 테스트 용이성, 유지 보수성을 향상시키는 데 도움이 되며, 앱의 복잡성을 관리하는 데 큰 장점

    private lateinit var binding : ActivityMainBinding;

    private val viewModel : TodoViewModel by viewModels();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.viewModel = viewModel;
        binding.lifecycleOwner = this;
    }

}