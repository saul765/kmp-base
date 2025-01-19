package com.example.kmp_base

import androidx.lifecycle.viewModelScope
import com.example.composebase.core.network.INetworkMonitor
import com.example.core.base.viewmodel.BaseViewModel
import com.example.core.model.AppUiState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class MainViewModel(networkMonitor: INetworkMonitor) : BaseViewModel() {


    val uiState: StateFlow<AppUiState> = networkMonitor.isOnline.map {
        AppUiState(isOnline = it)
    }
        .stateIn(
            scope = viewModelScope,
            initialValue = AppUiState(),
            started = SharingStarted.WhileSubscribed(5_000)
        )

}