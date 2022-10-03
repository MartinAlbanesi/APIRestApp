package com.practice.apirestapp.data.repositories

import com.practice.apirestapp.data.repositories.beers.api.models.APIBeerModel

interface BeerRepository {
    suspend fun listBeers(): List<APIBeerModel>

}