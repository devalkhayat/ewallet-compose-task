package com.example.ewallet.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.core.feature_api.DashboardFeatureRoutes

@Composable
fun AppNavGraph(navController: NavHostController,navigationProvider: NavigationProvider){

   NavHost(navController = navController, startDestination = DashboardFeatureRoutes.nestedRoute ){

      navigationProvider.dashboard.registerGraph(navController,this)
      navigationProvider.statistics.registerGraph(navController,this)
      navigationProvider.payment.registerGraph(navController,this)
      navigationProvider.notification.registerGraph(navController,this)
      navigationProvider.profile.registerGraph(navController,this)

   }
}