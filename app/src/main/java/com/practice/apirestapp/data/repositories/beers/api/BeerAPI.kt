package com.practice.apirestapp.data.repositories.beers.api

import com.practice.apirestapp.data.repositories.beers.api.models.APIBeerModel
import retrofit2.Response
import retrofit2.http.GET

interface BeerAPI {
    @GET("beers/random")
    fun getRandomBeer(): Response<List<APIBeerModel>>
}