package com.example.umc4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.umc4.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import android.content.Context as Context1


class MainActivity : AppCompatActivity() {
    private lateinit var viewbinding: ActivityMainBinding

    private val viewModel:RoomDbViewModel by viewModels{
        object : ViewModelProvider.Factory {
            override fun<T:ViewModel> create(modelClass: Class<T>):T =
                RoomDbViewModel(application) as T
        }
    }
    private var id: Int? =null

    //registrerForActivityResult 를 위한 기본 선언
    private lateinit var getResultText: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewbinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(viewbinding.root)

        //SharedPreference 사용해보기
//        val sharedPrefs = getSharedPreferences(packageName, Context.MODE_PRIVATE)
//        val editor = sharedPrefs.edit()
        //editor.putString("edit","android")
        //editor.apply()
        //add(Data(sharedPrefs.getString("title",null),sharedPrefs.getString("desc",null)))

        //Data > dataList라는 배열을 선언하고 이를 DataRVAdapter로 넘겨주는 코드들
        val dataList: ArrayList<Data> = arrayListOf()
        val DataRVAdapter = DataRVAdapter(viewModel,this)

        //MemoActivity를 갓다 돌아오면서 title과 desc의 데이터를 가지고 오는 역할 (코드)
        getResultText = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == RESULT_OK) {
                val title = result.data?.getStringExtra("title")
                val desc = result.data?.getStringExtra("desc")

                //memo를 룸디비에 넣기
                if (title != null && desc != null) {
                    val memo = Memo(title,desc,id)
                    lifecycleScope.launch(Dispatchers.IO){viewModel.insert(memo)}
//                    finish()
                }

                //가지고 오면서 dataList에 Data를 추가 하는 역할
//                dataList.apply {
//                    add(Data(title, desc))
//                }
//                DataRVAdapter.notifyDataSetChanged()
            }
        }

        var addmemobtn = viewbinding.addmemobtn
        var resetmemobtn = viewbinding.MainResetBt
        addmemobtn.setOnClickListener {
            val intent = Intent(this, MemoActivity::class.java)
            //위쪽에 registerForActivityResult로 시작하면 intent를 받아올 수 있다.
            getResultText.launch(intent)
        }
        resetmemobtn.setOnClickListener {
            val intent = Intent(this, StarAcitivity::class.java)
            startActivity(intent)
        }


        //어댑터를 연결해주고 layoutManager를 연결해준다
        viewbinding.rvData.adapter = DataRVAdapter
        viewbinding.rvData.layoutManager = LinearLayoutManager(this)

        viewModel.getAll().observe(this, Observer { DataRVAdapter.setMemoItemList(it)})

    }


    override fun onStart() {
        super.onStart()
        Toast.makeText(applicationContext, "onStart() 호출됨", Toast.LENGTH_LONG).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(applicationContext, "onStop() 호출됨", Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(applicationContext, "onDestroy() 호출됨", Toast.LENGTH_LONG).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(applicationContext, "onRestart() 호출됨", Toast.LENGTH_LONG).show()

    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(applicationContext, "onResume", Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(applicationContext, "onPause", Toast.LENGTH_LONG).show()
    }
}