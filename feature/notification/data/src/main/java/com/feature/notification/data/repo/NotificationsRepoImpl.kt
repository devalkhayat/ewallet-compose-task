package com.feature.notification.data.repo

import android.util.Log
import com.core.datasource.AppDatabase
import com.feature.notification.data.mapper.toDataNotification
import com.feature.notification.data.mapper.toDomainNotification
import com.feature.notification.domain.model.Notification
import com.feature.notification.domain.repo.NotificationsRepository
import javax.inject.Inject

class NotificationsRepoImpl @Inject constructor(val db:AppDatabase):NotificationsRepository {
    override suspend fun add(notification: Notification): Boolean {
        try {
            db.notificationsDao().Add(notification.toDomainNotification())
            return true
        } catch (ex: Exception) {

            return false
        }
    }

    override suspend fun GetAll(): List<Notification> {
        val data= arrayListOf<Notification>()

        db.notificationsDao().GetALL().forEach {
            data.add(it.toDataNotification())
        }

        return data
    }

    override suspend fun DeleteAll(): Boolean {
        try {
            db.paymentOptionsDao().DeleteAllPaymentCategories()
            return true
        } catch (ex: Exception) {

            return false
        }
    }
}