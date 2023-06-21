package com.hainm.enrichskillmockproject.ui.component.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hainm.enrichskillmockproject.ui.theme.Spacing

@ExperimentalFoundationApi
@Composable
fun HomeMainView(
    isCarouselAutoPlayed: State<Boolean>,
    onPlayButtonClicked: () -> Unit,
    onPauseButtonClicked: () -> Unit,
) {
    Column {
        Spacer(modifier = Modifier.height(Spacing.large))
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(ratio = 2f)
                .clip(shape = RoundedCornerShape(size = 24.dp))
                .background(color = Color.Yellow)
        ) {
            HomeCarousel(
                isCarouselAutoPlayed,
                onPlayButtonClicked,
                onPauseButtonClicked,
            )
        }
    }
}