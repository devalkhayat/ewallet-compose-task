package com.feature.dashboard.domain.use_cases

import com.core.common.UiEvent
import com.feature.dashboard.domain.model.PaymentCategory
import com.feature.dashboard.domain.repo.PaymentCategoriesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetPaymentCategoriesUseCase @Inject constructor(private val paymentCategoriesRepository: PaymentCategoriesRepository) {
    operator fun invoke() =
        flow<UiEvent<List<PaymentCategory>>> {

            emit(UiEvent.Success(paymentCategoriesRepository.GetPaymentCategories()))


        }.catch { emit(UiEvent.Error(it.message.toString())) }
            .flowOn(Dispatchers.IO)
}