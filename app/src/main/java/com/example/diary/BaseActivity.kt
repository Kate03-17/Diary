package com.example.diary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        val navView: BottomNavigationView = findViewById(R.id.naw_view)

        val navController = findNavController(R.id.nav_host_fragment)

        val appbarConfig = AppBarConfiguration(setOf(
            R.id.fragmentDiary, R.id.fragmentToDo
        ))
        setupActionBarWithNavController(navController, appbarConfig)
        navView.setupWithNavController(navController)
    }
}