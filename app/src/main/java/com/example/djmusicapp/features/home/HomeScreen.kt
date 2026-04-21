package com.example.djmusicapp.features.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.example.djmusicapp.R
import com.example.djmusicapp.core.navigation.Routes
import com.example.djmusicapp.ui.theme.K2D
import com.example.djmusicapp.features.home.components.AnimatedMenuCard
import com.example.djmusicapp.features.home.components.DjMixerBannerCard
import com.example.djmusicapp.features.home.model.HomeMenuItem


@Composable
fun HomeScreen(navController: NavController) {
    val menuItems = listOf(
        HomeMenuItem(
            title = "Drum Pad",
            route = Routes.Test.route,
            iconRes = R.drawable.ic_drum_pad,
            startColor = Color(0xFFFF4D6D),
            endColor = Color(0xFFFF7A7A)
        ),
        HomeMenuItem(
            title = "Ringtone Cutter",
            route = Routes.Test.route,
            iconRes = R.drawable.ic_ringtone_cutter,
            startColor = Color(0xFF5B00FF),
            endColor = Color(0xFFFF00F5)
        ),
        HomeMenuItem(
            title = "Audio Mixer",
            route = Routes.Mixer.route,
            iconRes = R.drawable.ic_audio_mixer,
            startColor = Color(0xFFFF8A00),
            endColor = Color(0xFFFFD000)
        ),
        HomeMenuItem(
            title = "Sound Merger",
            route = Routes.Merger.route,
            iconRes = R.drawable.ic_sound_merger,
            startColor = Color(0xFFE6FF00),
            endColor = Color(0xFF63FF8F)
        ),
        HomeMenuItem(
            title = "My Library",
            route = Routes.Library.route,
            iconRes = R.drawable.ic_my_library,
            startColor = Color(0xFFFF7FD1),
            endColor = Color(0xFF8BE9FF)
        ),
        HomeMenuItem(
            title = "Setting",
            route = Routes.Settings.route,
            iconRes = R.drawable.ic_setting,
            startColor = Color(0xFF9DFF00),
            endColor = Color(0xFF5CFFB2)
        )
    )

    Box(modifier = Modifier
        .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.home_bg),
            contentDescription = "DJ background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Color.Black.copy(alpha = 0.45f)
                )
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.25f),
                            Color.Black.copy(alpha = 0.45f),
                            Color(0xFF05010F).copy(alpha = 0.80f)
                        )
                    )
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, top = 48.dp)
        ) {
            Text(
                text = "DJ Music",
                color = Color.White,
                fontFamily = K2D,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp,
                letterSpacing = (-0.3).sp
            )

            DjMixerBannerCard(navController = navController)

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 24.dp)
            ) {
                items(menuItems) { item ->
                    AnimatedMenuCard(
                        item = item,
                        onClick = {
                            if (navController.currentDestination?.route != item.route) {
                                navController.navigate(item.route) {
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}

