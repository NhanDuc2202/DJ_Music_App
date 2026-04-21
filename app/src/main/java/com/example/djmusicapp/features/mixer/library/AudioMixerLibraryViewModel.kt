package com.example.djmusicapp.features.mixer.library

import androidx.lifecycle.ViewModel
import com.example.djmusicapp.core.model.AudioFileItem
import com.example.djmusicapp.core.model.AudioFileType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AudioMixerLibraryViewModel : ViewModel() {

    private val _files = MutableStateFlow(
        listOf(
            AudioFileItem(
                id = "m1",
                title = "Mixer_Audio_01.mp3",
                subtitle = "Music • Local",
                duration = "00:12",
                type = AudioFileType.MUSIC
            ),
            AudioFileItem(
                id = "m2",
                title = "Voice_Sample.wav",
                subtitle = "Record • Internal",
                duration = "00:08",
                type = AudioFileType.NOTIFICATION
            )
        )
    )
    val files = _files.asStateFlow()

    fun toggleSelection(id: String) {
        _files.update { list ->
            list.map {
                if (it.id == id) it.copy(isSelected = !it.isSelected) else it
            }
        }
    }
}