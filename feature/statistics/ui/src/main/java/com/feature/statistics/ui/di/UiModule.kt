package com.feature.statistics.ui.di

import com.feature.statistics.ui.navigation.StatisticsApi
import com.feature.statistics.ui.navigation.StatisticsApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UiModule {
    @Provides
    fun provideStatisticsApi(): StatisticsApi {
        return StatisticsApiImpl()
    }
}