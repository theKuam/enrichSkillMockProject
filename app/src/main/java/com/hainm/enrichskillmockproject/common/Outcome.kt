package com.hainm.enrichskillmockproject.common

sealed class Outcome<out T> {
    open val data: T? = null

    data class Success<out T>(override val data: T? = null) : Outcome<T>()

    data class Error(val throwable: Throwable) : Outcome<Nothing>() {
        constructor(message: String) : this(Throwable(message))
    }

    object Loading : Outcome<Nothing>()

    object NotLoading : Outcome<Nothing>()
}

val Outcome<*>.succeeded
    get() = this is Outcome.Success && data != null

val Outcome<*>.failed
    get() = this is Outcome.Error

val Outcome<*>.loading
    get() = this is Outcome.Loading
