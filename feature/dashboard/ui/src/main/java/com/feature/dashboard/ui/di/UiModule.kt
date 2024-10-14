package com.feature.dashboard.ui.di

import com.feature.dashboard.domain.use_cases.AddDiscountAndPromoUseCase
import com.feature.dashboard.domain.use_cases.AddPaymentCategoryUseCase
import com.feature.dashboard.domain.use_cases.AddUserInfoUseCase
import com.feature.dashboard.domain.use_cases.DeleteAllDiscountAndPromoUseCase
import com.feature.dashboard.domain.use_cases.DeleteAllPaymentCategoriesUseCase
import com.feature.dashboard.domain.use_cases.GetDiscountAndPromoUseCase
import com.feature.dashboard.domain.use_cases.GetPaymentCategoriesUseCase
import com.feature.dashboard.domain.use_cases.GetUserInfoUseCase
import com.feature.dashboard.ui.navigation.DashboardApi
import com.feature.dashboard.ui.navigation.DashboardApiImpl
import com.feature.dashboard.ui.screens.HomeScreenViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UiModule {

    @Provides
    fun provideDashboardApi():DashboardApi{
        return DashboardApiImpl()
    }

    @Provides
    fun provideHomeScreenViewModel(addUserInfoUserCase: AddUserInfoUseCase,
                                   getUserInfoUseCase: GetUserInfoUseCase,
                                   addPaymentCategoryUseCase: AddPaymentCategoryUseCase,
                                   getPaymentCategoriesUseCase: GetPaymentCategoriesUseCase,
                                   deleteAllPaymentCategoriesUseCase: DeleteAllPaymentCategoriesUseCase,
                                     addDiscountAndPromoUseCase: AddDiscountAndPromoUseCase,
                                     getDiscountAndPromoUseCase: GetDiscountAndPromoUseCase,
                                     deleteAllDiscountAndPromoUseCase: DeleteAllDiscountAndPromoUseCase
    ):HomeScreenViewModel{
        return HomeScreenViewModel(addUserInfoUserCase,getUserInfoUseCase,addPaymentCategoryUseCase,getPaymentCategoriesUseCase,deleteAllPaymentCategoriesUseCase,addDiscountAndPromoUseCase,getDiscountAndPromoUseCase,deleteAllDiscountAndPromoUseCase)
    }



}