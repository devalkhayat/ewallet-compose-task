package com.feature.notification.ui.screens

import androidx.annotation.DrawableRes
import com.core.common.theme.AppColors
import com.feature.notification.ui.R

sealed class NotificationTypes( @DrawableRes val icon:Int,val color:AppColors){
   data object Cashback:NotificationTypes(icon = com.core.common.R.drawable.ic_discount, color=AppColors.Orange1)
   data object Promocode:NotificationTypes(icon = com.core.common.R.drawable.ic_blck10, color=AppColors.Green1)
   data object Deal:NotificationTypes(icon = com.core.common.R.drawable.ic_discount, color=AppColors.Orange2)
   data object Added:NotificationTypes(icon = com.core.common.R.drawable.ic_credit_card, color=AppColors.Green1)


}