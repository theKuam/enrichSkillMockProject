package com.hainm.enrichskillmockproject.core.network

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val newsDispatcher: NewsDispatchers)
enum class NewsDispatchers {
    Default,
    IO,
}