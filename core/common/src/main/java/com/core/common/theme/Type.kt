package com.core.common.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.core.common.R

private val fonts= FontFamily(
    Font(R.font.dmsans_regular, weight = FontWeight.Normal),
    Font(R.font.dmsans_medium, weight = FontWeight.Medium),
    Font(R.font.dmsans_bold, weight = FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

val Typography.Header12:TextStyle
    @Composable
    get(){
        return TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
        )
    }
val Typography.Header14:TextStyle
    @Composable
    get(){
        return TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
        )
    }
val Typography.Header16:TextStyle
    @Composable
    get(){
        return TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        )
    }
val Typography.Header18:TextStyle
    @Composable
    get(){
        return TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
        )
    }
val Typography.Header20:TextStyle
    @Composable
    get(){
        return TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
        )
    }

val Typography.Header24:TextStyle
    @Composable
    get(){
        return TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
        )
    }

val Typography.Header28:TextStyle
    @Composable
    get(){
        return TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
        )
    }

val Typography.Header32:TextStyle
    @Composable
    get(){
        return TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
        )
    }

val Typography.Header48:TextStyle
    @Composable
    get(){
        return TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Bold,
            fontSize = 48.sp,
        )
    }


val Typography.Label12:TextStyle
    @Composable
    get(){
        return TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
        )
    }

val Typography.Label14:TextStyle
    @Composable
    get(){
        return TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
        )
    }

val Typography.Label16:TextStyle
    @Composable
    get(){
        return TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
        )
    }
val Typography.Label18:TextStyle
    @Composable
    get(){
        return TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
        )
    }
