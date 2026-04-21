package com.example.djmusicapp.features.settings.model

data class SettingsUiState(
    val isLoading: Boolean = false,
    val vibrationEnabled: Boolean = true,
    val waveformAnimationEnabled: Boolean = true,
    val highQualityExport: Boolean = false,
    val autoSaveMix: Boolean = true,
    val darkModeEnabled: Boolean = true,
    val keepScreenOnInMixer: Boolean = true,
    val notificationsEnabled: Boolean = false,
    val appVersion: String = "1.0.0",
    val viewRecordingAfterCompleted: Boolean = false,
    val useNotificationBarToPlayMusic: Boolean = true,
    val useEnglishLanguage: Boolean = false,
    val hideUpdateReminder: Boolean = false,
)