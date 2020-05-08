package com.denischornyyapp.betrendy.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.denischornyyapp.betrendy.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
