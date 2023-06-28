package com.hainm.enrichskillmockproject.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import com.hainm.enrichskillmockproject.R
import com.hainm.enrichskillmockproject.core.BaseScreen
import com.hainm.enrichskillmockproject.ui.component.common.LoadingView
import com.hainm.enrichskillmockproject.ui.theme.AppBackgroundLower
import com.hainm.enrichskillmockproject.ui.theme.AppBackgroundMiddle
import com.hainm.enrichskillmockproject.ui.theme.AppBackgroundUpper
import com.hainm.enrichskillmockproject.ui.theme.Spacing

@Composable
fun LoadingScreen() {
    BaseScreen {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        0.0f to AppBackgroundUpper,
                        0.5f to AppBackgroundUpper,
                        0.75f to AppBackgroundMiddle,
                        1f to AppBackgroundLower,
                    )
                )
                .statusBarsPadding()
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.Center),
                verticalArrangement = Arrangement.spacedBy(Spacing.medium),
            ) {
                Image(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    painter = painterResource(
                        id = R.drawable.news
                    ),
                    contentDescription = "app icon"
                )

                LoadingView()
            }
        }
    }
}