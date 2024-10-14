package com.feature.dashboard.domain.use_cases

import com.core.common.UiEvent
import com.feature.dashboard.domain.repo.PaymentCategoriesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DeleteAllPaymentCategoriesUseCase @Inject constructor(private val paymentCategoriesRepository:PaymentCategoriesRepository) {

    operator fun invoke()=flow<UiEvent<Boolean>>{

        when(paymentCategoriesRepository.DeleteAll()){
            true ->  emit(UiEvent.Success(true))
            false->  emit(UiEvent.Error("Error"))
        }
    }.catch {
        emit(UiEvent.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)

}