package com.feature.dashboard.ui.screens

import com.feature.dashboard.domain.model.PaymentCategory
import com.feature.dashboard.domain.model.User

sealed class HomeScreenIntents {


    data object InitUserData:HomeScreenIntents()
    data object  GetUserData:HomeScreenIntents()

    data object InitPaymentCategoriesData:HomeScreenIntents()
    data object  GetPaymentCategories:HomeScreenIntents()

    data object InitDiscountAndPromoData:HomeScreenIntents()
    data object  GetDiscountAndPromo:HomeScreenIntents()

}