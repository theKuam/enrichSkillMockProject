package com.hainm.enrichskillmockproject.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber
import com.hainm.enrichskillmockproject.common.Outcome

abstract class FlowUseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {
    suspend operator fun invoke(parameters: P): Flow<Outcome<R>> = execute(parameters)
        .catch {  exception ->
            Timber.e(exception)
            emit(Outcome.Error(exception))
        }
        .flowOn(coroutineDispatcher)

    protected abstract suspend fun execute(parameters: P): Flow<Outcome<R>>
}