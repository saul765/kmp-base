package com.example.kmp_base.webservice.dto.responses

import com.example.kmp_base.model.PokemonItem
import com.example.composebase.core.model.Sprite
import com.example.kmp_base.ZERO_INTEGER
import kotlinx.serialization.Serializable

@Serializable
data class PokemonItemDTO(
    val id: Int?,
    val sprites: SpriteDTO?,
    val name: String?
)

fun PokemonItemDTO.toDomain(): PokemonItem =
    PokemonItem(
        id = id ?: ZERO_INTEGER,
        sprites = sprites?.toDomain() ?: Sprite(),
        name = name.orEmpty()
    )
