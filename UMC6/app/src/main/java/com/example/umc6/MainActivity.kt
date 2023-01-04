package com.example.umc6

import android.app.Activity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.umc6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var viewbinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewbinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewbinding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(viewbinding.containerFragment.id,HomeFragment())
            .commitAllowingStateLoss()

        viewbinding.navBottom.run {
            setOnItemSelectedListener {
                when(it.itemId){
                    R.id.menu_home ->{
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewbinding.containerFragment.id,HomeFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_content ->{
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewbinding.containerFragment.id,ContentFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_setting ->{
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewbinding.containerFragment.id,SettingFragment())
                            .commitAllowingStateLoss()
                    }
                }
                true
            }
            selectedItemId = R.id.menu_home
        }
    }


}