package com.achiakkon.mvpapplication.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.achiakkon.mvpapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}