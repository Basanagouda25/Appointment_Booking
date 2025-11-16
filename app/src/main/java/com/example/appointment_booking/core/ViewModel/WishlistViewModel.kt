package com.example.appointment_booking.core.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appointment_booking.core.model.WishlistItem
import com.example.appointment_booking.core.utils.WishlistRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class WishlistViewModel(private val repo: WishlistRepository) : ViewModel() {

    val items: StateFlow<List<WishlistItem>> =
        repo.getAll().stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun addItem(title: String) {
        viewModelScope.launch { repo.add(title) }
    }

    fun removeItem(item: WishlistItem) {
        viewModelScope.launch { repo.remove(item) }
    }
}
