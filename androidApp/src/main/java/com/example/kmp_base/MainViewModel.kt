package com.example.kmp_base

import androidx.lifecycle.viewModelScope
import com.example.kmp_base.core.base.viewmodel.BaseViewModel
import com.example.kmp_base.core.model.AppUiState
import com.example.kmp_base.core.network.INetworkMonitor
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