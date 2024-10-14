package com.feature.dashboard.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

class DashboardApiImpl:DashboardApi {
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
       InternalDashboardFeatureApi.registerGraph(navController,navGraphBuilder)
    }
}