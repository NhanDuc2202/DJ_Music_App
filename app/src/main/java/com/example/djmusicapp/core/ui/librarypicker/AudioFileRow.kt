package com.example.djmusicapp.core.ui.librarypicker

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Alarm
import androidx.compose.material.icons.outlined.MusicNote
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.djmusicapp.core.model.AudioFileItem
import com.example.djmusicapp.core.model.AudioFileType

@Composable
fun AudioFileRow(
    item: AudioFileItem,
    onClick: () -> Unit,
    onCheckedChange: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .background(
                    color = Color(0xFF2A2C36),
                    shape = RoundedCornerShape(8.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = when (item.type) {
                    AudioFileType.NOTIFICATION -> Icons.Outlined.Notifications
                    AudioFileType.MUSIC -> Icons.Outlined.MusicNote
                    AudioFileType.RINGTONE -> Icons.Outlined.Phone
                    AudioFileType.ALARM -> Icons.Outlined.Alarm
                },
                contentDescription = null,
                tint = Color(0xFF8F93A8)
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = item.title,
                color = Color.White
            )
            Text(
                text = item.subtitle,
                color = Color(0xFF7C8092)
            )
        }

        Text(
            text = item.duration,
            color = Color(0xFF9B9FB0),
            modifier = Modifier.padding(end = 8.dp)
        )

        Checkbox(
            checked = item.isSelected,
            onCheckedChange = { onCheckedChange() },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.White,
                checkmarkColor = Color.Black,
                uncheckedColor = Color(0xFF6C7082)
            )
        )
    }
}