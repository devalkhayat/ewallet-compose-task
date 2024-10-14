package com.feature.payment.ui.di

import com.feature.payment.ui.navigation.PaymentApi
import com.feature.payment.ui.navigation.PaymentApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UiModule {

    @Provides
    fun providePaymentApi(): PaymentApi {
        return PaymentApiImpl()
    }
}