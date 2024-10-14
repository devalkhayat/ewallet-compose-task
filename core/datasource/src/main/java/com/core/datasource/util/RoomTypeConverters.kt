package com.core.datasource.util

import androidx.room.TypeConverter
import com.core.datasource.entities.NotificationHistoryInfo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RoomTypeConverters {

   /* @TypeConverter
    fun convertNotificationHistoryToJSONString(history: NotificationHistory): String = Gson().toJson(history)
    @TypeConverter
    fun convertJSONStringToNotificationHistory(jsonString: String): NotificationHistory = Gson().fromJson(jsonString,NotificationHistory::class.java)
*/

    @TypeConverter
    fun fromNotificationHistoryList(value: List<NotificationHistoryInfo>): String {
        val gson = Gson()
        val type = object : TypeToken<List<NotificationHistoryInfo>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toNotificationHistoryList(value: String): List<NotificationHistoryInfo> {
        val gson = Gson()
        val type = object : TypeToken<List<NotificationHistoryInfo>>() {}.type
        return gson.fromJson(value, type)
    }

}