package com.hainm.enrichskillmockproject.common.util

const val CAROUSEL_PAGE_COUNT = 4
const val EMPTY_STRING = ""

const val CAROUSEL_AUTOPLAY_INTERVAL = 10_000L
const val CAROUSEL_AUTOPLAY_ANIMATING_DURATION = 1_000
const val TAB_INDICATOR_ANIMATING_DURATION = 250


object Category {
    const val DEFAULT = EMPTY_STRING
    const val GENERAL = "general"
    const val WORLD = "world"
    const val SCIENCE = "science"
}

object SubCategory {
    const val DEFAULT = EMPTY_STRING
    const val SCIENCE = "science"
    const val ENVIRONMENT = "environment"
    const val ANIMAL = "animals"
    const val TRAVEL = "travel"
}

enum class SubComposableId {
    PRECALCULATE_ITEM,
    ITEM,
    INDICATOR,
}