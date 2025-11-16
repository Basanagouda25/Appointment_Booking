package com.example.appointment_booking.core.utils

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.appointment_booking.core.model.WishlistItem

@Database(entities = [WishlistItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun wishlistDao(): WishlistDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "appointment_db"
                ).build().also { INSTANCE = it }
            }
    }
}
