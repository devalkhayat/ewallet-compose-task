package com.feature.dashboard.domain.use_cases

import com.core.common.UiEvent
import com.feature.dashboard.domain.model.DiscountAndPromo
import com.feature.dashboard.domain.repo.DiscountAndPromoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AddDiscountAndPromoUseCase @Inject constructor(private val discountAndPromoRepository: DiscountAndPromoRepository) {
    operator fun invoke(discountAndPromoList: List<DiscountAndPromo>) = flow<UiEvent<Boolean>> {

        var i=discountAndPromoList.size
        discountAndPromoList.forEach {
            discountAndPromoRepository.Add(it)
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