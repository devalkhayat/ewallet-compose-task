package com.core.datasource.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.core.datasource.entities.NotificationInfo
@Dao
interface NotificationsDao {

    @Insert
    fun Add(notification: NotificationInfo):Unit

    @Query("DELETE FROM TblNotification")
    fun Delete()

    @Query("SELECT * FROM TblNotification")
    fun GetALL():List<NotificationInfo>
}