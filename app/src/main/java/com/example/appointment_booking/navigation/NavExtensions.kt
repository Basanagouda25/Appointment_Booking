package com.example.appointment_booking.navigation

import androidx.navigation.NavController
import com.example.appointment_booking.core.model.DoctorModel

fun NavController.navigateToDetail(doctor: DoctorModel){
    currentBackStackEntry?.savedStateHandle?.set("doctor",doctor)
    navigate(Screen.Detail.route)
}