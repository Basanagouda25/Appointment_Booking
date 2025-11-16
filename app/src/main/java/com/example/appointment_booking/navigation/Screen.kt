package com.example.appointment_booking.navigation

sealed class Screen(val route: String){
    data object Intro: Screen("intro")
    data object Home: Screen("home")
    data object TopDoctors: Screen("topDoctors")
    data object Detail: Screen("detail")

    object Wishlist : Screen("wishlist")
    object Settings : Screen("settings")
    object Account : Screen("account")

    object Login : Screen("login_screen")
    object Otp : Screen("otp_screen/{phoneNumber}") {
        fun createRoute(phoneNumber: String) = "otp_screen/$phoneNumber"
    }
}