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
import androidx.viewbinding.ViewBindings
import com.example.umc3.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(binding.frameFragment.id,FirstFragment())
            .commitAllowingStateLoss()

        binding.btnFragment1.setOnClickListener{
            supportFragmentManager
                .beginTransaction()
                .replace(binding.frameFragment.id,FirstFragment())
                .commitAllowingStateLoss()
        }

        binding.btnFragment2.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(binding.frameFragment.id,SecondFragment())
                .commitAllowingStateLoss()
        }



    }

}