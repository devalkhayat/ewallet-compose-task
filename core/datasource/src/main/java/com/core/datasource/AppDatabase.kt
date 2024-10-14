package com.core.datasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.core.datasource.daos.DiscountAndPromoDao
import com.core.datasource.daos.NotificationsDao
import com.core.datasource.daos.PaymentCategoriesDao
import com.core.datasource.daos.UserInfoDao
import com.core.datasource.entities.DiscountAndPromoInfo

import com.core.datasource.entities.NotificationInfo
import com.core.datasource.entities.PaymentCategoriesInfo
import com.core.datasource.entities.UserInfo
import com.core.datasource.util.RoomTypeConverters

@TypeConverters(value = [RoomTypeConverters::class])
@Database(entities = [DiscountAndPromoInfo::class,NotificationInfo::class,PaymentCategoriesInfo::class,UserInfo::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userInfoDao(): UserInfoDao
    abstract fun paymentOptionsDao():PaymentCategoriesDao
    abstract fun discountAndPromoDao():DiscountAndPromoDao
    abstract fun notificationsDao():NotificationsDao
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }


}