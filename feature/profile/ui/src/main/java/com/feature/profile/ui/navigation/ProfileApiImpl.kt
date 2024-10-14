package com.feature.profile.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

class ProfileApiImpl:ProfileApi {
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
       InternalProfileFeatureApi.registerGraph(navController,navGraphBuilder)
    }
}