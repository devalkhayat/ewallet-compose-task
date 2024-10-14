package com.feature.dashboard.domain.model

data class DiscountAndPromo(val id:Int?=null,
                            val title:String,
                            val percentage:String?=null,
                            val description:String,
                            val isDiscount:Boolean)
