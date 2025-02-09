package com.example.kmp_base.feature.home.state

import androidx.compose.runtime.Stable
import com.example.kmp_base.core.model.uiModel.PokemonItemUIModel

@Stable
data class HomeUiState(val pokemons: List<PokemonItemUIModel> = listOf())