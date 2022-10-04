package com.practice.apirestapp.data.repositories.beers.api

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.practice.apirestapp.data.repositories.beers.api.models.APIBeerModel
import com.practice.apirestapp.data.repositories.beers.api.models.ErrorMessage
import retrofit2.Response

class BeerAPIClient(beerAPIProvider: BeerAPIProvider) : BeerClient {
    private val beerAPI: BeerAPI = beerAPIProvider.getAPI()

    override suspend fun fetchBeer(): List<APIBeerModel> {
        val beerAPIResponse = beerAPI.getRandomBeer()
        if(!beerAPIResponse.isSuccessful){
            throw Exception(handleUnsuccessfulResponse(beerAPIResponse).statusMessage)
        }

        return beerAPIResponse.body() ?: emptyList()
    }

    private fun <T> handleUnsuccessfulResponse(response: Response<T>): ErrorMessage {
        return try {
            Gson().fromJson(response.errorBody()!!.string(), ErrorMessage::class.java)
        } catch (je: JsonSyntaxException) {
            ErrorMessage(500, "Unknown")
        }
    }
}