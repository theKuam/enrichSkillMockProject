package com.hainm.enrichskillmockproject.ui.component.welcome

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@ExperimentalFoundationApi
@Composable
fun WelcomeCarousel(
    modifier: Modifier = Modifier,
    onPageChanged: (Float) -> Unit,
    onNavigate: () -> Unit,
) {
    val pagerState = rememberPagerState()
    WelcomePager(
        modifier,
        pagerState,
        onPageChanged,
    )
    WelcomeBottomPart(
        modifier,
        pagerState,
        onNavigate,
    )
}
