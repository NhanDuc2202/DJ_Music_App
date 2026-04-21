package com.example.djmusicapp.core.model

data class AudioFileItem(
    val id: String,
    val title: String,
    val subtitle: String,
    val duration: String,
    val isSelected: Boolean = false,
    val type: AudioFileType
)

enum class AudioFileType {
    NOTIFICATION,
    MUSIC,
    RINGTONE,
    ALARM
}