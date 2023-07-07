package com.hainm.enrichskillmockproject.ui.component.article.body

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import com.hainm.enrichskillmockproject.common.util.CAROUSEL_AUTOPLAY_ANIMATING_DURATION
import com.hainm.enrichskillmockproject.ui.model.ArticleModel
import com.hainm.enrichskillmockproject.ui.theme.Spacing

@ExperimentalFoundationApi
@Composable
fun BodyPager(
    pagerState: PagerState,
    currentIndex: Int,
    article: ArticleModel,
    bodyPagerBg: Color,
    textColor: Color,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = bodyPagerBg,
                shape = RoundedCornerShape(
                    topStart = Spacing.large,
                    topEnd = Spacing.large,
                )
            )
            .layoutId("bodyPager"),
    ) {
        HorizontalPager(
            state = pagerState,
            userScrollEnabled = false
        ) { index ->
            LaunchedEffect(key1 = currentIndex) {
                with(pagerState) {
                    animateScrollToPage(
                        page = currentIndex,
                        animationSpec = tween(
                            durationMillis = CAROUSEL_AUTOPLAY_ANIMATING_DURATION,
                            easing = FastOutSlowInEasing,
                        )
                    )
                }
            }
            when (index) {
                0 -> {
                    BodyOverview(
                        article,
                        textColor,
                    )
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
