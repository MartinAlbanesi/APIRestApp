package com.practice.apirestapp.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.apirestapp.data.repositories.BeerRepository
import com.practice.apirestapp.data.repositories.beers.api.models.APIBeerModel
import kotlinx.coroutines.launch

class MainViewModel (private val beersList: BeerRepository) : ViewModel(){

    var myBeerList = MutableLiveData(listOf(APIBeerModel(0,"fill","fill","fill")))

    suspend fun fill(){
        viewModelScope.launch {
            myBeerList.value = beersList.listBeers()
        }
    }
}