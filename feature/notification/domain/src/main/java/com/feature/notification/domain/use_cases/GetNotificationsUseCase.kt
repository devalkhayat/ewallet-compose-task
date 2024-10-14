package com.feature.notification.domain.use_cases

import com.core.common.UiEvent
import com.feature.notification.domain.model.Notification
import com.feature.notification.domain.repo.NotificationsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetNotificationsUseCase @Inject constructor(private val notificationsRepository: NotificationsRepository) {

operator fun invoke()= flow<UiEvent<List<Notification>>> {

    emit(UiEvent.Success(notificationsRepository.GetAll()))

}.catch {
    emit(UiEvent.Error(it.message.toString()))
}.flowOn(Dispatchers.IO)
}