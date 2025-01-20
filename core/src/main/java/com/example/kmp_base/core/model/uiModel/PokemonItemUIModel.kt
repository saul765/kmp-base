package com.example.kmp_base.core.model.uiModel

import com.example.kmp_base.model.PokemonItem

data class PokemonItemUIModel(val id: Int, val imageUrl: String, val name: String)


fun PokemonItem.toUIModel(): PokemonItemUIModel = PokemonItemUIModel(
    id = id,
    imageUrl = sprites.other.officialArtwork.frontDefault,
    name = name
)