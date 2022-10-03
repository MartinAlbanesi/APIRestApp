package com.practice.apirestapp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.practice.apirestapp.R
import com.practice.apirestapp.ui.viewmodels.MainViewModel
import org.koin.android.compat.ScopeCompat.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

private val vm: MainViewModel by viewModel()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}