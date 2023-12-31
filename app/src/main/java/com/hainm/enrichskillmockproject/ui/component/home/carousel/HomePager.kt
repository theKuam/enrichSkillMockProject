package com.hainm.enrichskillmockproject.ui.component.home.carousel

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import com.hainm.enrichskillmockproject.R
import com.hainm.enrichskillmockproject.common.util.CAROUSEL_AUTOPLAY_ANIMATING_DURATION
import com.hainm.enrichskillmockproject.common.util.CAROUSEL_AUTOPLAY_INTERVAL
import com.hainm.enrichskillmockproject.ui.theme.AppTextStyle
import com.hainm.enrichskillmockproject.ui.theme.HomeCarouselGradientGray
import com.hainm.enrichskillmockproject.ui.theme.HomeCarouselGradientLightGray
import com.hainm.enrichskillmockproject.ui.theme.HomeCarouselTitleCursorYellow
import com.hainm.enrichskillmockproject.ui.theme.Spacing
import kotlinx.coroutines.delay

@ExperimentalFoundationApi
@Composable
fun HomePager(
    isCarouselAutoPlayed: State<Boolean>,
    pagerState: PagerState,
) {
    HorizontalPager(
        state = pagerState,
    ) { pseudoIndex ->
        var key by remember { mutableStateOf(false) }
        val categoryList = stringArrayResource(id = R.array.article_categories)
        val pageCount = categoryList.size
        val index = pseudoIndex % pageCount
        val title = categoryList[index]
        val image = when (index) {
            0 -> painterResource(id = R.drawable.article_category_1)
            1 -> painterResource(id = R.drawable.article_category_2)
            2 -> painterResource(id = R.drawable.article_category_3)
            3 -> painterResource(id = R.drawable.article_category_4)
            else -> painterResource(id = R.drawable.article_category_1)
        }

        LaunchedEffect(key1 = isCarouselAutoPlayed.value, key2 = key) {
            delay(CAROUSEL_AUTOPLAY_INTERVAL)
            if (isCarouselAutoPlayed.value) {
                with(pagerState) {
                    val target = settledPage + 1
                    animateScrollToPage(
                        page = target,
                        animationSpec = tween(
                            durationMillis = CAROUSEL_AUTOPLAY_ANIMATING_DURATION,
                            easing = FastOutSlowInEasing,
                        )
                    )
                    key = !key
                }
            }
        }
        Box {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .drawWithCache {
                        val gradient = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                HomeCarouselGradientLightGray,
                                HomeCarouselGradientGray
                            ),
                            startY = 0f,
                            endY = size.height,
                            tileMode = TileMode.Clamp,
                        )
                        onDrawWithContent {
                            drawContent()
                            drawRect(gradient, blendMode = BlendMode.SrcOver)
                        }
                    },
                painter = image,
                contentDescription = "thumbnail $index",
                contentScale = ContentScale.Crop,
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = Spacing.medium, vertical = Spacing.extraLarge),
            ) {
                Box(
                    modifier = Modifier
                        .wrapContentHeight()
                        .align(Alignment.BottomStart),
                ) {
                    Box(
                        modifier = Modifier
                            .height(Spacing.large)
                            .width(Spacing.small)
                            .background(color = HomeCarouselTitleCursorYellow),
                    )

                    Text(
                        modifier = Modifier
                            .padding(start = Spacing.extraSmall)
                            .align(Alignment.Center),
                        text = title.toUpperCase(Locale.current),
                        style = AppTextStyle.HomeCarouselTitle,
                    )
                }
            }
        }
    }
}