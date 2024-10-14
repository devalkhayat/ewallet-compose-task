package com.core.common.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.core.common.theme.AppColors
import com.core.common.theme.Header16
import com.core.common.theme.getColor


@Composable
fun AppButton(title:String,background:AppColors,textColor:AppColors=AppColors.White ,action:()->Unit){
    Button(modifier = Modifier
        .fillMaxWidth()
        .height(48.dp),onClick = {
        action()
    }, shape = RoundedCornerShape(16.dp),colors = ButtonDefaults.buttonColors(containerColor = getColor(background)) ) {

        AppLabel(caption = title, style = MaterialTheme.typography.Header16, color =textColor )
    }
}

@Preview(showSystemUi = true)
@Composable
fun Prev()= AppButton(title = "Proceed to Pay", background = AppColors.Green2) {

}
