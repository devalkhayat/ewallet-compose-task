package com.core.common.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.core.common.R
import com.core.common.theme.AppColors
import com.core.common.theme.Header14
import com.core.common.theme.Label12
import com.core.common.theme.getColor

data class  Card(val name:String,val cardNumber:String,@DrawableRes val icon:Int)
@Composable
fun AppCardDropDown(cards:List<Card>){


    val isExpandend = remember {
        mutableStateOf(false)
    }
    val currentValue = remember {
        mutableStateOf(cards[0])
    }

    Row(modifier = Modifier.clickable { isExpandend.value = !isExpandend.value }, verticalAlignment = Alignment.CenterVertically) {

        Image(painter = painterResource(id = currentValue.value.icon), contentDescription =currentValue.value.name )
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            AppLabel(caption = currentValue.value.name, style = MaterialTheme.typography.Header14, color =AppColors.Blue1 )
            AppLabel(caption = currentValue.value.cardNumber, style = MaterialTheme.typography.Label12, color =AppColors.Gray1 )
        }

        Spacer(modifier = Modifier.width(8.dp))

        Icon(painter = painterResource(id = R.drawable.ic_arrow_down), contentDescription = "drop", tint = getColor(AppColors.Green1) )

        Spacer(modifier = Modifier.width(8.dp))

        DropdownMenu(
            expanded = isExpandend.value,
            onDismissRequest = { isExpandend.value = false }) {
            cards.forEach {
                DropdownMenuItem(onClick = {
                    currentValue.value = it
                    isExpandend.value = false
                }) {
                    AppLabel(caption = it.cardNumber, style = MaterialTheme.typography.Label12, color =AppColors.Gray1 )
                }
            }
        }
    }
}