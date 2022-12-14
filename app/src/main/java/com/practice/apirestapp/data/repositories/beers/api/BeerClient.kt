package com.practice.apirestapp.data.repositories.beers.api

import com.practice.apirestapp.data.repositories.beers.api.models.APIBeerModel

interface BeerClient {
    suspend fun fetchBeer(): List<APIBeerModel>
}