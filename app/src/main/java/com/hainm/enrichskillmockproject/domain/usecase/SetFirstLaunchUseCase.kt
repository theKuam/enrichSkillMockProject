package com.hainm.enrichskillmockproject.domain.usecase

import com.hainm.enrichskillmockproject.common.Outcome
import com.hainm.enrichskillmockproject.core.FlowUseCase
import com.hainm.enrichskillmockproject.di.coroutine.IoDispatcher
import com.hainm.enrichskillmockproject.domain.repository.SharedPreferenceRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

class SetFirstLaunchUseCase @Inject constructor(
    private val sharedPreferenceRepository: SharedPreferenceRepository,
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher,
) : FlowUseCase<Unit, Unit>(coroutineDispatcher) {
    override suspend fun execute(parameters: Unit): Flow<Outcome<Unit>> = flow {
        Timber.d("HaiNM18 hehehehe")
        val response = sharedPreferenceRepository.setFirstLaunch()
        emit(Outcome.Success(response))
    }
}
