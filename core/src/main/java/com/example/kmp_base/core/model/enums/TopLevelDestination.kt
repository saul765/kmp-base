package com.example.kmp_base.core.model.enums

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.kmp_base.core.R
import com.example.kmp_base.core.design_system.icon.BaseIcons
import com.example.kmp_base.core.model.navigation_routes.HomeRoute
import com.example.kmp_base.core.model.navigation_routes.SettingsRoute
import kotlin.reflect.KClass

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    @StringRes val iconText: Int,
    val route: KClass<*>
) {
    HOME(
        selectedIcon = BaseIcons.HomeFilled,
        unselectedIcon = BaseIcons.HomeOutlined,
        iconText = R.string.bottom_navigation_home,
        route = HomeRoute::class
    ),
    SETTINGS(
        selectedIcon = BaseIcons.SettingsFilled,
        unselectedIcon = BaseIcons.SettingsOutlined,
        iconText = R.string.bottom_navigation_settings,
        route = SettingsRoute::class
    )
}