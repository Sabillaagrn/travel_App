package com.example.travelapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.travelapp.ui.theme.blue2
import com.example.travelapp.ui.theme.blue4

@Composable
fun DataBookingScreen(navController: NavController, city: String, country: String, days: Int, bookingViewModel: BookingViewModel = viewModel()) {
    var name by remember { mutableStateOf("") }
    var departureDate by remember { mutableStateOf("") }
    var numberOfDays by remember { mutableStateOf(days.toString()) }
    var modeOfTravel by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Booking Details",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = departureDate,
            onValueChange = { departureDate = it },
            label = { Text("Departure Date") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = numberOfDays,
            onValueChange = { numberOfDays = it },
            label = { Text("Number of Days") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = modeOfTravel,
            onValueChange = { modeOfTravel = it },
            label = { Text("Mode of Travel") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                val booking = Booking(
                    name = name,
                    departureDate = departureDate,
                    numberOfDays = numberOfDays.toInt(),
                    modeOfTravel = modeOfTravel,
                    city = city,
                    country = country
                )
                bookingViewModel.saveBooking(booking)
                navController.navigate(Screen.Booking.route) // Navigate to DetailBookingScreen
            },
            colors = ButtonDefaults.buttonColors(contentColor = blue2),
            shape = RoundedCornerShape(50),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Confirm Booking",
                color = blue4,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }
}