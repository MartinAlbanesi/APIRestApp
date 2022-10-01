package com.practice.apirestapp.data.repositories.beers.api

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.practice.apirestapp.data.repositories.beers.api.models.APIBeerModel
import retrofit2.Response

class BeerAPIClient(beerAPIProvider: BeerAPIProvider) : BeerClient {
    private val beerAPI: BeerAPI = beerAPIProvider.getAPI()

    override fun fetchBeers(): List<APIBeerModel> {
        val beerAPIResponse = beerAPI.getBeers()
        if(!beerAPIResponse.isSuccessful){
            throw Exception("Error")
        }

        return beerAPIResponse.body() ?: emptyList()
    }
}