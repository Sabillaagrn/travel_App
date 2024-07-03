package com.example.travelapp

import SearchScreen
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    val bookingViewModel: BookingViewModel = viewModel()
    NavHost(
        navController,
        startDestination = "splashScreen",
        modifier = modifier.fillMaxSize()
    ) {
        composable("splashScreen") { SplashScreen(navController) }
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.Search.route) { SearchScreen(navController) }
        composable(Screen.Booking.route) { DetailBookingScreen(navController, bookingViewModel) }
        composable(Tampilan.Detail.route + "/{city}/{country}/{imageRes}") { backStackEntry ->
            val city = backStackEntry.arguments?.getString("city") ?: ""
            val country = backStackEntry.arguments?.getString("country") ?: ""
            val imageRes = backStackEntry.arguments?.getInt("imageRes") ?: 0
            DetailScreen(navController, city, country, imageRes)
        }
        composable(Screen.Profile.route) { ProfileScreen(navController) }

        composable(Tampilan.AdditionalDetail.route + "/{city}/{country}/{imageRes}") { backStackEntry ->
            val city = backStackEntry.arguments?.getString("city") ?: ""
            val country = backStackEntry.arguments?.getString("country") ?: ""
            val imageRes = backStackEntry.arguments?.getInt("imageRes") ?: 0
            AdditionalDetailScreen(navController, city, country, imageRes)
        }
        composable("dataBookingScreen/{city}/{country}/{days}") { backStackEntry ->
            DataBookingScreen(
                navController = navController,
                city = backStackEntry.arguments?.getString("city") ?: "",
                country = backStackEntry.arguments?.getString("country") ?: "",
                days = backStackEntry.arguments?.getString("days")?.toInt() ?: 0,
                bookingViewModel = bookingViewModel
            )
        }
    }
}