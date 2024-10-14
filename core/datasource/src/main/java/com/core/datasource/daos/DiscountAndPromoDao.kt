package com.core.datasource.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.core.datasource.entities.DiscountAndPromoInfo

@Dao
interface DiscountAndPromoDao {

    @Insert
   suspend fun Add(discount: DiscountAndPromoInfo):Unit

    @Query("DELETE FROM TblDiscountAndPromo")
   suspend fun DeleteAll()

    @Query("SELECT * FROM TblDiscountAndPromo")
   suspend fun GetAll():List<DiscountAndPromoInfo>
}