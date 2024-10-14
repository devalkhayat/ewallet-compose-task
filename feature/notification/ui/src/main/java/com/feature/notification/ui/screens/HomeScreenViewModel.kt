package com.feature.notification.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.UiEvent
import com.feature.notification.domain.model.Notification
import com.feature.notification.domain.model.NotificationHistory
import com.feature.notification.domain.use_cases.AddNotificationUseCase
import com.feature.notification.domain.use_cases.DeleteAllNotificationsUseCase
import com.feature.notification.domain.use_cases.GetNotificationsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val addNotificationUseCase: AddNotificationUseCase,
                                              private val  getNotificationsUseCase: GetNotificationsUseCase,
                                              private val  deleteAllNotificationsUseCase: DeleteAllNotificationsUseCase
):ViewModel(){

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
                    HomeScreenIntents.GetNotifications -> showNotificationsResult()
                    HomeScreenIntents.InitNotificationsData -> addNotifications()
                }
            }
        }
    }

    private fun showNotificationsResult(){
        viewModelScope.launch {
            getNotificationsUseCase().collect{
                when(it){

                    is UiEvent.Error -> {
                        _viewStateListener.value=HomeScreenStateView.Error(it.message!!)
                    }
                    is UiEvent.Success ->{
                        _viewStateListener.value=HomeScreenStateView.DataNotificationsResult(it.data!!)
                    }


                }
            }

        }
    }
    private fun addNotifications(){
        viewModelScope.launch {

            deleteAllNotificationsUseCase().collect{

                when(it){
                    is UiEvent.Error ->   _viewStateListener.value=HomeScreenStateView.Error(it.message!!)
                    is UiEvent.Success -> {

                        val notificationHistory= listOf(NotificationHistory(id=1, title = "Daily Cashback", time = "8:00 AM", tag = "Promo", type = 1),
                            NotificationHistory(id=1, title = "Use BLK10 Promo Code", time = "3:40 PM", tag = "Promo", type = 2),
                            NotificationHistory(id=1, title = "Cyber Monday Deal", time = "10:39 PM", tag = "Promo", type = 3),
                            NotificationHistory(id=1, title = "$250 top up successfully added", time = "6:14 PM", tag = "Info", type = 4)
                        )
                        val notifications= listOf<Notification>(
                            Notification(title ="YESTERDAY", history = notificationHistory ),
                            Notification(title ="LAST 7 DAY", history = notificationHistory )
                        )

                        addNotificationUseCase(notifications).collect{
                            when(it){

                                is UiEvent.Error -> {
                                    _viewStateListener.value=HomeScreenStateView.Error(it.message!!)
                                }
                                is UiEvent.Success ->{
                                    _viewStateListener.value=HomeScreenStateView.NotificationsSavedSuccessfully("Notifications Saved")
                                }
                            }
                        }
                    }
                }

            }







        }
    }
}