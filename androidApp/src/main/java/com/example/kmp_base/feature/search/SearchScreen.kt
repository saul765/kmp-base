package com.example.kmp_base.feature.search

import androidx.compose.runtime.Composable
import com.example.kmp_base.core.base.screen.BaseSearchScreen
import com.example.kmp_base.feature.home.state.HomeUiState
import com.example.kmp_base.feature.home.views.HomeView

@Composable
fun SearchScreen(onBackPressed: () -> Unit) = BaseSearchScreen<SearchViewModel, HomeUiState>(
    onBack = onBackPressed,
    successView = { data ->

        HomeView(data)
    })