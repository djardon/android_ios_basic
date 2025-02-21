package com.ds.dscompose.components


import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ds.dscompose.screens.CalendarScreen
import com.ds.dscompose.screens.FavoritesScreen
import com.ds.dscompose.screens.HomeScreen
import com.ds.dscompose.screens.ProfileScreen
import com.ds.dscompose.screens.Screen
import com.ds.dscompose.screens.navigationItems


@Preview
@Composable
fun BottomBarComponents() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(
                contentColor = Color.Black,
                containerColor = Color.White
            ) {
                navigationItems.forEach { screen ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                imageVector = if (navBackStackEntry?.destination?.route == screen.route) {
                                    screen.selectedIcon
                                } else screen.unselectedIcon,
                                contentDescription = screen.title
                            )
                        },
                        label = { Text(screen.title) },
                        selected = navBackStackEntry?.destination?.route == screen.route,
                        onClick = {
                            navController.navigate(screen.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        }
                    )
                }
            }
        },
    ) { innerPadding ->
        AppNavigation(
            navController = navController,
            innerPadding = innerPadding,
        )
    }
}

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
    innerPadding: PaddingValues
) {
    /*
    val backDispatcher = activity.onBackPressedDispatcher

    DisposableEffect(key1 = backDispatcher) {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                navController.popBackStack()
            }
        }
        backDispatcher.addCallback(callback)
        onDispose {
            callback.remove()
        }
    }
     */

    NavHost(
        navController = navController,
        startDestination = Screen.WithoutArguments.Home.route,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None }
    ) {
        composable(Screen.WithoutArguments.Home.route) {
            HomeScreen(
                modifier = Modifier.padding(innerPadding),
            )
        }

        composable(Screen.WithoutArguments.Calendar.route) {
            CalendarScreen(
                modifier = Modifier.padding(innerPadding),
            )
        }

        composable(Screen.WithoutArguments.Favorites.route) {
            FavoritesScreen(
                modifier = Modifier.padding(innerPadding),
            )
        }

        composable(Screen.WithoutArguments.Profile.route) {
            ProfileScreen(
                modifier = Modifier.padding(innerPadding),
            )
        }
    }
}