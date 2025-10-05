package com.example.appointment_booking.navigation.routes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.appointment_booking.feature.intro.IntroScreen
import com.example.appointment_booking.navigation.Screen

fun NavGraphBuilder.introRoute(onStart:()-> Unit){
    composable(Screen.Intro.route){
        IntroScreen(onStartedClick = onStart)

    }
}

//NavController : Controls the navigation between screen/composable
//NavHost : Decides which screen should be shown at start
//NavGraph : Creates a Map for a particular App
//popBackStack : when you go to next screen and if u hit back the screen will off.
//NavGraphBuilder : It is Domain Specific language(DSL) used to define Screen inside NavHost