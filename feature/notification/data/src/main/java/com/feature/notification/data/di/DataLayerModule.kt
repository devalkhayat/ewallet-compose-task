package com.feature.notification.data.di

import com.core.datasource.AppDatabase
import com.feature.notification.data.repo.NotificationsRepoImpl
import com.feature.notification.domain.repo.NotificationsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataLayerModule {
    @Provides
    fun provideNotificationsRepository(db:AppDatabase):NotificationsRepository{
        return NotificationsRepoImpl(db)
    }
}