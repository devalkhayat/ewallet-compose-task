package com.feature.dashboard.data.repo

import android.util.Log
import com.core.datasource.AppDatabase
import com.feature.dashboard.data.mapper.toDataPaymentOption
import com.feature.dashboard.data.mapper.toDomainPaymentOption
import com.feature.dashboard.domain.model.PaymentCategory
import com.feature.dashboard.domain.repo.PaymentCategoriesRepository
import javax.inject.Inject

class PaymentCategoriesRepoImpl @Inject constructor(private val db: AppDatabase) : PaymentCategoriesRepository {
    private val TAG: String?="log_payment_category"

    override suspend fun AddCategory(category: PaymentCategory): Boolean {
        try {
            db.paymentOptionsDao().AddPaymentCategory(category.toDomainPaymentOption())
            return true
        } catch (ex: Exception) {
            Log.d(TAG, "AddOption: ${ex.message}")
            return false
        }
    }

    override suspend fun GetPaymentCategories(): List<PaymentCategory> {
       val data= arrayListOf<PaymentCategory>()

        db.paymentOptionsDao().GetPaymentCategories().forEach {
            data.add(it.toDataPaymentOption())
        }

        return data
    }

    override suspend fun DeleteAll(): Boolean {
        try {
            db.paymentOptionsDao().DeleteAllPaymentCategories()
            return true
        } catch (ex: Exception) {
            Log.d(TAG, "AddOption: ${ex.message}")
            return false
        }
    }
}