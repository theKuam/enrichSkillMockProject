package com.hainm.enrichskillmockproject.ui.component.welcome

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hainm.enrichskillmockproject.common.util.CAROUSEL_PAGE_COUNT

@ExperimentalFoundationApi
@Composable
fun WelcomeCarousel(
    modifier: Modifier = Modifier,
    onPageChanged: (Float) -> Unit,
    onNavigate: () -> Unit,
) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        CAROUSEL_PAGE_COUNT
    }

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
