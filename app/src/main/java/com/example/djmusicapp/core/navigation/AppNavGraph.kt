package com.example.djmusicapp.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.djmusicapp.features.home.HomeScreen
import com.example.djmusicapp.features.merger.library.AudioMergerScreen
import com.example.djmusicapp.features.settings.SettingsScreen
import com.example.djmusicapp.features.drumpad.TestScreen
import com.example.djmusicapp.features.mixer.library.AudioMixer
import com.example.djmusicapp.features.djmixer.DjMixerScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Home.route
    ) {
        composable(Routes.Home.route) {
            HomeScreen(navController)
        }
        composable(Routes.Test.route) {
            TestScreen()
        }

        composable(Routes.Merger.route) {
            AudioMergerScreen(navController)
        }

        composable(Routes.Mixer.route) {
            AudioMixer(navController)
        }

        composable(Routes.Settings.route) {
            SettingsScreen(navController)
        }

        composable(Routes.DjMixer.route) {
            DjMixerScreen(navController)
        }
    }
}