package com.feature.notification.domain.di

import com.feature.notification.domain.repo.NotificationsRepository
import com.feature.notification.domain.use_cases.AddNotificationUseCase
import com.feature.notification.domain.use_cases.DeleteAllNotificationsUseCase
import com.feature.notification.domain.use_cases.GetNotificationsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainLayerModule {

    @Provides
    fun provideAddNotificationUseCase(notificationsRepository: NotificationsRepository): AddNotificationUseCase {
        return AddNotificationUseCase(notificationsRepository)
    }
    @Provides
    fun provideGetNotificationUseCase(notificationsRepository: NotificationsRepository): GetNotificationsUseCase {
return GetNotificationsUseCase(notificationsRepository)
    }

    @Provides
    fun provideDeleteAllNotificationsUseCase(notificationsRepository: NotificationsRepository): DeleteAllNotificationsUseCase {
         return DeleteAllNotificationsUseCase(notificationsRepository)
    }
}