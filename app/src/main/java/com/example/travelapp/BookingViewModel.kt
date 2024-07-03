// BookingViewModel.kt
package com.example.travelapp

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

data class Booking(
    val name: String,
    val departureDate: String,
    val numberOfDays: Int,
    val modeOfTravel: String,
    val city: String,
    val country: String
)

class BookingViewModel : ViewModel() {
    val bookings = mutableStateListOf<Booking>()

    fun saveBooking(booking: Booking) {
        bookings.add(booking)
    }
}