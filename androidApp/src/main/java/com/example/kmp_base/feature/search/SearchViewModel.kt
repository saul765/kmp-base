package com.example.kmp_base.feature.search

import androidx.lifecycle.viewModelScope
import com.example.core.EMPTY_CHARACTER
import com.example.core.base.viewmodel.BaseSearchViewModel
import com.example.core.data.UIStateStatus
import com.example.core.model.uiModel.PokemonItemUIModel
import com.example.kmp_base.feature.home.state.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class SearchViewModel(
) : BaseSearchViewModel<HomeUiState>() {

    override val searchQuery: MutableStateFlow<String> = MutableStateFlow(EMPTY_CHARACTER)

    override val uiState = combine(flow<Unit> { }, searchQuery)
    { pokemons, query ->

        UIStateStatus.Success(
            HomeUiState(
                pokemons = listOf(
                    PokemonItemUIModel(
                        1,
                        "Bulbasaur",
                        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png"
                    )
                )
            )
        )

    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = UIStateStatus.Empty(HomeUiState()),
    )

    override fun onSearchQueryChanged(query: String) {
        searchQuery.update { query }
    }
}