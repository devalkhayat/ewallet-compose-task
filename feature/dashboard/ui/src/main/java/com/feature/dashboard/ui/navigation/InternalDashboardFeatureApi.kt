package com.feature.dashboard.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.core.feature_api.DashboardFeatureRoutes
import com.core.feature_api.FeatureApi
import com.feature.dashboard.ui.screens.HomeScreen

internal object InternalDashboardFeatureApi: FeatureApi {
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.navigation(startDestination = DashboardFeatureRoutes.homeScreenRoute, route = DashboardFeatureRoutes.nestedRoute) {
            composable(DashboardFeatureRoutes.homeScreenRoute) {
                HomeScreen()
            }
        }
    }
}