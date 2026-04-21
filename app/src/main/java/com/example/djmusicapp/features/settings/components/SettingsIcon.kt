package com.example.djmusicapp.features.settings.components

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector

sealed class SettingsIcon {
    data class Vector(val imageVector: ImageVector) : SettingsIcon()
    data class Drawable(@DrawableRes val iconRes: Int) : SettingsIcon()
}