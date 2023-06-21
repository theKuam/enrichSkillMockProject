package com.hainm.enrichskillmockproject.ui.component.welcome

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.hainm.enrichskillmockproject.R
import com.hainm.enrichskillmockproject.common.util.CAROUSEL_PAGE_COUNT
import com.hainm.enrichskillmockproject.ui.theme.AppTextStyle
import com.hainm.enrichskillmockproject.ui.theme.ButtonGray
import com.hainm.enrichskillmockproject.ui.theme.IndicatorGreen
import com.hainm.enrichskillmockproject.ui.theme.Spacing

@ExperimentalFoundationApi
@Composable
fun RowScope.WelcomeButton(
    pagerState: PagerState,
    onNavigate: () -> Unit,
) {
    if (pagerState.currentPage == CAROUSEL_PAGE_COUNT - 1) {
        Row(
            modifier = Modifier
                .wrapContentWidth()
                .height(60.dp)
                .background(
                    Color.White,
                    shape = RoundedCornerShape(Spacing.smallMedium),
                )
                .drawWithCache {
                    val gradient = Brush.horizontalGradient(
                        colors = listOf(ButtonGray, Color.Black),
                        startX = 0f,
                        endX = size.width * 3 / 4,
                        tileMode = TileMode.Clamp,
                    )
                    onDrawWithContent {
                        drawRect(gradient, blendMode = BlendMode.Multiply)
                        drawContent()
                    }
                }
                .padding(
                    horizontal = Spacing.small,
                    vertical = Spacing.smallMedium,
                )
                .align(Alignment.CenterVertically)
                .clickable { onNavigate() },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Get Started",
                color = Color.White,
                style = AppTextStyle.WelcomeButton,
            )
            Spacer(modifier = Modifier.width(Spacing.extraLarge))
            Image(
                modifier = Modifier
                    .size(36.dp)
                    .background(
                        color = IndicatorGreen,
                        shape = RoundedCornerShape(Spacing.smallMedium),
                    ),
                painter = painterResource(id = R.drawable.indicator_right_24),
                contentDescription = "button indicator",
                colorFilter = ColorFilter.tint(color = Color.White),
            )
        }
    }
}