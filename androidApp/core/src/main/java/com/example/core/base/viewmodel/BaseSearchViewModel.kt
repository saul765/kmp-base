package com.example.core.base.viewmodel

import com.example.core.data.UIStateStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseSearchViewModel<S> : BaseViewModel() {

    abstract val searchQuery: MutableStateFlow<String>

    abstract val uiState: StateFlow<UIStateStatus<S>>

    abstract fun onSearchQueryChanged(query: String)

}