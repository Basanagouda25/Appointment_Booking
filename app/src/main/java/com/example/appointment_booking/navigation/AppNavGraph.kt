package com.example.appointment_booking.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.appointment_booking.core.ViewModel.MainViewModel
import com.example.appointment_booking.core.ViewModel.WishlistViewModel
import com.example.appointment_booking.core.model.DoctorModel
import com.example.appointment_booking.core.utils.AppDatabase
import com.example.appointment_booking.core.utils.WishlistRepository
import com.example.appointment_booking.feature.account.AccountScreen
import com.example.appointment_booking.feature.detail.DetailScreen
import com.example.appointment_booking.feature.settings.SettingsScreen
import com.example.appointment_booking.feature.wishlist.WishlistScreen
import com.example.appointment_booking.navigation.routes.detailRoute
import com.example.appointment_booking.navigation.routes.homeRoute
import com.example.appointment_booking.navigation.routes.introRoute
import com.example.appointment_booking.navigation.routes.topDoctorsRoute
import com.example.appointment_booking.navigation.Screen

@Composable
fun AppNavGraph(
    nav: NavHostController,
    vm: MainViewModel
) {
    NavHost(
        navController = nav,
        startDestination = Screen.Intro.route
    ) {

        // ------------ Intro Screen ------------
        introRoute(
            onStart = {
                nav.navigate(Screen.Home.route) {
                    popUpTo(Screen.Intro.route) { inclusive = true }
                }
            }
        )

        // ------------ Home Screen ------------
        homeRoute(
            vm = vm,
            onOpenTopDoctors = { nav.navigate(Screen.TopDoctors.route) },
            onOpenDetail = { doctor -> nav.navigateToDetail(doctor) },
            onOpenWishlist = { nav.navigate(Screen.Wishlist.route) },
            onOpenSettings = { nav.navigate(Screen.Settings.route) },
            onOpenAccount = { nav.navigate(Screen.Account.route) }
        )

        // ------------ Top Doctors ------------
        topDoctorsRoute(
            vm = vm,
            onBack = { nav.popBackStack() },
            onOpenDetail = { doctor -> nav.navigateToDetail(doctor) }
        )

        // ------------ Detail Screen ------------
        detailRoute(
            nav = nav,
            onBack = { nav.popBackStack() }
        )

        // ------------ Wishlist Screen ------------
        composable(Screen.Wishlist.route) {
            WishlistScreen(
                onBack = { nav.popBackStack() },
                onOpenDetail = { name ->
                    val doctor = vm.doctor.value?.find { it.Name == name }
                    if (doctor != null) {
                        nav.navigateToDetail(doctor)
                    }
                }
            )
        }

        // ------------ Settings Screen ------------
        composable(Screen.Settings.route) {
            SettingsScreen(onBack = { nav.popBackStack() })
        }

        // ------------ Account Screen ------------
        composable(Screen.Account.route) {
            AccountScreen(onBack = { nav.popBackStack() })
        }
    }
}

