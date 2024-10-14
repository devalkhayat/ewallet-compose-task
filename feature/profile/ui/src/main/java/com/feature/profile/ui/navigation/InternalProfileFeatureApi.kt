package com.feature.profile.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.core.feature_api.ProfileFeatureRoutes
import com.core.feature_api.FeatureApi
import com.feature.profile.ui.screens.HomeScreen

internal object InternalProfileFeatureApi: FeatureApi {
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.navigation(startDestination = ProfileFeatureRoutes.homeScreenRoute, route = ProfileFeatureRoutes.nestedRoute) {
            composable(ProfileFeatureRoutes.homeScreenRoute) {
                HomeScreen()
            }
        }
    }
}