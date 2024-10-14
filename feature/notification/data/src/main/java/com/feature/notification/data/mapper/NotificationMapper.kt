package com.feature.notification.data.mapper

import com.core.datasource.entities.NotificationHistoryInfo
import com.core.datasource.entities.NotificationInfo
import com.feature.notification.domain.model.Notification
import com.feature.notification.domain.model.NotificationHistory

fun Notification.toDomainNotification():NotificationInfo {
    var historyList = ArrayList<NotificationHistoryInfo>()
    this.history.forEach {
        historyList.add(it.toDomainNotificationHistory())
    }
    return NotificationInfo(title = this.title, history = historyList)
}

fun NotificationHistory.toDomainNotificationHistory():NotificationHistoryInfo{
    return NotificationHistoryInfo(id=this.id,title = this.title, time = this.time,tag=this.tag,type=this.type)
}



fun NotificationInfo.toDataNotification():Notification {
    var historyList = ArrayList<NotificationHistory>()
    this.history.forEach {
        historyList.add(it.toDataNotificationHistory())
    }
    return Notification(id=this.id,title = this.title, history = historyList)
}

fun NotificationHistoryInfo.toDataNotificationHistory():NotificationHistory{
    return NotificationHistory(id=this.id,title = this.title, time = this.time,tag=this.tag,type=this.type)
}

