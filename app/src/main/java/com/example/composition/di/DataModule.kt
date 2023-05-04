package com.example.composition.di

import com.example.composition.data.GameRepositoryImpl
import com.example.composition.domain.repository.GameRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsGameRepository(impl: GameRepositoryImpl) : GameRepository
}