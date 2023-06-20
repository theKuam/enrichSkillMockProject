package com.hainm.enrichskillmockproject.ui.component.common

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import kotlin.math.roundToInt

class CarouselAlignment(private val ratio: Float) : Alignment {
    override fun align(size: IntSize, space: IntSize, layoutDirection: LayoutDirection): IntOffset {
        val startX = 0f
        val centerY = (space.height - size.height).toFloat() / 2f
        val horizontalShift = (space.width - size.width).toFloat() * ratio
        val shiftedX = startX + horizontalShift
        return IntOffset(shiftedX.roundToInt(), centerY.roundToInt())
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun animateAlignmentAsState(ratio: Float): State<CarouselAlignment> {
    val widthRatio by animateFloatAsState(ratio)
    return derivedStateOf { CarouselAlignment(widthRatio) }
}