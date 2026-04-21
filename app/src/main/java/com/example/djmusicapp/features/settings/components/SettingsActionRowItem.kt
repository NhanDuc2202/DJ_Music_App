package com.example.djmusicapp.features.settings.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun SettingsActionRowItem(
    icon: SettingsIcon,
    title: String,
    showArrow: Boolean = false,
    onClick: () -> Unit
) {
    SettingsBaseItem(onClick = onClick) {
        SettingsLeadingIcon(icon = icon)
        Spacer(modifier = Modifier.width(14.dp))

        Text(
            text = title,
            color = Color.White,
            modifier = Modifier.weight(1f)
        )
    }
}