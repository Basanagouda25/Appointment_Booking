package com.example.appointment_booking.core.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appointment_booking.core.utils.SettingsDataStore
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SettingsViewModel(private val ds: SettingsDataStore) : ViewModel() {

    val isDarkMode = ds.isDarkMode.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        false
    )

    fun toggleDarkMode(enabled: Boolean) {
        viewModelScope.launch {
            ds.setDarkMode(enabled)
        }
    }
}
