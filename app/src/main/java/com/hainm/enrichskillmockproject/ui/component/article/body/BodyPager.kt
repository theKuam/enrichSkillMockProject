package com.hainm.enrichskillmockproject.ui.component.article.body

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.hainm.enrichskillmockproject.common.util.CAROUSEL_AUTOPLAY_ANIMATING_DURATION
import com.hainm.enrichskillmockproject.common.util.CONTENT_PAGE_COUNT
import com.hainm.enrichskillmockproject.data.model.Article
import com.hainm.enrichskillmockproject.ui.theme.AppBackgroundUpper
import com.hainm.enrichskillmockproject.ui.theme.Spacing

@ExperimentalFoundationApi
@Composable
fun BodyPager(
    pagerState: PagerState,
    currentIndex: Int,
    article: Article,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = AppBackgroundUpper,
                shape = RoundedCornerShape(
                    topStart = Spacing.large,
                    topEnd = Spacing.large,
                )
            )
    ) {
        HorizontalPager(
            state = pagerState,
            userScrollEnabled = false,
            pageCount = CONTENT_PAGE_COUNT
        ) { index ->
            LaunchedEffect(key1 = currentIndex) {
                with(pagerState) {
                    val target = currentIndex
                    animateScrollToPage(
                        page = target,
                        animationSpec = tween(
                            durationMillis = CAROUSEL_AUTOPLAY_ANIMATING_DURATION,
                            easing = FastOutSlowInEasing,
                        )
                    )
                }
            }
            when (index) {
                0 -> {
                    BodyOverview(article)
                }

                1 -> {
                    BodyAlbum(article)
                }

                2 -> {}
                else -> {}
            }
        }
    }
}