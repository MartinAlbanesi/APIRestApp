package com.practice.apirestapp.data.repositories

import com.practice.apirestapp.data.repositories.beers.api.BeerClient
import com.practice.apirestapp.data.repositories.beers.api.models.APIBeerModel

class BeerAPIRepository(private val beerClient: BeerClient): BeerRepository {

    override suspend fun getBeer(): List<APIBeerModel> {
        return beerClient.fetchBeer()
    }

}