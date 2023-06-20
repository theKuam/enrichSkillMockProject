package com.hainm.enrichskillmockproject.common

sealed class Outcome<out T> {
    open val data: T? = null

    data class Success<out T>(override val data: T? = null) : Outcome<T>()

    data class Error(val throwable: Throwable) : Outcome<Nothing>() {
        constructor(message: String) : this(Throwable(message))
    }
}

val Outcome<*>.succeeded
    get() = this is Outcome.Success && data != null

val Outcome<*>.failed
    get() = this is Outcome.Error
