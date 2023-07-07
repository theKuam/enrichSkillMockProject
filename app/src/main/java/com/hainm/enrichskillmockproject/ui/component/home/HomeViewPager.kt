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
import com.hainm.enrichskillmockproject.domain.model.Article
import com.hainm.enrichskillmockproject.ui.model.ArticleModel

@ExperimentalFoundationApi
@Composable
fun HomeViewPager(
    pagerState: PagerState,
    isCarouselAutoPlayed: State<Boolean>,
    onPlayButtonClicked: () -> Unit,
    onPauseButtonClicked: () -> Unit,
    articles: State<Outcome<List<Article>>>,
    onCategoryChange: (String) -> Unit,
    onSubCategoryChange: (String) -> Unit,
    tabIndex: Int,
    isTabSelected: Boolean,
    onNavigate: (ArticleModel) -> Unit,
) {
    HorizontalPager(
        state = pagerState,
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
                onNavigate,
            )
        } else {
            HomeBlankView(pagerState.currentPage)
        }
    }
}