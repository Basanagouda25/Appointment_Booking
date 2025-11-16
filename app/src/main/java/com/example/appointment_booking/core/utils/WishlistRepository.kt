package com.example.appointment_booking.core.utils

import com.example.appointment_booking.core.model.WishlistItem
import kotlinx.coroutines.flow.Flow

class WishlistRepository(private val dao: WishlistDao) {

    fun getAll(): Flow<List<WishlistItem>> = dao.getAll()

    suspend fun add(title: String) {
        dao.insert(WishlistItem(title = title))
    }

    suspend fun remove(item: WishlistItem) {
        dao.delete(item)
    }
}
