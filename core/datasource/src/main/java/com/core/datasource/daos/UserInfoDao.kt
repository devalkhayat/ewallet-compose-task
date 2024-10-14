package com.core.datasource.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.core.datasource.entities.UserInfo

@Dao
interface UserInfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun AddUserInfo(userInfo: UserInfo):Unit

    @Query("SELECT * FROM TblUserInfo")
    suspend fun GetUserInfo():UserInfo

}