package com.core.common.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.core.common.theme.AppColors
import com.core.common.theme.getColor


@Composable
fun DrawRound(background: AppColors, modifier: Modifier=Modifier, topStartValue:Dp = 16.dp, topEndValue:Dp = 16.dp, bottomStartValue :Dp= 16.dp, bottomEndValue:Dp=16.dp, content: @Composable() (() -> Unit?)? =null){
    Box(modifier = modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(topStart = topStartValue, topEnd = topEndValue, bottomStart = bottomStartValue, bottomEnd = bottomEndValue))
        .background(getColor(background))
        ){
        if (content != null) {
            content()
        }
    }
}

@Composable
fun DrawCircle(background: AppColors, modifier: Modifier=Modifier, content: @Composable() (() -> Unit?)? =null){
    Box(modifier = modifier
        .fillMaxWidth()
        .clip(CircleShape)
        .background(getColor(background)
            ), contentAlignment = Alignment.Center
    ){
        if (content != null) {
            content()
        }
    }
}

@Composable
fun DrawAppIcon(borderColor:AppColors,iconColor:AppColors,@DrawableRes icon:Int, modifier: Modifier=Modifier,action:()->Unit){

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(40.dp,40.dp)
            .border(width=1.dp,color= getColor(borderColor),shape=RoundedCornerShape(12.dp))


    ){

        IconButton(onClick = { action() }) {

            Icon(
                painterResource(id = icon),
                contentDescription = "back",
                tint = getColor(iconColor),
                modifier = Modifier.size(24.dp,24.dp)
            )
        }


    }
}


@Preview(backgroundColor = 0xFFFFC107, showBackground = true, showSystemUi = true)
@Composable
fun ShowPreview(){

}