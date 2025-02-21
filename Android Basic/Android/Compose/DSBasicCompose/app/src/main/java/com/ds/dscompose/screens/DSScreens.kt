package com.ds.dscompose.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector


sealed interface Screen {
    val route: String

    sealed interface WithoutArguments : Screen {
        data object Home : WithoutArguments {
            override val route: String = "home"
        }

        data object Calendar : WithoutArguments {
            override val route: String = "calendar"
        }

        data object Favorites : WithoutArguments {
            override val route: String = "favorites"
        }

        data object Profile : WithoutArguments {
            override val route: String = "profile"
        }
    }
}

data class NavigationItems(
    val route: String,
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val badgeCount: Int? = null
)

val navigationItems = listOf(
    NavigationItems(
        route = Screen.WithoutArguments.Home.route,
        title = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home
    ),
    NavigationItems(
        route = Screen.WithoutArguments.Calendar.route,
        title = "Calendar",
        selectedIcon = Icons.Filled.DateRange,
        unselectedIcon = Icons.Outlined.DateRange
    ),
    NavigationItems(
        route = Screen.WithoutArguments.Favorites.route,
        title = "Favorites",
        selectedIcon = Icons.Filled.Favorite,
        unselectedIcon = Icons.Outlined.Favorite,
        badgeCount = 10
    ),
    NavigationItems(
        route = Screen.WithoutArguments.Profile.route,
        title = "Profile",
        selectedIcon = Icons.Filled.Settings,
        unselectedIcon = Icons.Outlined.Settings
    )
)