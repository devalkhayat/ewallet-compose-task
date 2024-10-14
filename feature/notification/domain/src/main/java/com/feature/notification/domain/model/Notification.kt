package com.feature.notification.domain.model

data class Notification(
    val id:Int?=null,
    val title:String,
    val history: List<NotificationHistory>
)

data class NotificationHistory(
    val id:Int,
    val title:String,
    val time:String,
    val tag:String,
    val type:Int
)
