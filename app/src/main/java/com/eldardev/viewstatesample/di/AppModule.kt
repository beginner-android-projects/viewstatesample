package com.eldardev.viewstatesample.di

import com.eldardev.viewstatesample.main.MainUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideString() = "string from app module"

    @Provides
    fun provideMainUseCase() = MainUseCase()
}