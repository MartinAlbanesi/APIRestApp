package com.practice.apirestapp.domain.model

import com.practice.apirestapp.data.repositories.beers.api.models.APIBeerModel

fun APIBeerModel.toBeer() = BeerModel(
    id = id,
    nombre = nombre,
    descripcion = descripcion,
    imagen = imagen
)