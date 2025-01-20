package com.example.kmp_base.webservice.dto.responses

import com.example.kmp_base.model.Pokemon
import com.example.composebase.core.model.PokemonResult
import com.example.kmp_base.ZERO_INTEGER
import kotlinx.serialization.Serializable

@Serializable
data class PokemonResultDTO(
    val count: Int?,
    val next: String?,
    val previous: String?,
    val results: List<PokemonDTO?>? = emptyList()
)

fun PokemonResultDTO.toDomain(): PokemonResult = PokemonResult(
    count = count ?: ZERO_INTEGER,
    next = next.orEmpty(),
    previous = previous.orEmpty(),
    results = results?.map { it?.toDomain() ?: Pokemon() } ?: emptyList()
)
