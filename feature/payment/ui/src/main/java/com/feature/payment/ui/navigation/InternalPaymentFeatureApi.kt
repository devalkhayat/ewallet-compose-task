package com.feature.payment.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.core.feature_api.PaymentFeatureRoutes
import com.core.feature_api.FeatureApi
import com.feature.payment.ui.screens.ConfirmScreen
import com.feature.payment.ui.screens.HomeScreen
import com.feature.payment.ui.screens.PaymentReceiptScreen
import com.feature.payment.ui.screens.SummaryScreen

internal object InternalPaymentFeatureApi: FeatureApi {
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.navigation(startDestination = PaymentFeatureRoutes.homeScreenRoute, route = PaymentFeatureRoutes.nestedRoute) {
            composable(PaymentFeatureRoutes.homeScreenRoute) {
                HomeScreen(navController)
            }
            composable(PaymentFeatureRoutes.summaryScreenRoute) {
                SummaryScreen(navController)
            }
            composable(PaymentFeatureRoutes.confirmIdentityRoute) {
                ConfirmScreen(navController)
            }
            composable(PaymentFeatureRoutes.paymentReceiptRoute) {
                PaymentReceiptScreen(navController)
            }
        }
    }
}