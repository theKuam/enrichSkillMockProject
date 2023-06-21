package com.hainm.enrichskillmockproject.ui.component.common

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.hainm.enrichskillmockproject.R
import com.hainm.enrichskillmockproject.common.util.CAROUSEL_PAGE_COUNT
import com.hainm.enrichskillmockproject.ui.theme.IndicatorGray
import com.hainm.enrichskillmockproject.ui.theme.IndicatorGreen
import com.hainm.enrichskillmockproject.ui.theme.Spacing

@ExperimentalFoundationApi
@Composable
fun RowScope.AppIndicator(
    pagerState: PagerState,
    height: Dp,
    currentSize: Dp,
    normalSize: Dp,
    horizontalArrangement: Arrangement.Horizontal,
) {
    Row(
        modifier = Modifier
            .height(height)
            .align(Alignment.CenterVertically),
        horizontalArrangement = horizontalArrangement,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        repeat(CAROUSEL_PAGE_COUNT) { iteration ->
            val currentIndex = pagerState.currentPage % CAROUSEL_PAGE_COUNT
            val (size, color) = if (currentIndex == iteration) currentSize to IndicatorGreen else normalSize to IndicatorGray
            Box(
                modifier = Modifier
                    .padding(Spacing.extraSmall)
                    .clip(CircleShape)
                    .background(color)
                    .size(size)
            ) {
                if (currentIndex == iteration) {
                    Image(
                        painter = painterResource(id = R.drawable.indicator_right_24),
                        contentDescription = "indicator",
                    )
                }
            }
        }
    }
}