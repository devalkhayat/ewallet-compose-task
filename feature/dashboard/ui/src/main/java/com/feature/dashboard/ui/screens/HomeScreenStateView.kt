package com.feature.dashboard.ui.screens

import com.core.common.UiEvent
import com.feature.dashboard.domain.model.DiscountAndPromo
import com.feature.dashboard.domain.model.PaymentCategory
import com.feature.dashboard.domain.model.User

sealed class HomeScreenStateView {

    data class  SavedSuccessfully(val message: String):HomeScreenStateView()

    data class  DataResult(val userInfo: User,val paymentCategoriesList: List<PaymentCategory>,val discountAndPromoList: List<DiscountAndPromo>):HomeScreenStateView()



    data class  Error(val message:String):HomeScreenStateView()

}