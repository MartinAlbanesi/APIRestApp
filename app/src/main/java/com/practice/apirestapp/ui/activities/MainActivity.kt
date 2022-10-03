package com.practice.apirestapp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.practice.apirestapp.R
import com.practice.apirestapp.databinding.ActivityMainBinding
import com.practice.apirestapp.ui.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val vm: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}