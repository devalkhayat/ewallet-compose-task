package com.feature.notification.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

class NotificationApiImpl:NotificationApi {
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
       InternalNotificationFeatureApi.registerGraph(navController,navGraphBuilder)
    }
}