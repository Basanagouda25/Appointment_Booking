package com.example.appointment_booking.navigation.routes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.appointment_booking.feature.wishlist.WishlistScreen
import com.example.appointment_booking.navigation.Screen

fun NavGraphBuilder.wishlistRoute(
    onBack: () -> Unit,
    onOpenDetail: (String) -> Unit
) {
    composable(Screen.Wishlist.route) {
        WishlistScreen(
            onBack = onBack,
            onOpenDetail = onOpenDetail
        )
    }
}

