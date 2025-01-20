package com.example.composebase.core.model

import com.example.kmp_base.model.Pokemon

data class PokemonResult(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<Pokemon>
)