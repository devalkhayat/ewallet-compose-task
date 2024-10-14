package com.core.datasource.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TblNotification")
 data class NotificationInfo(
 @PrimaryKey(autoGenerate = true)
  val id:Int?=null,
  val title:String,
  val history: List<NotificationHistoryInfo>
 )

data class NotificationHistoryInfo(
 val id:Int,
 val title:String,
 val time:String,
 val tag:String,
 val type:Int,

)