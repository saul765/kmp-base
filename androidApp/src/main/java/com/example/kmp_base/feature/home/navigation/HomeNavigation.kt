package com.example.kmp_base.feature.home.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.kmp_base.core.model.navigation_routes.HomeBaseRoute
import com.example.kmp_base.core.model.navigation_routes.HomeRoute
import com.example.kmp_base.feature.home.HomeScreen


fun NavController.navigateToHome(navOptions: NavOptions? = null) =
    navigate(route = HomeRoute, navOptions = navOptions)

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
fun NavGraphBuilder.homeGraph(
    onSearchClick: () -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit
) {
    navigation<HomeBaseRoute>(startDestination = HomeRoute) {
        composable<HomeRoute> {
            HomeScreen(onSearchClick = onSearchClick)
        }
        nestedGraphs()
    }
}