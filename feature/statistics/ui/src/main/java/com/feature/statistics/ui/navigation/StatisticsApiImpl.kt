package com.feature.statistics.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

class StatisticsApiImpl:StatisticsApi {
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
       InternalStatisticsFeatureApi.registerGraph(navController,navGraphBuilder)
    }
}