package com.hainm.enrichskillmockproject.ui.component.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.hainm.enrichskillmockproject.R
import com.hainm.enrichskillmockproject.ui.theme.PlayPauseButtonGray
import com.hainm.enrichskillmockproject.ui.theme.Spacing

@Composable
fun HomeAutoPlayButton(
    isCarouselAutoPlayed: State<Boolean>,
    onPlayButtonClicked: () -> Unit,
    onPauseButtonClicked: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(Spacing.medium),
    ) {
        Box(
            modifier = Modifier
                .size(Spacing.large)
                .background(
                    color = PlayPauseButtonGray,
                    shape = CircleShape,
                )
                .align(Alignment.TopStart)
                .clickable {
                    if (isCarouselAutoPlayed.value)
                        onPauseButtonClicked()
                    else
                        onPlayButtonClicked()
                },
        ) {
            Image(
                modifier = Modifier
                    .size(Spacing.smallMedium)
                    .align(Alignment.Center),
                painter = if (isCarouselAutoPlayed.value)
                    painterResource(id = R.drawable.pause_24)
                else
                    painterResource(id = R.drawable.play_24),
                contentDescription = "play/pause",
            )
        }
    }
}
