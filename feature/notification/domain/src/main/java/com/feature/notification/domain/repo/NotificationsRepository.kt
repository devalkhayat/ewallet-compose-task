package com.feature.notification.domain.repo

import com.feature.notification.domain.model.Notification
import javax.inject.Inject

interface NotificationsRepository {
    suspend fun add(notification:Notification):Boolean
    suspend fun GetAll():List<Notification>
    suspend fun DeleteAll():Boolean
}