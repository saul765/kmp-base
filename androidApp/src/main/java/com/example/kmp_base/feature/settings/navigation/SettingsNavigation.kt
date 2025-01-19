package com.example.kmp_base.feature.settings.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.kmp_base.feature.settings.SettingsScreen
import com.example.core.model.navigation_routes.SettingsBaseRoute
import com.example.core.model.navigation_routes.SettingsRoute


fun NavController.navigateToSettings(navOptions: NavOptions? = null) =
    navigate(route = SettingsRoute, navOptions = navOptions)

fun NavGraphBuilder.settingsGraph(
    nestedGraphs: NavGraphBuilder.() -> Unit
) {
    navigation<SettingsBaseRoute>(startDestination = SettingsRoute) {
        composable<SettingsRoute> {
            SettingsScreen()
        }
        nestedGraphs()
    }
}