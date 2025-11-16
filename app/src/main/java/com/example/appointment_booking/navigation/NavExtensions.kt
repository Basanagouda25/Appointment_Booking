package com.example.appointment_booking.navigation

import android.util.Log
import androidx.navigation.NavHostController
import com.example.appointment_booking.core.model.DoctorModel

fun NavHostController.navigateToDetail(doctor: DoctorModel) {

    // Store doctor in SavedStateHandle of current entry
    this.currentBackStackEntry
        ?.savedStateHandle
        ?.set("doctor", doctor)

    // Debug: print all destinations in the graph safely
    val destinations = mutableListOf<String>()
    this.graph.iterator().forEach { node ->
        if (node.route != null) destinations.add(node.route!!)
    }

    Log.d("NAV_DEBUG", "Destinations in Graph: $destinations")

    // Check if detail exists
    if (!destinations.contains("detail")) {
        Log.e("NAV_DEBUG", "❌ ERROR: route `detail` NOT found in graph.")
        return
    }

    // Navigate
    this.navigate("detail")
}
