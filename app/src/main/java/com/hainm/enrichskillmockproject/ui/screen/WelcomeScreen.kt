package com.hainm.enrichskillmockproject.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.hainm.enrichskillmockproject.core.BaseScreen
import com.hainm.enrichskillmockproject.ui.component.welcome.WelcomeCarousel
import com.hainm.enrichskillmockproject.ui.component.welcome.WelcomeThumbnail
import com.hainm.enrichskillmockproject.ui.theme.Spacing

@ExperimentalFoundationApi
@Composable
fun WelcomeScreen(onNavigate: () -> Unit) {
    BaseScreen {
        var ratio by remember { mutableFloatStateOf(0f) }

        WelcomeThumbnail(ratio)

        WelcomeCarousel(
            modifier = Modifier
                .padding(
                    start = Spacing.extraLarge,
                    end = Spacing.smallMedium,
                ),
            onPageChanged = { ratio = it },
            onNavigate = onNavigate,
        )
    }
}
