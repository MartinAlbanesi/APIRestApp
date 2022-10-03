package com.practice.apirestapp.data.repositories

import com.practice.apirestapp.data.repositories.beers.api.models.APIBeerModel

interface BeerRepository {
    suspend fun getBeer(): List<APIBeerModel>

}