package com.core.datasource.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.core.datasource.entities.PaymentCategoriesInfo

@Dao
interface PaymentCategoriesDao {

    @Insert
    suspend fun AddPaymentCategory(paymentCategory: PaymentCategoriesInfo):Unit

    @Query("DELETE FROM TblPaymentCategories")
    suspend fun DeleteAllPaymentCategories()

    @Query("SELECT * FROM TblPaymentCategories")
    suspend fun GetPaymentCategories():List<PaymentCategoriesInfo>
}