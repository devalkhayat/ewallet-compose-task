package com.core.datasource.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TblPaymentCategories")
data class PaymentCategoriesInfo(
    @PrimaryKey(autoGenerate = true)
    val id:Int?=null,
    val name:String,
    val iconUrl:Int
    )
