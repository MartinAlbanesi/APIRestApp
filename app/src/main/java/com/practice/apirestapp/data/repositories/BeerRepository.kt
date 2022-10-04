package com.practice.apirestapp.data.repositories

import com.practice.apirestapp.data.repositories.beers.api.models.APIBeerModel
import com.practice.apirestapp.domain.model.BeerModel

interface BeerRepository {
    suspend fun getBeer(): BeerModel
}