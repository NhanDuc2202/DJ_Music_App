package com.example.djmusicapp.features.settings.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun SettingsPathItem(
    icon: ImageVector,
    title: String,
    path: String,
    onClick: () -> Unit
) {
    SettingsBaseItem(onClick = onClick) {
        SettingsLeadingIcon(icon)
        Spacer(modifier = Modifier.width(14.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = title,
                color = Color.White
            )

            Text(
                text = path,
                color = Color(0xFF8B8FA3),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        Spacer(modifier = Modifier.width(4.dp))

        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
            tint = Color.White
        )
    }
}