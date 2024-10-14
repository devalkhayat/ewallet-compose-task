package com.feature.dashboard.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.UiEvent
import com.core.common.Util
import com.feature.dashboard.domain.model.DiscountAndPromo
import com.feature.dashboard.domain.model.PaymentCategory
import com.feature.dashboard.domain.model.User
import com.feature.dashboard.domain.use_cases.AddDiscountAndPromoUseCase
import com.feature.dashboard.domain.use_cases.AddPaymentCategoryUseCase
import com.feature.dashboard.domain.use_cases.AddUserInfoUseCase
import com.feature.dashboard.domain.use_cases.DeleteAllDiscountAndPromoUseCase
import com.feature.dashboard.domain.use_cases.DeleteAllPaymentCategoriesUseCase
import com.feature.dashboard.domain.use_cases.GetDiscountAndPromoUseCase
import com.feature.dashboard.domain.use_cases.GetPaymentCategoriesUseCase
import com.feature.dashboard.domain.use_cases.GetUserInfoUseCase
import com.feature.dashboard.ui.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val addUserInfoUserCase: AddUserInfoUseCase,
                                              private val getUserInfoUseCase: GetUserInfoUseCase,
                                              private val addPaymentCategoryUseCase: AddPaymentCategoryUseCase,
                                              private val getPaymentCategoriesUseCase: GetPaymentCategoriesUseCase,
                                              private val deleteAllPaymentCategoriesUseCase: DeleteAllPaymentCategoriesUseCase,
                                              private val addDiscountAndPromoUseCase: AddDiscountAndPromoUseCase,
                                              private val getDiscountAndPromoUseCase: GetDiscountAndPromoUseCase,
                                              private val deleteAllDiscountAndPromoUseCase: DeleteAllDiscountAndPromoUseCase
) :ViewModel(){

     val actionListener= Channel<HomeScreenIntents>(Channel.UNLIMITED)


     private val _viewStateListener= MutableStateFlow<HomeScreenStateView?>(null)
     val state: MutableStateFlow<HomeScreenStateView?> get() = _viewStateListener

     init {
         processIntent()
     }

    //process
    private fun processIntent(){
      viewModelScope.launch {
          actionListener.consumeAsFlow().collect{
              when(it){

                  is HomeScreenIntents.InitUserData -> addUserInfo()
                  is HomeScreenIntents.InitPaymentCategoriesData -> addPaymentCategories()
                  is HomeScreenIntents.InitDiscountAndPromoData -> addDiscountAndPromo()
                  is HomeScreenIntents.GetUserData -> showUserResult()
                  is HomeScreenIntents.GetPaymentCategories -> showPaymentCategoriesResult()
                  is HomeScreenIntents.GetDiscountAndPromo -> showDiscountAndPromoResult()
              }
          }
      }
    }

    //reduce
    private fun showUserResult(){
        viewModelScope.launch {
             getUserInfoUseCase().collect{
                when(it){

                    is UiEvent.Error -> {
                        _viewStateListener.value=HomeScreenStateView.Error(it.message!!)
                    }
                    is UiEvent.Success ->{
                        _viewStateListener.value=HomeScreenStateView.DataUserResult(it.data!!)
                    }


                }
            }

        }
    }
    private fun addUserInfo(){
        viewModelScope.launch {

            val user =User(name = "Mohammed", amount = 15901)

            addUserInfoUserCase(user).collect{
                when(it){

                    is UiEvent.Error -> {
                        _viewStateListener.value=HomeScreenStateView.Error(it.message!!)
                    }
                    is UiEvent.Success ->{
                        _viewStateListener.value=HomeScreenStateView.UserSavedSuccessfully("User Data Saved")
                    }
                }
            }

        }
    }

    private fun showPaymentCategoriesResult(){
        viewModelScope.launch {
            getPaymentCategoriesUseCase().collect{
                when(it){

                    is UiEvent.Error -> {
                        _viewStateListener.value=HomeScreenStateView.Error(it.message!!)
                    }
                    is UiEvent.Success ->{
                        _viewStateListener.value=HomeScreenStateView.DataPaymentCategoriesResult(it.data!!)
                    }


                }
            }

        }
    }
    private fun addPaymentCategories(){
        viewModelScope.launch {

            deleteAllPaymentCategoriesUseCase().collect{

                when(it){
                    is UiEvent.Error ->   _viewStateListener.value=HomeScreenStateView.Error(it.message!!)
                    is UiEvent.Success -> {

                        val categories= listOf<PaymentCategory>(
                            PaymentCategory(name = "Electricity", icon = com.core.common.R.drawable.ic_electricity),
                            PaymentCategory(name = "Internet", icon = com.core.common.R.drawable.ic_internet),
                            PaymentCategory(name = "Voucher", icon = com.core.common.R.drawable.ic_voucher),
                            PaymentCategory(name = "Assurance", icon = com.core.common.R.drawable.ic_assurance),
                            PaymentCategory(name = "Merchant", icon = com.core.common.R.drawable.ic_merchant),
                            PaymentCategory(name = "Mobile Credit", icon = com.core.common.R.drawable.ic_mobile_credit),
                            PaymentCategory(name = "Bill", icon = com.core.common.R.drawable.ic_bill),
                            PaymentCategory(name = "More", icon = com.core.common.R.drawable.ic_more),
                        )

                        addPaymentCategoryUseCase(categories).collect{
                            when(it){

                                is UiEvent.Error -> {
                                    _viewStateListener.value=HomeScreenStateView.Error(it.message!!)
                                }
                                is UiEvent.Success ->{
                                    _viewStateListener.value=HomeScreenStateView.PaymentCategoriesSavedSuccessfully("Payment Categories Saved")
                                }
                            }
                        }
                    }
                }

            }







        }
    }

    private fun showDiscountAndPromoResult(){
        viewModelScope.launch {
            getDiscountAndPromoUseCase().collect{
                when(it){

                    is UiEvent.Error -> _viewStateListener.value=HomeScreenStateView.Error(it.message!!)

                    is UiEvent.Success ->{
                        _viewStateListener.value=HomeScreenStateView.DataDiscountAndPromoResult(it.data!!)
                    }


                }
            }

        }
    }
    private fun addDiscountAndPromo(){
        viewModelScope.launch {

            deleteAllDiscountAndPromoUseCase().collect{

                when(it){
                    is UiEvent.Error -> _viewStateListener.value=HomeScreenStateView.Error(it.message!!)

                    is UiEvent.Success -> {

                        val dataList= listOf<DiscountAndPromo>(
                            DiscountAndPromo(title = "Black Friday deal", percentage = "30", description = "Get discount for every topup, transfer and payment", isDiscount = true),
                            DiscountAndPromo(title = "Special Offer for Today's Top Up", description = "Get discount for every top up, transfer and payment", isDiscount = false),
                        )

                        addDiscountAndPromoUseCase(dataList).collect{
                            when(it){

                                is UiEvent.Error -> {
                                    _viewStateListener.value=HomeScreenStateView.Error(it.message!!)
                                }
                                is UiEvent.Success ->{
                                    _viewStateListener.value=HomeScreenStateView.DiscountAndPromoSavedSuccessfully("Discounts Saved")
                                }
                            }
                        }
                    }
                }

            }







        }
    }
}