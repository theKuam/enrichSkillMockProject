package com.hainm.enrichskillmockproject.ui.component.home

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import com.hainm.enrichskillmockproject.common.Outcome
import com.hainm.enrichskillmockproject.common.util.CAROUSEL_AUTOPLAY_ANIMATING_DURATION
import com.hainm.enrichskillmockproject.common.util.CAROUSEL_PAGE_COUNT
import com.hainm.enrichskillmockproject.data.model.Articles

@ExperimentalFoundationApi
@Composable
fun HomeViewPager(
    pagerState: PagerState,
    isCarouselAutoPlayed: State<Boolean>,
    onPlayButtonClicked: () -> Unit,
    onPauseButtonClicked: () -> Unit,
    articles: State<Outcome<Articles>>,
    onCategoryChange: (String) -> Unit,
    onSubCategoryChange: (String) -> Unit,
    tabIndex: Int,
    isTabSelected: Boolean,
) {
    HorizontalPager(
        state = pagerState,
        pageCount = CAROUSEL_PAGE_COUNT,
    ) { index ->
        LaunchedEffect(key1 = isTabSelected) {
            with(pagerState) {
                animateScrollToPage(
                    page = tabIndex,
                    animationSpec = tween(
                        durationMillis = CAROUSEL_AUTOPLAY_ANIMATING_DURATION,
                        easing = FastOutSlowInEasing,
                    )
                )
            }
        }
        if (index == 0) {
            HomeMainView(
                isCarouselAutoPlayed,
                { onPlayButtonClicked() },
                { onPauseButtonClicked() },
                articles,
                onCategoryChange,
                onSubCategoryChange,
            )
        } else {
            HomeBlankView(pagerState.currentPage)
        }
    }
}