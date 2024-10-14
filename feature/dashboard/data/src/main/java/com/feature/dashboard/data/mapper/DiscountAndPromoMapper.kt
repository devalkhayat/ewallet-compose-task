package com.feature.dashboard.data.mapper

import com.core.datasource.entities.DiscountAndPromoInfo
import com.feature.dashboard.domain.model.DiscountAndPromo

fun DiscountAndPromo.toDomainDiscountAndPromo():DiscountAndPromoInfo{
    return DiscountAndPromoInfo(id=this.id,title=this.title,percentage=this.percentage,description=this.description, isDiscount = this.isDiscount)
}

fun DiscountAndPromoInfo.toDataDiscountAndPromo():DiscountAndPromo{
    return DiscountAndPromo(id=this.id,title=this.title,percentage=this.percentage,description=this.description, isDiscount = this.isDiscount)
}