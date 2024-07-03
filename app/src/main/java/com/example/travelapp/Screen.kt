package com.example.travelapp

sealed class Screen(val route: String, val icon: Int) {
    object Home : Screen("home", R.drawable.ic_home)
    object Search : Screen("search", R.drawable.ic_search)
    object Profile : Screen("profile", R.drawable.ic_profile)
    object Booking : Screen("Booking", R.drawable.ic_ticket)
}

sealed class Tampilan(val route: String) {
    object Detail : Tampilan("detail")
    object AdditionalDetail : Tampilan("additionalDetail")
}
