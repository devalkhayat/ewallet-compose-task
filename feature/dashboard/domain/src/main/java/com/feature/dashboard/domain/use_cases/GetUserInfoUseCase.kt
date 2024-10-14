package com.feature.dashboard.domain.use_cases

import com.core.common.UiEvent
import com.feature.dashboard.domain.model.User
import com.feature.dashboard.domain.repo.UserInfoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetUserInfoUseCase @Inject constructor(private val userInfoRepository: UserInfoRepository) {
    operator fun invoke() = flow<UiEvent<User>> {
        emit(UiEvent.Success(userInfoRepository.getUser()))
    }.catch {
        emit(UiEvent.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}