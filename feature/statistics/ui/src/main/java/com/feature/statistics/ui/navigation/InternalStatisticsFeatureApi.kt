package com.feature.statistics.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.core.feature_api.StatisticsFeatureRoutes
import com.core.feature_api.FeatureApi
import com.feature.statistics.ui.screens.HomeScreen

internal object InternalStatisticsFeatureApi: FeatureApi {
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.navigation(startDestination = StatisticsFeatureRoutes.homeScreenRoute, route = StatisticsFeatureRoutes.nestedRoute) {
            composable(StatisticsFeatureRoutes.homeScreenRoute) {
                HomeScreen()
            }
        }
    }
}