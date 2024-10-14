package com.feature.dashboard.domain.repo

import com.feature.dashboard.domain.model.User

interface UserInfoRepository {
    suspend fun addUser(user:User):Boolean
    suspend fun getUser(): User
}