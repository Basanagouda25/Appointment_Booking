package com.example.appointment_booking.navigation.routes

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.appointment_booking.core.ViewModel.MainViewModel
import com.example.appointment_booking.core.model.DoctorModel
import com.example.appointment_booking.feature.topdoctors.TopDoctorsScreen
import com.example.appointment_booking.navigation.Screen

fun NavGraphBuilder.topDoctorsRoute(
    vm: MainViewModel,
    onBack:()-> Unit,
    onOpenDetail:(DoctorModel)-> Unit
){
    composable(Screen.TopDoctors.route){
        val doctors by vm.doctor.observeAsState(emptyList())
        LaunchedEffect(Unit) {
            if(doctors.isEmpty()) vm.loadDoctors()
        }

        TopDoctorsScreen(
            doctors = doctors,
            onBack = onBack,
            onOpenDetail
        )
    }
}