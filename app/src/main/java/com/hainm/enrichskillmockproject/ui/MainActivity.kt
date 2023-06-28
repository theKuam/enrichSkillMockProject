package com.hainm.enrichskillmockproject.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.MaterialTheme
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.core.view.WindowCompat
import com.hainm.enrichskillmockproject.common.navigation.NewsAppNavHost
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMotionApi
@ExperimentalFoundationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MaterialTheme {
                NewsAppNavHost()
            }
        }
    }
}