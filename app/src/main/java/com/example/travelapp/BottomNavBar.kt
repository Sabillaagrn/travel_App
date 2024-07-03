package com.example.travelapp

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.travelapp.ui.theme.blue1

@Composable
fun BottomNavBar(navController: NavController) {
    val items = listOf(
        Screen.Home,
        Screen.Search,
        Screen.Booking,
        Screen.Profile
    )
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = blue1
    ) {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.destination?.route

        items.forEach { screen ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = screen.icon), contentDescription = null) },
                label = { Text(screen.route.capitalize()) },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
