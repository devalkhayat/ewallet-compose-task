package com.feature.dashboard.domain.repo

import com.feature.dashboard.domain.model.DiscountAndPromo

interface DiscountAndPromoRepository {
    suspend fun Add(discountAndPromo: DiscountAndPromo):Boolean

    suspend fun GetAll():List<DiscountAndPromo>
    suspend fun DeleteAll():Boolean
}