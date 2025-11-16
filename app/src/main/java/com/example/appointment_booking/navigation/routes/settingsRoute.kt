package com.example.appointment_booking.navigation.routes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.appointment_booking.feature.settings.SettingsScreen
import com.example.appointment_booking.navigation.Screen

fun NavGraphBuilder.settingsRoute(
    onBack: () -> Unit
) {
    composable(Screen.Settings.route) {
        SettingsScreen(onBack = onBack)
    }
}
