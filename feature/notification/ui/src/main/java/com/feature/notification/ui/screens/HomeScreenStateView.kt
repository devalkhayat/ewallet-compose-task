package com.feature.notification.ui.screens

import com.feature.notification.domain.model.Notification

sealed class HomeScreenStateView {

    data class  NotificationsSavedSuccessfully(val message: String):HomeScreenStateView()
    data class  DataNotificationsResult(val result: List<Notification>):HomeScreenStateView()
    data class  Error(val message:String):HomeScreenStateView()
}