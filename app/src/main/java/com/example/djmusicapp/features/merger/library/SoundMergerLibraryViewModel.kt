package com.example.djmusicapp.features.merger.library

import androidx.lifecycle.ViewModel
import com.example.djmusicapp.core.model.AudioFileItem
import com.example.djmusicapp.core.model.AudioFileType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SoundMergerLibraryViewModel : ViewModel() {

    private val _files = MutableStateFlow(
        listOf(
            AudioFileItem(
                id = "s1",
                title = "Notification_Record-27...18-17",
                subtitle = "Notification • RingtoneMaker",
                duration = "00:06",
                type = AudioFileType.NOTIFICATION
            ),
            AudioFileItem(
                id = "s2",
                title = "Alarm_Record-27-08...18-17",
                subtitle = "Alarm • RingtoneMaker",
                duration = "00:06",
                type = AudioFileType.ALARM
            ),
            AudioFileItem(
                id = "s3",
                title = "Record_Record-27-08...18-17",
                subtitle = "Music • Unknown",
                duration = "00:06",
                type = AudioFileType.MUSIC
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