package com.example.appointment_booking.feature.topdoctors.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.appointment_booking.R
import com.example.appointment_booking.core.model.DoctorModel

@Composable
fun DoctorRowCard(
    item: DoctorModel,
    onMakeClick:()-> Unit
){
    val lightPurple= colorResource(R.color.lightPurple)
    val darkpurple= colorResource(R.color.darkPurple)
    val black= colorResource(R.color.black)
    val gray= colorResource(R.color.gray)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Box(Modifier.fillMaxWidth()){
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)) {
                Row(Modifier.fillMaxWidth()) {
                    Box(modifier = Modifier
                        .size(96.dp)
                        .background(lightPurple,RoundedCornerShape(10.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        AsyncImage(
                            model = item.Picture,
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Fit
                        )
                    }
                        Spacer(Modifier.width(16.dp))

                        Column(Modifier.weight(1f)) {
                            DegreeChip(text = "Professional Doctor")
                            Spacer(Modifier.height(8.dp))
                            Text(text = item.Name?:"name", color = black, fontWeight = FontWeight.Bold)
                            Spacer(Modifier.height(8.dp))
                            Text(text = item.Special?:"special", color = gray)

                            Row(verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(top = 8.dp)
                            ) {
                                ComposeRatingBar(rating = (item.Rating?:0.0).toFloat())
                                Spacer(Modifier.width(8.dp))
                                Text(text = (item.Rating ?:0.0).toString(),
                                    color = black,
                                    fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                OutlinedButton(
                    onClick = onMakeClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top=16.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = lightPurple,
                        contentColor = darkpurple
                    ),
                    border = ButtonDefaults.outlinedButtonBorder.copy(
                        width = 1.dp,
                        brush = SolidColor(darkpurple)
                    )
                ) {
                    Text(text = "Make Appointment", fontWeight = FontWeight.Bold)
                }
            }

            IconButton(
                onClick = {},
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.fav_bold),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            }
        }
    }
}

@Preview
@Composable
fun DoctorRowCardPreview(){
    DoctorRowCard(
        item = DoctorModel(
            Name = "Dr. John Doe",
            Special = "Dermatologist",
            Rating = 4.5,
            Picture = "https://picsum.photos/200"
        ),
        onMakeClick = {}
    )
}