package com.core.common

import android.content.Context
import android.content.ContextWrapper
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat
import java.util.Locale

fun Int.toThousands():String{

  return  String.format(Locale.US, "%,d", this)
}


fun Context.getActivity(): AppCompatActivity? {
  var currentContext = this
  while (currentContext is ContextWrapper) {
    if (currentContext is AppCompatActivity) {
      return currentContext
    }
    currentContext = currentContext.baseContext
  }
  return null
}