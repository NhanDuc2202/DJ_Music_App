package com.example.djmusicapp.features.settings

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.djmusicapp.features.settings.model.SettingsUiState

class SettingsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SettingsUiState())
    val uiState: StateFlow<SettingsUiState> = _uiState.asStateFlow()

    fun onVibrationChanged(enabled: Boolean) {
        _uiState.value = _uiState.value.copy(vibrationEnabled = enabled)
    }

    fun onWaveformAnimationChanged(enabled: Boolean) {
        _uiState.value = _uiState.value.copy(waveformAnimationEnabled = enabled)
    }

    fun onHighQualityExportChanged(enabled: Boolean) {
        _uiState.value = _uiState.value.copy(highQualityExport = enabled)
    }

    fun onAutoSaveMixChanged(enabled: Boolean) {
        _uiState.value = _uiState.value.copy(autoSaveMix = enabled)
    }

    fun onDarkModeChanged(enabled: Boolean) {
        _uiState.value = _uiState.value.copy(darkModeEnabled = enabled)
    }

    fun onKeepScreenOnChanged(enabled: Boolean) {
        _uiState.value = _uiState.value.copy(keepScreenOnInMixer = enabled)
    }

    fun onNotificationsChanged(enabled: Boolean) {
        _uiState.value = _uiState.value.copy(notificationsEnabled = enabled)
    }
}