package com.example.kmp_base.model


import com.example.composebase.core.model.Sprite
import com.example.kmp_base.EMPTY_CHARACTER
import com.example.kmp_base.ZERO_INTEGER


data class PokemonItem(
    val id: Int = ZERO_INTEGER,
    val sprites: Sprite = Sprite(),
    val name: String = EMPTY_CHARACTER
)
