package com.example.kmp_base.feature.home

import androidx.lifecycle.viewModelScope
import com.example.kmp_base.core.base.viewmodel.BaseViewModel
import com.example.kmp_base.core.data.UIStateStatus
import com.example.kmp_base.core.model.uiModel.toUIModel
import com.example.kmp_base.feature.home.state.HomeUiState
import com.example.kmp_base.usecases.IGetHomePokemonUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getHomePokemonUseCase: IGetHomePokemonUseCase
) : BaseViewModel() {

    private val _pokemonUiState = MutableStateFlow<UIStateStatus<HomeUiState>>(
        UIStateStatus.Empty(
            HomeUiState()
        )
    )

    init {
        getFirst15Pokemons()
    }

    val pokemonUiState = _pokemonUiState.asStateFlow()


    fun getFirst15Pokemons() {
        viewModelScope.launch(contextProvider.getMainContext()) {
            getHomePokemonUseCase.execute()
                .flowOn(contextProvider.getIOContext())
                .onStart { showLoading() }
                .onCompletion { hideLoading() }
                .catch { e ->
                    e
                    showError(e) }
                .collect { pokemons ->
                    if (pokemons.isEmpty()) {
                        _pokemonUiState.update { UIStateStatus.Empty(HomeUiState()) }
                    } else {
                        val pokemonList = pokemons.map { it.toUIModel() }
                        _pokemonUiState.update { UIStateStatus.Success(HomeUiState(pokemonList)) }
                    }
                }
        }
    }
}