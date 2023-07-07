package com.hainm.enrichskillmockproject.ui.component.article.body

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import com.hainm.enrichskillmockproject.ui.theme.Spacing

@Composable
fun BodyDraggableBar(textColor: Color) {
    Box(
        modifier = Modifier
            .width(64.dp)
            .padding(vertical = Spacing.small)
            .layoutId("draggableBar"),
    ) {
        Divider(
            color = textColor,
            thickness = Spacing.extraSmall,
        )
    }
}