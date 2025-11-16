package com.example.appointment_booking.core.utils

import androidx.room.*
import com.example.appointment_booking.core.model.WishlistItem
import kotlinx.coroutines.flow.Flow

@Dao
interface WishlistDao {

    @Query("SELECT * FROM wishlist")
    fun getAll(): Flow<List<WishlistItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: WishlistItem)

    @Delete
    suspend fun delete(item: WishlistItem)
}
