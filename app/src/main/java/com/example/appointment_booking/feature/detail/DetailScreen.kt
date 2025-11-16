package com.example.appointment_booking.feature.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appointment_booking.core.ViewModel.WishlistViewModel
import com.example.appointment_booking.core.model.DoctorModel
import java.nio.file.WatchEvent

@Composable
fun DetailScreen(
    item: DoctorModel,
    onBack:()-> Unit,
    onOpenWebsite: (String) -> Unit,
    onSendSms:(mobile: String,body: String)-> Unit,
    onDial:(mobile: String)-> Unit,
    onDirection:(locationUrl: String)-> Unit,
    onShare:(subject: String,text: String)-> Unit,
    wishlistVm: WishlistViewModel,
    onFavorite: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            DetailHeader(pictureUrl = item.Picture,
                onBack = onBack,
                onFavorite = onFavorite
            )
            Surface(
                color = Color.White,
                shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 420.dp)
            ) {
                DetailBody(item = item,
                    onOpenWebsite = onOpenWebsite,
                    onSendSms = onSendSms,
                    onDial = onDial,
                    onDirection = onDirection,
                    onShare = onShare
                )
            }
        }
    }
}


