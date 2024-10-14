package com.feature.dashboard.domain.use_cases

import com.core.common.UiEvent
import com.feature.dashboard.domain.model.DiscountAndPromo
import com.feature.dashboard.domain.repo.DiscountAndPromoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetDiscountAndPromoUseCase @Inject constructor(private val discountAndPromoRepository: DiscountAndPromoRepository) {
    operator fun invoke() =
        flow<UiEvent<List<DiscountAndPromo>>> {

            emit(UiEvent.Success(discountAndPromoRepository.GetAll()))


        }.catch { emit(UiEvent.Error(it.message.toString())) }
            .flowOn(Dispatchers.IO)
}