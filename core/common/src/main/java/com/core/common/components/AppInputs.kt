package com.core.common.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.core.common.theme.AppColors
import com.core.common.theme.Label12
import com.core.common.theme.Label14
import com.core.common.theme.Label16
import com.core.common.theme.getColor


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppInput(label:String,note:String,hint:String?=null, hintColor: AppColors= AppColors.Gray1, maxLines:Int=1, modifier: Modifier=Modifier, data:String, dataColor:AppColors= AppColors.Blue1, action:(String)->Unit){

    val colors = TextFieldDefaults.textFieldColors(
        focusedIndicatorColor = getColor(AppColors.Gray5),
        /*unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent,*/
        containerColor = Color.Transparent,
    )

Column(modifier = Modifier.fillMaxWidth()) {

    AppLabel(caption = label, style = MaterialTheme.typography.Label16, color =AppColors.Gray1 )
    Spacer(modifier = Modifier.height(1.dp))
    TextField(
        modifier =modifier.fillMaxWidth(),
        value = data,
        label = null,
       colors = colors,
        textStyle = TextStyle(color = getColor(dataColor)),
        maxLines = maxLines,
        placeholder = {
            hint?.let {
                AppLabel(caption = it, style = MaterialTheme.typography.Label12, color = hintColor)
            }

        },
        onValueChange = {
            action(it)
        })
     Spacer(modifier = Modifier.height(4.dp))
    AppLabel(caption = note, style = MaterialTheme.typography.Label14, color =AppColors.Gray1 )
}

}

