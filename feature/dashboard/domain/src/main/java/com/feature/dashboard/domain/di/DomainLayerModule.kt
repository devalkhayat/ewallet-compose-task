package com.feature.dashboard.domain.di

import com.feature.dashboard.domain.repo.DiscountAndPromoRepository
import com.feature.dashboard.domain.repo.PaymentCategoriesRepository
import com.feature.dashboard.domain.repo.UserInfoRepository
import com.feature.dashboard.domain.use_cases.AddDiscountAndPromoUseCase
import com.feature.dashboard.domain.use_cases.AddPaymentCategoryUseCase
import com.feature.dashboard.domain.use_cases.AddUserInfoUseCase
import com.feature.dashboard.domain.use_cases.DeleteAllDiscountAndPromoUseCase
import com.feature.dashboard.domain.use_cases.DeleteAllPaymentCategoriesUseCase
import com.feature.dashboard.domain.use_cases.GetDiscountAndPromoUseCase
import com.feature.dashboard.domain.use_cases.GetPaymentCategoriesUseCase
import com.feature.dashboard.domain.use_cases.GetUserInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainLayerModule {

    @Provides
    fun provideGetUserInfoUseCase(userInfoRepository: UserInfoRepository):GetUserInfoUseCase{
        return GetUserInfoUseCase(userInfoRepository)
    }

    @Provides
    fun provideAddUserInfoUserCase(userInfoRepository: UserInfoRepository):AddUserInfoUseCase{
        return AddUserInfoUseCase(userInfoRepository)
    }


    @Provides
    fun provideGetPaymentCategoriesUseCase(paymentCategoriesRepository: PaymentCategoriesRepository):GetPaymentCategoriesUseCase{
        return GetPaymentCategoriesUseCase(paymentCategoriesRepository)
    }

    @Provides
    fun provideAddPaymentCategoryUseCase(paymentCategoriesRepository: PaymentCategoriesRepository):AddPaymentCategoryUseCase{
        return AddPaymentCategoryUseCase(paymentCategoriesRepository)
    }

    @Provides
    fun provideDeleteAllPaymentCategoriesUseCase(paymentCategoriesRepository: PaymentCategoriesRepository):DeleteAllPaymentCategoriesUseCase{
        return DeleteAllPaymentCategoriesUseCase(paymentCategoriesRepository)
    }


    @Provides
    fun provideGetDiscountAndPromoUseCase(discountAndPromoRepository: DiscountAndPromoRepository): GetDiscountAndPromoUseCase {
        return GetDiscountAndPromoUseCase(discountAndPromoRepository)
    }
    @Provides
    fun provideAddDiscountAndPromoUseCase(discountAndPromoRepository: DiscountAndPromoRepository): AddDiscountAndPromoUseCase {
        return AddDiscountAndPromoUseCase(discountAndPromoRepository)
    }
    @Provides
    fun provideDeleteAllDiscountAndPromoUseCase(discountAndPromoRepository: DiscountAndPromoRepository): DeleteAllDiscountAndPromoUseCase {
        return DeleteAllDiscountAndPromoUseCase(discountAndPromoRepository)
    }
}