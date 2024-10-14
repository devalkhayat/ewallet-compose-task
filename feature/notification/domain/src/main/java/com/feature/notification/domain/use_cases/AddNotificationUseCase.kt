package com.feature.notification.domain.use_cases

import com.core.common.UiEvent
import com.feature.notification.domain.model.Notification
import com.feature.notification.domain.repo.NotificationsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AddNotificationUseCase @Inject constructor(private val notificationsRepository: NotificationsRepository) {

operator fun invoke(notifications: List<Notification>)= flow<UiEvent<Boolean>> {

    var i=notifications.size
    notifications.forEach {
        notificationsRepository.add(it)
        --i
    }

    when(i){
        0 ->  emit(UiEvent.Success(true))
        else->  emit(UiEvent.Error("Error in add"))
    }

}.catch {
    emit(UiEvent.Error(it.message.toString()))
}.flowOn(Dispatchers.IO)
}