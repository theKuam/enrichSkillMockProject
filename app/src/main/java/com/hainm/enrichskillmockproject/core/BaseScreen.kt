package com.hainm.enrichskillmockproject.core

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hainm.enrichskillmockproject.ui.theme.Spacing

@Composable
fun BaseScreen(
    screenTitle: String,
    nextScreenTitle: String = "",
    onNavigate: (() -> Unit)? = null,
) {

    Surface(modifier = Modifier.fillMaxSize()) {
        Text(text = screenTitle)
        Spacer(modifier = Modifier.height(Spacing.small))
        onNavigate?.let {
            Button(onClick = it) {
                Text(text = nextScreenTitle)
            }
        }
    }
}