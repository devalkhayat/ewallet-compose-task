package com.feature.dashboard.data.di

import com.core.datasource.AppDatabase
import com.feature.dashboard.data.repo.DiscountAndPromoRepoImpl
import com.feature.dashboard.data.repo.PaymentCategoriesRepoImpl
import com.feature.dashboard.data.repo.UserInfoRepoImpl
import com.feature.dashboard.domain.repo.DiscountAndPromoRepository
import com.feature.dashboard.domain.repo.PaymentCategoriesRepository
import com.feature.dashboard.domain.repo.UserInfoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataLayerModule {


    @Provides
    fun provideUserRepo(db:AppDatabase):UserInfoRepository{
        return  UserInfoRepoImpl(db)
    }

    @Provides
    fun providePaymentCategoriesRepo(db:AppDatabase):PaymentCategoriesRepository{
        return PaymentCategoriesRepoImpl(db)
    }

    @Provides
    fun provideDiscountAndPromoRepo(db:AppDatabase):DiscountAndPromoRepository{
        return DiscountAndPromoRepoImpl(db)
    }
}