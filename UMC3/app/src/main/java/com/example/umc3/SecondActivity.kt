package com.example.umc3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.umc3.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var viewBinding:ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding =ActivitySecondBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        val extras = intent.extras
        val data = extras!!["text"] as String

        viewBinding.twoText.text = data

        viewBinding.secondPassBtn.setOnClickListener {
            val intent = Intent(this,ThirdActivity::class.java)
            startActivity(intent)
        }
    }
}