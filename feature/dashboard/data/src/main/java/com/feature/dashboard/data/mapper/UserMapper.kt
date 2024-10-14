package com.feature.dashboard.data.mapper

import com.core.datasource.entities.UserInfo
import com.feature.dashboard.domain.model.User

fun User.toDomainUserInfo():UserInfo{
    return UserInfo(id=1,name=this.name,amount=this.amount)
}

fun UserInfo.toDataUser():User{
    return User(name=this.name,amount=this.amount)
}

