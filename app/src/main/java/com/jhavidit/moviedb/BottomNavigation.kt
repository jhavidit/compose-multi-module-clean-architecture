package com.jhavidit.moviedb

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun AppBottomNavigation(navController: NavController) {
    val bottomScreens = remember {
        listOf(
            BottomScreens.Home,
            BottomScreens.Search,
            BottomScreens.Profile
        )
    }

    NavigationBar {
        val currentDestination = navController.currentBackStackEntryAsState().value?.destination

        bottomScreens.forEach { screen ->
            val isSelected =
                currentDestination?.hierarchy?.any { it.hasRoute(screen.route::class) } == true
            NavigationBarItem(
                icon = {
                    if (isSelected) Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = screen.selectedIcon),
                        contentDescription = screen.name
                    )
                    else Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = screen.unselectedIcon),
                        contentDescription = screen.name
                    )
                },
                label = { Text(screen.name) },
                selected = isSelected,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}