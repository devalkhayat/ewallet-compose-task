package com.core.common

sealed class UiEvent<T>(val data:T?=null,val message:String?=null) {
    class Success<T>(data:T):UiEvent<T>(data=data)
    class  Error<T>(message:String):UiEvent<T>(message=message)

}