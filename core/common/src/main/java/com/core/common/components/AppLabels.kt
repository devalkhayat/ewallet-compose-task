package com.core.common.components

import android.preference.PreferenceActivity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.core.common.theme.AppColors
import com.core.common.theme.getColor


@Composable
fun AppLabel(caption:String, style:TextStyle, color: AppColors,maxline:Int=2,textAlign: TextAlign?=null, modifier: Modifier=Modifier){

    Text(text = caption, modifier = modifier, style = style, color = getColor(color), maxLines = maxline, softWrap = true, textAlign = textAlign )
}
