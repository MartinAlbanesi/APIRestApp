package com.practice.apirestapp.ui.viewmodels

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.apirestapp.data.repositories.BeerRepository
import com.practice.apirestapp.ui.components.ErrorMessage
import kotlinx.coroutines.launch

class MainViewModel(private val beerRepository: BeerRepository) : ViewModel() {

    var beerName = MutableLiveData("Punk IPA 2007 - 2010")
    var beerId = MutableLiveData(192)
    var beerImageUrl = MutableLiveData(Uri.parse("https://images.punkapi.com/v2/192.png"))
    var beerDescription =
        MutableLiveData(
            """
        |Our flagship beer that kick started the craft beer revolution. This is James and Martin's original take on an American IPA,
        | subverted with punchy New Zealand hops. Layered with new world hops to create an all-out riot of grapefruit, pineapple and lychee before a spiky,
        |  mouth-puckering bitter finish.
        |  """.trimMargin()
        )
    var errorMessage = MutableLiveData(ErrorMessage(false, ""))

    init {
        getAnotherBeer()
    }

    fun getAnotherBeer() {
        viewModelScope.launch {
            try {
                val randomBeer = beerRepository.getBeer()
                beerName.value = randomBeer.nombre
                beerId.value = randomBeer.id
                beerImageUrl.value = Uri.parse(randomBeer.imagen)
                beerDescription.value = randomBeer.descripcion
            } catch (e: Exception) {
                errorMessage.value = ErrorMessage(true, e.message)
            }
        }
    }

}