package com.feature.payment.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

class PaymentApiImpl:PaymentApi {
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
       InternalPaymentFeatureApi.registerGraph(navController,navGraphBuilder)
    }
}