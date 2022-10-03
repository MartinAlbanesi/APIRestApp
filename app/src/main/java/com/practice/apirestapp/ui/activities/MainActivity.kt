package com.practice.apirestapp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.practice.apirestapp.databinding.ActivityMainBinding
import com.practice.apirestapp.ui.viewmodels.MainViewModel
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val vm: MainViewModel by viewModel()

    private val beerIdObserver = Observer<Int> { newId ->
        binding.tvBeerId.text = newId.toString()
    }

    private val beerNameObserver = Observer<String> { newName ->
        binding.tvBeerName.text = newName
    }


    private val beerUriObserver = Observer<String> { newURI ->
        Picasso.get().load(newURI).into(binding.imgBeer)
    }

    private val beerDescriptionObserver = Observer<String> { newDescription ->
        binding.tvBeerName.text = newDescription
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}