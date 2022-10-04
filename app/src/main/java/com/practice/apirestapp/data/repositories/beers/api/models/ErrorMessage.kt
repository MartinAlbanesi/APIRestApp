package com.practice.apirestapp.data.repositories.beers.api.models

import com.google.gson.annotations.SerializedName

data class ErrorMessage(
    val status: Int,
    @SerializedName("status_message") val statusMessage: String
)