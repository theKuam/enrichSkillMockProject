package com.hainm.enrichskillmockproject.di.repository

import com.hainm.enrichskillmockproject.data.repository.SharedPreferenceRepositoryImpl
import com.hainm.enrichskillmockproject.domain.repository.SharedPreferenceRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SharedPreferenceModule {
    @Binds
    abstract fun provideSharedPreferenceRepository(
        sharedPreferenceRepositoryImpl: SharedPreferenceRepositoryImpl,
    ): SharedPreferenceRepository
}