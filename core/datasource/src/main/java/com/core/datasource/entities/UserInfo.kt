package com.core.datasource.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TblUserInfo")
data class UserInfo(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String,
    val amount:Int
)
