package com.example.appointment_booking.core.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appointment_booking.core.model.CategoryModel
import com.example.appointment_booking.core.model.DoctorModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

//use class for MainViewModel
class MainViewModel: ViewModel() {
    private val db = FirebaseDatabase.getInstance()

    private val _category = MutableLiveData<List<CategoryModel>>(emptyList())
    private val _doctor = MutableLiveData<List<DoctorModel>>(emptyList())

    val category: LiveData<List<CategoryModel>> = _category
    val doctor: LiveData<List<DoctorModel>> = _doctor

    private var categoryLoaded = false
    private var doctorLoaded = false

    fun loadCategory(force: Boolean = false) {
        if (categoryLoaded && !force) return

        categoryLoaded = true
        val ref = db.getReference("Category")

        ref.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val items = mutableListOf<CategoryModel>()
                for (child in snapshot.children){
                    child.getValue(CategoryModel::class.java)?.let {items.add(it)}
                }
                _category.value = items
            }

            override fun onCancelled(error: DatabaseError) {
                categoryLoaded = false
            }

        })
    }


    fun loadDoctors(force: Boolean = false) {

        if (doctorLoaded && !force) return

        doctorLoaded = true
        val ref = db.getReference("Doctors")

        ref.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val items = mutableListOf<DoctorModel>()
                for (child in snapshot.children){
                    child.getValue(DoctorModel::class.java)?.let {items.add(it)}
                }
                _doctor.value = items
            }
            override fun onCancelled(error: DatabaseError) {
                doctorLoaded = false
            }
        })
    }
}
