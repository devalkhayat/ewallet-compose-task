package com.core.common.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val Blue1=Color(0xFF030319)
val Blue2=Color(0xFF00373E)
val Blue3=Color(0xFFEDFAF2)
val Gray1=Color(0xFF8F92A1)
val Gray2=Color(0xFFF6FAFD)
val Gray3=Color(0xFFBDBDBD)
val Gray4=Color(0xFFC4C4C4)
val Gray5=Color(0xFFF2F2F2)
val Gray6=Color(0xFFE0E0E0)
val Orange1=Color(0xFFFFAE58)
val Orange2=Color(0xFFFFD2A6)
val Green1=Color(0xFF105D38)
val Green2=Color(0xFF4CD080)
val White=Color(0xFFFFFFFF)
val White2=Color(0x0DFFFFFF)
val White3=Color(0x59FFFFFF)
val Transparent=Color(0x00FFFFFF)

sealed class AppColors{
    data object Blue1: AppColors()
    data object Blue2: AppColors()
    data object Blue3: AppColors()
    data object Gray1: AppColors()
    data object Gray2: AppColors()
    data object Gray3: AppColors()
    data object Gray4: AppColors()
    data object Gray5: AppColors()
    data object Gray6: AppColors()
    data object Orange1: AppColors()
    data object Orange2: AppColors()
    data object Green1: AppColors()
    data object Green2: AppColors()
    data object White: AppColors()
    data object White2: AppColors()
    data object White3: AppColors()
    data object Transparent: AppColors()
}

fun getColor(type: AppColors):Color{
    return  when(type){
        AppColors.Blue1 -> Blue1
        AppColors.Blue2 -> Blue2
        AppColors.Blue3 -> Blue3
        AppColors.Gray1 -> Gray1
        AppColors.Gray2 -> Gray2
        AppColors.Gray3 -> Gray3
        AppColors.Gray4 -> Gray4
        AppColors.Green1 -> Green1
        AppColors.Green2 -> Green2
        AppColors.Orange1 -> Orange1
        AppColors.Orange2 -> Orange2
        AppColors.White -> White
        AppColors.Transparent -> Transparent
        AppColors.White2 -> White2
        AppColors.White3 -> White3
        AppColors.Gray5 -> Gray5
        AppColors.Gray6 -> Gray6
    }
}


