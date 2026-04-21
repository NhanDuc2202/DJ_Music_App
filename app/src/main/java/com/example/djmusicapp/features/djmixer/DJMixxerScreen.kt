package com.example.djmusicapp.features.djmixer

import android.app.Activity
import android.content.pm.ActivityInfo
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.djmusicapp.features.djmixer.components.DjCenterMixerPanel
import com.example.djmusicapp.features.djmixer.components.DjDeckPanel
import com.example.djmusicapp.features.djmixer.components.DjMixerTopBar

@Composable
fun DjMixerScreen(
    navController: NavController
) {
    val context = LocalContext.current
    val activity = context as? Activity

    fun goBackToPortrait() {
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        navController.popBackStack()
    }

    BackHandler() {
        goBackToPortrait()
    }

    DisposableEffect(activity) {
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        onDispose {
            if (activity?.isChangingConfigurations != true) {
                activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF111111))
    ) {
        DjMixerTopBar(
            onBackClick = { goBackToPortrait() }
        )

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 34.dp, start = 8.dp, end = 8.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            DjDeckPanel(
                modifier = Modifier.weight(1f),
                isLeft = true
            )

            DjCenterMixerPanel(
                modifier = Modifier.weight(0.62f)
            )

            DjDeckPanel(
                modifier = Modifier.weight(1f),
                isLeft = false
            )
        }
    }
}