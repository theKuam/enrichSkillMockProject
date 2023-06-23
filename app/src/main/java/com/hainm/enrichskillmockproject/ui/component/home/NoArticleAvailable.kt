package com.hainm.enrichskillmockproject.ui.component.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.hainm.enrichskillmockproject.R
import com.hainm.enrichskillmockproject.ui.theme.AppTextStyle
import com.hainm.enrichskillmockproject.ui.theme.Spacing

@Composable
fun NoArticleAvailable() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = Spacing.extraLarge),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(id = R.string.no_article_available),
            style = AppTextStyle.NunitoMediumText,
        )
    }
}