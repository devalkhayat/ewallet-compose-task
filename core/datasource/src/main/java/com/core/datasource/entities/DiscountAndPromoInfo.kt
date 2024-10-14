package com.core.datasource.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TblDiscountAndPromo")
data class DiscountAndPromoInfo(
    @PrimaryKey(autoGenerate = true)
    val id:Int?=null,
    val title:String,
    val percentage:String?=null,
    val description:String,
    val isDiscount:Boolean
)


