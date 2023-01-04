package com.example.umc3

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.core.content.res.TypedArrayUtils.getText
import androidx.viewbinding.ViewBindings
import com.example.umc3.databinding.ActivityMainBinding
import com.example.umc3.databinding.ActivitySecondBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        var editText = binding.editText

        binding.btnNext.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("text",editText.getText().toString())
                                        //viewBinding.textFirst.text.toString()
            startActivity(intent)
        }

    }

}