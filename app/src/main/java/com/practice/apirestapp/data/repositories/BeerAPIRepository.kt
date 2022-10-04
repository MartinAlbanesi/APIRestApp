package com.practice.apirestapp.data.repositories

import com.practice.apirestapp.data.repositories.beers.api.BeerClient
import com.practice.apirestapp.domain.model.BeerModel
import com.practice.apirestapp.domain.model.toBeer

class BeerAPIRepository(private val beerClient: BeerClient) : BeerRepository {

    override suspend fun getBeer(): BeerModel {
        return beerClient.fetchBeer().random().toBeer()
    }

}