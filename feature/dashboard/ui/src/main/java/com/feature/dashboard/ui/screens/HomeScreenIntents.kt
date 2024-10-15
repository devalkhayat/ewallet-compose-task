package com.feature.dashboard.ui.screens

import com.feature.dashboard.domain.model.PaymentCategory
import com.feature.dashboard.domain.model.User

sealed class HomeScreenIntents {


    data object InitData:HomeScreenIntents()
    data object GetData:HomeScreenIntents()


}