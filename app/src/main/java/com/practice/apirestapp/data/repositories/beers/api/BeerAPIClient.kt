package com.practice.apirestapp.data.repositories.beers.api

import com.practice.apirestapp.data.repositories.beers.api.models.APIBeerModel

class BeerAPIClient(beerAPIProvider: BeerAPIProvider) : BeerClient {
    private val beerAPI: BeerAPI = beerAPIProvider.getAPI()

    override fun fetchBeer(): List<APIBeerModel> {
        val beerAPIResponse = beerAPI.getRandomBeer()
        if(!beerAPIResponse.isSuccessful){
            throw Exception("Error")
        }

        return beerAPIResponse.body() ?: emptyList()
    }
}