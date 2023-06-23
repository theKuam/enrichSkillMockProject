package com.hainm.enrichskillmockproject.ui.component.common.hometab

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection

class HomeTabIndicatorShape(private val cornerRadius: Dp) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density,
    ): Outline {
        return Outline.Generic(
            path = drawIndicatorPath(
                size = size,
                cornerRadius = with(density) { cornerRadius.toPx() })
        )
    }

    private fun drawIndicatorPath(size: Size, cornerRadius: Float): Path {
        if (size.width < size.height) return Path().apply {
            reset()
            lineTo(0f, size.height)
        }
        return Path().apply {
            reset()
            // top left arc
            arcTo(
                rect = Rect(
                    left = 0f,
                    top = 0f,
                    right = 2 * cornerRadius,
                    bottom = 2 * cornerRadius,
                ),
                startAngleDegrees = -90f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false,
            )
            lineTo(x = 2 * cornerRadius, y = size.height - cornerRadius)
            // bottom left arc
            arcTo(
                rect = Rect(
                    left = 2 * cornerRadius,
                    top = size.height - 3 * cornerRadius,
                    right = 4 * cornerRadius,
                    bottom = size.height - cornerRadius,
                ),
                startAngleDegrees = 180f,
                sweepAngleDegrees = -90f,
                forceMoveTo = false,
            )
            lineTo(x = size.width - 3 * cornerRadius, y = size.height - cornerRadius)
            // bottom right arc
            arcTo(
                rect = Rect(
                    left = size.width - 4 * cornerRadius,
                    top = size.height - 3 * cornerRadius,
                    right = size.width - 2 * cornerRadius,
                    bottom = size.height - cornerRadius,
                ),
                startAngleDegrees = 90f,
                sweepAngleDegrees = -90f,
                forceMoveTo = false,
            )
            lineTo(x = size.width - 2 * cornerRadius, y = cornerRadius)
            // top right arc
            arcTo(
                rect = Rect(
                    left = size.width - 2 * cornerRadius,
                    top = 0f,
                    right = size.width,
                    bottom = 2 * cornerRadius,
                ),
                startAngleDegrees = 180f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false,
            )
            lineTo(x = 0f, y = 0f)
            close()
        }
    }
}
