package com.example.djmusicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.djmusicapp.ui.theme.DJMusicAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DJMusicAppTheme {
                DjMusicApp()
            }
        }
    }
}