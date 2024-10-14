package com.feature.notification.ui.di

import com.feature.notification.domain.repo.NotificationsRepository
import com.feature.notification.domain.use_cases.AddNotificationUseCase
import com.feature.notification.domain.use_cases.DeleteAllNotificationsUseCase
import com.feature.notification.domain.use_cases.GetNotificationsUseCase
import com.feature.notification.ui.navigation.NotificationApi
import com.feature.notification.ui.navigation.NotificationApiImpl
import com.feature.notification.ui.screens.HomeScreenViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UiModule {

    @Provides
    fun provideDashboardApi(): NotificationApi {
        return NotificationApiImpl()
    }

    @Provides
    fun provideHomeScreenViewModel(
        addNotificationUseCase: AddNotificationUseCase,
        getNotificationsUseCase: GetNotificationsUseCase,
        deleteAllNotificationsUseCase: DeleteAllNotificationsUseCase
    ): HomeScreenViewModel {
        return HomeScreenViewModel(
            addNotificationUseCase,
            getNotificationsUseCase,
            deleteAllNotificationsUseCase
        )
    }
}