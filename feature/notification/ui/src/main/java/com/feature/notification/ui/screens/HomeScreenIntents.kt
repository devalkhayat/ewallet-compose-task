package com.feature.notification.ui.screens

sealed class HomeScreenIntents {
    data object InitNotificationsData:HomeScreenIntents()
    data object  GetNotifications:HomeScreenIntents()
}