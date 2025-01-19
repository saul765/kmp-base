package com.example.kmp_base.ui.navigation


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.example.kmp_base.ui.ComposeBaseNavigationState
import com.example.core.model.navigation_routes.HomeBaseRoute
import com.example.kmp_base.feature.home.navigation.homeGraph
import com.example.kmp_base.feature.search.navigation.navigateToSearch
import com.example.kmp_base.feature.search.navigation.searchGraph
import com.example.kmp_base.feature.settings.navigation.settingsGraph


@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun ComposeBaseAppNavHost(
    appState: ComposeBaseNavigationState,
    modifier: Modifier = Modifier,
) {
    val navController = appState.navController
    NavHost(
        navController = navController,
        startDestination = HomeBaseRoute,
        modifier = modifier,
        enterTransition = { fadeIn() },
        exitTransition = { fadeOut() },
        popEnterTransition = { fadeIn() },
        popExitTransition = { fadeOut() }
    ) {
        homeGraph(onSearchClick = navController::navigateToSearch,
            nestedGraphs = {

                searchGraph(onBackPressed = navController::popBackStack) {}
            }
        )

        settingsGraph(
            nestedGraphs = {
            }
        )

    }
}