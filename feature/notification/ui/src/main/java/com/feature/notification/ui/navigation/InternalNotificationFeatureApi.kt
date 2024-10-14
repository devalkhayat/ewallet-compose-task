package com.feature.notification.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.core.feature_api.NotificationFeatureRoutes
import com.core.feature_api.FeatureApi
import com.feature.notification.ui.screens.HomeScreen

internal object InternalNotificationFeatureApi: FeatureApi {
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.navigation(startDestination = NotificationFeatureRoutes.homeScreenRoute, route = NotificationFeatureRoutes.nestedRoute) {
            composable(NotificationFeatureRoutes.homeScreenRoute) {
                HomeScreen()
            }
        }
    }
}