package com.example.appointment_booking.feature.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appointment_booking.navigation.Screen   // ✅ CORRECT

@Composable
fun HomeScreen(onNavigate: (String) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Home Screen")

        Button(onClick = { onNavigate(Screen.Wishlist.route) }) {
            Text("Go to Wishlist")
        }

        Button(onClick = { onNavigate(Screen.Settings.route) }) {
            Text("Go to Settings")
        }
    }
}
