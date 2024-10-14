package com.feature.dashboard.domain.use_cases

import com.core.common.UiEvent
import com.feature.dashboard.domain.model.User
import com.feature.dashboard.domain.repo.UserInfoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AddUserInfoUseCase @Inject constructor(private val userInfoRepository: UserInfoRepository){
operator fun invoke(user:User)=flow<UiEvent<Boolean>>{
     when(userInfoRepository.addUser(user)){
        true ->  emit(UiEvent.Success(true))
        false->  emit(UiEvent.Error("Error"))
    }

}.catch {
    emit(UiEvent.Error(it.message.toString()))
}.flowOn(Dispatchers.IO)
}