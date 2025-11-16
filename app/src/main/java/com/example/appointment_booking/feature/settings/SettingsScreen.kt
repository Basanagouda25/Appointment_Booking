package com.example.appointment_booking.feature.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.appointment_booking.core.ViewModel.SettingsViewModel
import com.example.appointment_booking.core.utils.SettingsDataStore

@Composable
fun SettingsScreen(onBack: () -> Unit) {

    val context = LocalContext.current
    val ds = remember { SettingsDataStore(context) }
    val viewModel = remember { SettingsViewModel(ds) }

    val isDark by viewModel.isDarkMode.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Settings")
        Text("Dark Mode", modifier = Modifier.padding(top = 8.dp))

        Switch(
            checked = isDark,
            onCheckedChange = { viewModel.toggleDarkMode(it) }
        )
    }
}
