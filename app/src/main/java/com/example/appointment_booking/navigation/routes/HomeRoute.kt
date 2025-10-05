package com.example.appointment_booking.navigation.routes

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.appointment_booking.core.ViewModel.MainViewModel
import com.example.appointment_booking.core.model.DoctorModel
import com.example.appointment_booking.feature.home.MainScreen
import com.example.appointment_booking.navigation.Screen

fun NavGraphBuilder.homeRoute(
    vm: MainViewModel,
    onOpenTopDoctors:()-> Unit,
    onOpenDetail: (DoctorModel) -> Unit
){
    composable(Screen.Home.route) {
        val categories by vm.category.observeAsState(emptyList())
        val doctor by vm.doctor.observeAsState(emptyList())
        LaunchedEffect(Unit) {
            if (categories.isEmpty()) vm.loadCategory()
            if (doctor.isEmpty()) vm.loadDoctors()
        }

        MainScreen(viewModel = vm,
            onOpenTopDoctors=onOpenTopDoctors,
        onOpenDoctorDetail = onOpenDetail
        )
    }
}

//NavGraphBuilder.homeRoute is because it can be used in any NavHost
//viewmodel, callbacks for navigation actions
/*composable(Screen.Home.route) defines which route belongs ("home") for now
when navigation hits it will show us Main screen*/
//observes liveData
