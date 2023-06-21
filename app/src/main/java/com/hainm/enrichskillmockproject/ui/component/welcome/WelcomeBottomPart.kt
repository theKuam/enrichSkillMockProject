package com.hainm.enrichskillmockproject.ui.component.welcome

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hainm.enrichskillmockproject.ui.component.common.AppIndicator
import com.hainm.enrichskillmockproject.ui.theme.Spacing

@ExperimentalFoundationApi
@Composable
fun WelcomeBottomPart(
    modifier: Modifier,
    pagerState: PagerState,
    onNavigate: () -> Unit,
) {
    Row(
        modifier = modifier
            .padding(vertical = 60.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Bottom),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            AppIndicator(
                pagerState,
                60.dp,
                Spacing.medium,
                Spacing.small,
                Arrangement.Start,
            )
            WelcomeButton(
                pagerState,
                onNavigate,
            )
        }
    }
}