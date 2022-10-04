package com.practice.apirestapp.ui.activities

import android.net.Uri
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.practice.apirestapp.databinding.ActivityMainBinding
import com.practice.apirestapp.ui.components.ErrorMessage
import com.practice.apirestapp.ui.viewmodels.MainViewModel
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val vm: MainViewModel by viewModel()
    private lateinit var toast: Toast

    private val errorMessageObserver = Observer<ErrorMessage> { errorMessage ->
        if (errorMessage.active) {
            toast.setText(errorMessage.message)
            toast.show()
        }
    }

    private val beerIdObserver = Observer<Int> { newId ->
        binding.tvBeerId.text = newId.toString()
    }

    private val beerNameObserver = Observer<String> { newName ->
        binding.tvBeerName.text = newName
    }

    private val beerUriObserver = Observer<Uri> { newURI ->
        Picasso.get().load(newURI).into(binding.imgBeer)
    }

    private val beerDescriptionObserver = Observer<String> { newDescription ->
        binding.tvBeerDescription.text = newDescription
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toast = Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT)

        vm.errorMessage.observe(this, errorMessageObserver)
        vm.beerName.observe(this,beerNameObserver)
        vm.beerId.observe(this,beerIdObserver)
        vm.beerImageUrl.observe(this,beerUriObserver)
        vm.beerDescription.observe(this,beerDescriptionObserver)

        binding.imgBeer.setOnClickListener{
            vm.getAnotherBeer()
        }

    }
}