package com.feature.dashboard.data.repo

import com.core.datasource.AppDatabase
import com.feature.dashboard.data.mapper.toDataUser
import com.feature.dashboard.data.mapper.toDomainUserInfo
import com.feature.dashboard.domain.model.User
import com.feature.dashboard.domain.repo.UserInfoRepository
import javax.inject.Inject

class UserInfoRepoImpl @Inject constructor(private val db:AppDatabase) : UserInfoRepository {
    override suspend fun addUser(user: User):Boolean {
        try {
            db.userInfoDao().AddUserInfo(user.toDomainUserInfo())
            return true
        } catch (ex: Exception) {
            return false
        }
    }

    override suspend fun getUser(): User {
       return db.userInfoDao().GetUserInfo().toDataUser()
    }
}