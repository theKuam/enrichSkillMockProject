package com.hainm.enrichskillmockproject.ui.component.common.hometab

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.hainm.enrichskillmockproject.ui.theme.AppTextStyle.HomeCategoryTitle
import com.hainm.enrichskillmockproject.ui.theme.Spacing

@Composable
fun HomeTabTitle(
    title: String,
    position: Int,
    onClick: (Int) -> Unit,
) {
    Text(
        modifier = Modifier
            .wrapContentWidth(Alignment.CenterHorizontally)
            .padding(
                horizontal = Spacing.small,
                vertical = Spacing.extraSmall,
            )
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
            ) { onClick(position) },
        text = title,
        style = HomeCategoryTitle,
    )
}