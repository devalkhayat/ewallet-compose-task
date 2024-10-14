package com.feature.dashboard.data.repo

import android.util.Log
import com.core.datasource.AppDatabase
import com.feature.dashboard.data.mapper.toDataDiscountAndPromo
import com.feature.dashboard.data.mapper.toDataPaymentOption
import com.feature.dashboard.data.mapper.toDomainDiscountAndPromo
import com.feature.dashboard.data.mapper.toDomainPaymentOption
import com.feature.dashboard.domain.model.DiscountAndPromo
import com.feature.dashboard.domain.model.PaymentCategory
import com.feature.dashboard.domain.repo.DiscountAndPromoRepository
import javax.inject.Inject

class DiscountAndPromoRepoImpl @Inject constructor(private val db: AppDatabase): DiscountAndPromoRepository {
    override suspend fun Add(discountAndPromo: DiscountAndPromo): Boolean {

        try {
            db.discountAndPromoDao().Add(discountAndPromo.toDomainDiscountAndPromo())
            return true
        } catch (ex: Exception) {

            return false
        }
    }

    override suspend fun GetAll(): List<DiscountAndPromo> {
        val data= arrayListOf<DiscountAndPromo>()

        db.discountAndPromoDao().GetAll().forEach {
            data.add(it.toDataDiscountAndPromo())
        }

        return data
    }

    override suspend fun DeleteAll(): Boolean {
        try {
            db.discountAndPromoDao().DeleteAll()
            return true
        } catch (ex: Exception) {

            return false
        }
    }
}