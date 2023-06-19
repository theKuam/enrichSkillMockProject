package com.hainm.enrichskillmockproject.common

sealed class Result<out T> {
    open val data: T? = null

    data class Success<out T>(override val data: T? = null) : Result<T>()

    data class Error(val throwable: Throwable) : Result<Nothing>() {
        constructor(message: String) : this(Throwable(message))
    }
}
val Result<*>.succeeded
    get() = this is Result.Success && data != null

val Result<*>.failed
    get() = this is Result.Error
