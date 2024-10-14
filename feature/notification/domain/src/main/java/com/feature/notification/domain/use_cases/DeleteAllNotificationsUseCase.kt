package com.feature.notification.domain.use_cases

import com.core.common.UiEvent
import com.feature.notification.domain.model.Notification
import com.feature.notification.domain.repo.NotificationsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DeleteAllNotificationsUseCase @Inject constructor(private val notificationsRepository: NotificationsRepository) {

operator fun invoke()= flow<UiEvent<Boolean>> {
    when(notificationsRepository.DeleteAll()){
        true ->  emit(UiEvent.Success(true))
        false->  emit(UiEvent.Error("Error"))
    }

}.catch {
    emit(UiEvent.Error(it.message.toString()))
}.flowOn(Dispatchers.IO)
}