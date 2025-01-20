package com.example.kmp_base.webservice.dto.responses

import com.example.kmp_base.model.Pokemon
import kotlinx.serialization.Serializable

@Serializable
data class PokemonDTO(
    val name: String?,
    val url: String?
)

fun PokemonDTO.toDomain(): Pokemon = Pokemon(
    name = name.orEmpty(),
    url = url.orEmpty()
)
