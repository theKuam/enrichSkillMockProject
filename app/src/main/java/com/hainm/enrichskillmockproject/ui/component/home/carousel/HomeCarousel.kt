package com.hainm.enrichskillmockproject.ui.component.home.carousel

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.hainm.enrichskillmockproject.ui.component.common.AppIndicator
import com.hainm.enrichskillmockproject.ui.theme.Spacing

@ExperimentalFoundationApi
@Composable
fun HomeCarousel(
    pagerState: PagerState,
    isCarouselAutoPlayed: State<Boolean>,
    onPlayButtonClicked: () -> Unit,
    onPauseButtonClicked: () -> Unit,
) {
    Box {
        HomePager(
            isCarouselAutoPlayed,
            pagerState,
        )

        HomeAutoPlayButton(
            isCarouselAutoPlayed,
            onPlayButtonClicked,
            onPauseButtonClicked,
        )

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter),
        ) {
            AppIndicator(
                pagerState,
                Spacing.extraLarge,
                Spacing.smallMedium,
                Spacing.small,
                Arrangement.Center,
            )
        }
    }
}