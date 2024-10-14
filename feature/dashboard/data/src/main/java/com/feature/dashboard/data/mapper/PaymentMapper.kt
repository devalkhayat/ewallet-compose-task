package com.feature.dashboard.data.mapper

import com.core.datasource.entities.PaymentCategoriesInfo
import com.feature.dashboard.domain.model.PaymentCategory

fun PaymentCategory.toDomainPaymentOption(): PaymentCategoriesInfo {
    return  PaymentCategoriesInfo(name=this.name,iconUrl=this.icon)
}
fun PaymentCategoriesInfo.toDataPaymentOption():PaymentCategory{
    return PaymentCategory(name=this.name, icon = this.iconUrl)
}