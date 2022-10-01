package com.practice.apirestapp.data.repositories.beers.api

import com.google.gson.Gson
import com.practice.apirestapp.data.repositories.beers.api.BeerAPI
import com.practice.apirestapp.data.repositories.beers.api.BeerAPIProvider
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BeerAPIMainProvider: BeerAPIProvider {

    override fun getAPI(): BeerAPI {
        val serviceGetBeersByAPI = Retrofit.Builder()
            .baseUrl("https://api.punkapi.com/v2/")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
        return serviceGetBeersByAPI.create(BeerAPI::class.java)
    }
}