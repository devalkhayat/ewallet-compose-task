package com.example.ewallet.di

import com.example.ewallet.navigation.NavigationProvider
import com.feature.dashboard.ui.navigation.DashboardApi
import com.feature.notification.ui.navigation.NotificationApi
import com.feature.payment.ui.navigation.PaymentApi
import com.feature.profile.ui.navigation.ProfileApi
import com.feature.statistics.ui.navigation.StatisticsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideNavigationProvider(dashboardApi: DashboardApi,  statistics: StatisticsApi,
                                   payment: PaymentApi,
                                   notification: NotificationApi,
                                   profile: ProfileApi
    ):NavigationProvider{
        return NavigationProvider(dashboardApi,statistics,payment,notification,profile)
    }
}