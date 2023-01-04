package com.example.umc4

import android.R
import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.umc4.databinding.ActivityMainBinding
import com.example.umc4.databinding.ActivityMemoBinding

class MemoActivity : AppCompatActivity() {
    private lateinit var  viewbinding : ActivityMemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewbinding = ActivityMemoBinding.inflate(layoutInflater)
        setContentView(viewbinding.root)

        var titleText = viewbinding.titleText
        var editText = viewbinding.editText

        viewbinding.btnNext.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("title",titleText.getText().toString())
            intent.putExtra("desc",editText.getText().toString())
            setResult(RESULT_OK,intent)
            finish()
            //액티비티를 끝내는 코드
        }
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

        if(data2 != "") {
            AlertDialog.Builder(this).run {
                setTitle("임시저장")
                setIcon(android.R.drawable.ic_dialog_info)
                setMessage("이전 상태를 돌려올까요? 내용: ${data2}")
                setPositiveButton("Yes") { dialog, id ->
                    //"예" 버튼 클릭시 실행하는 메소드
                    viewbinding.editText.setText("${data2}")
                }
                setNegativeButton("No") { dialog, id ->
                    //"예" 버튼 클릭시 실행하는 메소드
                    viewbinding.editText.setText("")
                }
                .show()
            }
        }
    }
    override fun onResume() {
        super.onResume()
        Toast.makeText(applicationContext, "onResume", Toast.LENGTH_LONG).show()
    }
    var data2 = ""

    override fun onPause() {
        super.onPause()
        data2 = viewbinding.editText.getText().toString()
        Toast.makeText(applicationContext, "${data2}", Toast.LENGTH_LONG).show()
    }
}