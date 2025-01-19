package com.example.kmp_base.feature.home

import androidx.lifecycle.viewModelScope
import com.example.core.base.viewmodel.BaseViewModel
import com.example.core.data.UIStateStatus
import com.example.kmp_base.feature.home.state.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class HomeViewModel(

) : BaseViewModel() {

    private val _pokemonUiState = MutableStateFlow<UIStateStatus<HomeUiState>>(
        UIStateStatus.Empty(
            HomeUiState()
        )
    )

    init {
    }

    val pokemonUiState = _pokemonUiState.asStateFlow()


    fun getFirst15Pokemons() {
        viewModelScope.launch(contextProvider.getMainContext()) {
            flow<Unit> { }
                .flowOn(contextProvider.getIOContext())
                .onStart { showLoading() }
                .onCompletion { hideLoading() }
                .catch { e -> showError(e) }
                .collect()
        }
    }
}