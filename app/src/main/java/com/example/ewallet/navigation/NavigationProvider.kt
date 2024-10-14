package com.example.ewallet.navigation

import com.feature.dashboard.ui.navigation.DashboardApi
import com.feature.notification.ui.navigation.NotificationApi
import com.feature.payment.ui.navigation.PaymentApi
import com.feature.profile.ui.navigation.ProfileApi
import com.feature.statistics.ui.navigation.StatisticsApi

data class NavigationProvider(
   val dashboard:DashboardApi,
   val statistics:StatisticsApi,
   val payment:PaymentApi,
   val notification:NotificationApi,
   val profile:ProfileApi

)
