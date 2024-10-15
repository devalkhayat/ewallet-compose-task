package com.feature.notification.ui.screens

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import com.core.common.R
import com.core.common.components.AppLabel
import com.core.common.components.DrawCircle
import com.core.common.components.DrawRound
import com.core.common.components.GeneralTopBar
import com.core.common.theme.AppColors
import com.core.common.theme.Header16
import com.core.common.theme.Label12
import com.core.common.theme.Label14
import com.core.common.theme.Label16
import com.core.common.theme.getColor
import com.feature.notification.domain.model.Notification

val TAG: String?="Logging_info"

@Composable
fun HomeScreen(){
var homeScreenViewModel= hiltViewModel<HomeScreenViewModel>()

    Scaffold(
        topBar = {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .paint(
                    painterResource(id = R.drawable.background_appbar),
                    contentScale = ContentScale.Crop
                ) ){

                GeneralTopBar(title = "Notifications", titleColor = AppColors.White, iconsColor = AppColors.White, iconsBackground = AppColors.Gray1,leftIcon = com.core.common.R.drawable.ic_back, rightIcon = com.core.common.R.drawable.ic_settings)
            }

        }
    ) {

        DrawRound(background = AppColors.White, topStartValue=30.dp, topEndValue = 30.dp, bottomStartValue= 0.dp, bottomEndValue=0.dp,modifier = Modifier
            .padding(it)
            .graphicsLayer(translationY = -50f)
            .zIndex(1f)){
            Column(modifier = Modifier
                .padding(start = 12.dp, end = 12.dp, top = 16.dp)
                ) {

            Header()
                Spacer(modifier = Modifier.height(16.dp))
            History(homeScreenViewModel)
        }
        }

    }
}

@Composable
fun Header(){

    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        DrawRound(background = AppColors.Gray5, modifier = Modifier.size(50.dp,5.dp))
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            AppLabel(caption = "TODAY", style =MaterialTheme.typography.Label14 , color = AppColors.Gray1, modifier = Modifier.weight(1f))
            AppLabel(caption = "Mark as read", style =MaterialTheme.typography.Label14 , color = AppColors.Green2)
        }
        Spacer(modifier = Modifier.height(16.dp))
        DrawRound(background = AppColors.Gray2){

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, end = 12.dp, bottom = 16.dp, start = 12.dp)) {
                Box(modifier = Modifier
                    .weight(1f)
                    .padding(top = 4.dp) ){
                     AlertIcon()
                     NotificationIcon(icon = R.drawable.ic_discount, tint = AppColors.White,background = AppColors.Green2)

                }
                Column(modifier = Modifier.weight(3f)) {
                    AppLabel(caption = "Cashback 50%", style =MaterialTheme.typography.Header16 , color = AppColors.Blue1 )
                    AppLabel(caption = "Get 50% cachback for the next top up", style =MaterialTheme.typography.Label12 , color = AppColors.Gray1 )
                    Spacer(modifier = Modifier.height(8.dp))
                    AppLabel(caption = "Top up now >", style =MaterialTheme.typography.Label14 , color = AppColors.Green2)
                }
            }

        }

    }


}

@Composable
fun AlertIcon(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .zIndex(1f)
        .graphicsLayer(translationY = -30f, translationX = -30f), contentAlignment = Alignment.TopEnd){
        DrawCircle(background = AppColors.Gray5, modifier = Modifier
            .size(30.dp, 30.dp)
            .padding(8.dp)
        ){
            DrawCircle(background = AppColors.Orange1, modifier = Modifier
                .size(10.dp, 10.dp)
            )
        }
    }
}

@Composable
fun NotificationIcon(@DrawableRes icon:Int,tint:AppColors,background:AppColors){

    DrawRound(background = background, modifier = Modifier.size(58.dp,58.dp)){

        Box(modifier = Modifier.fillMaxSize(),contentAlignment = Alignment.Center) {
            Icon(painter = painterResource(id = icon), contentDescription ="discount", tint = getColor(tint))
        }


    }
}

@Composable
fun History(homeScreenViewModel: HomeScreenViewModel) {

    var notifications by remember {
        mutableStateOf(listOf<Notification>())
    }
    LaunchedEffect(true) {

        homeScreenViewModel.actionListener.send(HomeScreenIntents.InitNotificationsData)
        homeScreenViewModel.state.collect{

            when (it) {
                is HomeScreenStateView.NotificationsSavedSuccessfully -> homeScreenViewModel.actionListener.send(HomeScreenIntents.GetNotifications)

                is HomeScreenStateView.DataNotificationsResult -> notifications=it.result

                is HomeScreenStateView.Error -> {  Log.d(TAG, "Notifications: ${it.message}")}

                else ->  Log.d(TAG, "notifications:Nothing Returned")
            }
        }
    }

   LazyColumn() {

       notifications.forEach {

           NotificationGroup(it)

       }




   }
}


fun LazyListScope.NotificationGroup(notification:Notification) {

    item {
        AppLabel(caption = notification.title, style = MaterialTheme.typography.Label14, color = AppColors.Gray1)
        Column() {

            var notificationType:NotificationTypes?=null

            notification.history.forEach {

                when(it.type) {
                    1 -> notificationType=NotificationTypes.Promocode
                    2 -> notificationType=NotificationTypes.Deal
                    3 ->notificationType=NotificationTypes.Added
                    4 -> notificationType=NotificationTypes.Cashback
                }
                NotificationItem(

                    iconTint = AppColors.White,
                    title = it.title,
                    time=it.time,
                    tag=it.tag,
                    type=notificationType
                )
            }


        }
    }

}

@Composable
fun NotificationItem(iconTint:AppColors,title:String,time:String,tag:String,type:NotificationTypes?){

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 16.dp, end = 12.dp, bottom = 16.dp, start = 12.dp)) {
        Box(modifier = Modifier
            .weight(1f)
        ){

            with(type){
                NotificationIcon(icon =this!!.icon , tint =iconTint,background = this!!.color)
            }


        }
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(3f)) {
            Spacer(modifier = Modifier.height(4.dp))
            AppLabel(caption = title, style =MaterialTheme.typography.Label16 , color = AppColors.Blue1 )
            AppLabel(caption = time, style =MaterialTheme.typography.Label12 , color = AppColors.Gray1 )

        }

        DrawRound(modifier = Modifier
            .weight(1f)
            ,background = AppColors.Gray2, topStartValue=8.dp, topEndValue = 8.dp, bottomStartValue= 8.dp, bottomEndValue=8.dp){
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 6.dp, end = 8.dp, bottom = 6.dp, start = 8.dp), contentAlignment = Alignment.Center){
                AppLabel(caption = tag, style = MaterialTheme.typography.Label12, color = AppColors.Green2)
            }

        }
    }

}


