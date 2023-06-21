package com.hainm.enrichskillmockproject.ui.component.welcome

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
import androidx.compose.ui.unit.dp
import com.hainm.enrichskillmockproject.R
import com.hainm.enrichskillmockproject.common.util.CAROUSEL_PAGE_COUNT
import com.hainm.enrichskillmockproject.ui.theme.IndicatorGray
import com.hainm.enrichskillmockproject.ui.theme.IndicatorGreen
import com.hainm.enrichskillmockproject.ui.theme.Spacing

@ExperimentalFoundationApi
@Composable
fun RowScope.WelcomeIndicator(pagerState: PagerState) {
    Row(
        modifier = Modifier
            .height(60.dp)
            .align(Alignment.CenterVertically),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        repeat(CAROUSEL_PAGE_COUNT) { iteration ->
            val (size, color) = if (pagerState.currentPage == iteration) Spacing.medium to IndicatorGreen else Spacing.small to IndicatorGray
            Box(
                modifier = Modifier
                    .padding(Spacing.extraSmall)
                    .clip(CircleShape)
                    .background(color)
                    .size(size)
            ) {
                if (pagerState.currentPage == iteration) {
                    Image(
                        painter = painterResource(id = R.drawable.indicator_right_24),
                        contentDescription = "indicator",
                    )
                }
            }
        }
    }
}