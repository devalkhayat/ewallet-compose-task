package com.feature.dashboard.ui.screens

import com.core.common.UiEvent
import com.feature.dashboard.domain.model.DiscountAndPromo
import com.feature.dashboard.domain.model.PaymentCategory
import com.feature.dashboard.domain.model.User

sealed class HomeScreenStateView {

    data class  UserSavedSuccessfully(val message: String):HomeScreenStateView()
    data class  DataUserResult(val result: User):HomeScreenStateView()

    data class  PaymentCategoriesSavedSuccessfully(val message: String):HomeScreenStateView()
    data class  DataPaymentCategoriesResult(val result: List<PaymentCategory>):HomeScreenStateView()

    data class  DataDiscountAndPromoResult(val result: List<DiscountAndPromo>):HomeScreenStateView()
    data class  DiscountAndPromoSavedSuccessfully(val message: String):HomeScreenStateView()

    data class  Error(val message:String):HomeScreenStateView()

}