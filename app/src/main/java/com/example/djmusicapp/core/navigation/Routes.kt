package com.example.djmusicapp.core.navigation

sealed class Routes(val route: String) {
    data object Home : Routes("home")
    data object Library : Routes("library")
    data object Merger : Routes("merger")
    data object Mixer : Routes("mixer")
    data object Settings : Routes("settings")
    data object Test : Routes("test")
}