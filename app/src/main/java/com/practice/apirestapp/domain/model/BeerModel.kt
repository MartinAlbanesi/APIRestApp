package com.practice.apirestapp.domain.model

import com.google.gson.annotations.SerializedName

data class BeerModel(val id: Int,
                     val nombre: String,
                     val descripcion: String,
                     val imagen: String
                     )