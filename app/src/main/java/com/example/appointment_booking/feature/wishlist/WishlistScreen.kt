package com.example.appointment_booking.feature.wishlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.appointment_booking.core.ViewModel.WishlistViewModel
import com.example.appointment_booking.core.utils.AppDatabase
import com.example.appointment_booking.core.utils.WishlistRepository

@Composable
fun WishlistScreen(
    onBack: () -> Unit,
    onOpenDetail: (String) -> Unit   // <--- Add this
) {

    val context = LocalContext.current
    val dao = remember { AppDatabase.getInstance(context).wishlistDao() }
    val repo = remember { WishlistRepository(dao) }
    val viewModel = remember { WishlistViewModel(repo) }

    val items by viewModel.items.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Wishlist", style = MaterialTheme.typography.titleLarge)

        Spacer(Modifier.height(12.dp))

        LazyColumn {
            items(items) { item ->

                ListItem(
                    headlineContent = {
                        Text(
                            item.title,
                            modifier = Modifier
                                .clickable { onOpenDetail(item.title) }  // <--- Open Detail
                        )
                    },
                    trailingContent = {
                        IconButton(onClick = { viewModel.removeItem(item) }) {   // <--- Delete icon
                            Icon(
                                Icons.Default.Delete,
                                contentDescription = "Delete"
                            )
                        }
                    }
                )

                Divider()
            }
        }
    }
}
