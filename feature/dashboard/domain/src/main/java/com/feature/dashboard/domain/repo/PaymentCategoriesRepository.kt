package com.feature.dashboard.domain.repo

import com.feature.dashboard.domain.model.PaymentCategory

interface PaymentCategoriesRepository {
    suspend fun AddCategory(category: PaymentCategory):Boolean
    suspend fun GetPaymentCategories():List<PaymentCategory>
    suspend fun DeleteAll():Boolean
}