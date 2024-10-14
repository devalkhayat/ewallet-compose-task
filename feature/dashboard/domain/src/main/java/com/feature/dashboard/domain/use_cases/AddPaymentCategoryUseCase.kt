package com.feature.dashboard.domain.use_cases

import com.core.common.UiEvent
import com.feature.dashboard.domain.model.PaymentCategory
import com.feature.dashboard.domain.repo.PaymentCategoriesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AddPaymentCategoryUseCase @Inject constructor(private val paymentCategoriesRepository: PaymentCategoriesRepository) {
    operator fun invoke(categories: List<PaymentCategory>)=flow<UiEvent<Boolean>>{
        var i=categories.size
        categories.forEach {
            paymentCategoriesRepository.AddCategory(it)
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