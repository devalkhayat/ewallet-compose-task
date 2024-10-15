package com.feature.dashboard.ui.screens

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel


import com.core.common.components.AppLabel
import com.core.common.components.CustomPagerIndicatorFirstTry
import com.core.common.components.DrawAppIcon
import com.core.common.components.DrawRound
import com.core.common.theme.AppColors
import com.core.common.theme.Header14
import com.core.common.theme.Header18
import com.core.common.theme.Header20
import com.core.common.theme.Header28
import com.core.common.theme.Label12
import com.core.common.theme.Label14
import com.core.common.theme.getColor
import com.core.common.toThousands
import com.feature.dashboard.domain.model.DiscountAndPromo
import com.feature.dashboard.domain.model.PaymentCategory
import com.feature.dashboard.domain.model.User
import com.feature.dashboard.ui.R

val TAG: String?="Logging_info"

@Composable
fun HomeScreen() {

    val homeScreenViewModel = hiltViewModel<HomeScreenViewModel>()
    var result by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(Unit) {
        homeScreenViewModel.actionListener.send(HomeScreenIntents.InitData)
        homeScreenViewModel.state.collect { currentState ->
            when (currentState) {

                is HomeScreenStateView.Error -> Log.d(TAG, "Inited: ${currentState.message}")

                is HomeScreenStateView.SavedSuccessfully -> {
                    result = true
                    Log.d(TAG, "Inited: ${currentState.message}")
                }

                else -> {
                    Log.d(TAG, "Inited: Nothing")
                }
            }
        }
    }

    if (result) {


        var user by remember {
            mutableStateOf(User())
        }
        var paymentCategories by remember {
            mutableStateOf(listOf<PaymentCategory>())
        }
        var discountsAndPromo by remember {
            mutableStateOf(listOf<DiscountAndPromo>())
        }

        LaunchedEffect(Unit) {
            homeScreenViewModel.actionListener.send(HomeScreenIntents.GetData)
            homeScreenViewModel.state.collect{
                when(it){
                    is HomeScreenStateView.DataResult -> {
                        user=it.userInfo
                        paymentCategories=it.paymentCategoriesList
                        discountsAndPromo=it.discountAndPromoList
                    }
                    is HomeScreenStateView.Error -> TODO()
                    else -> {

                    }
                }
            }
        }


        Content(user,paymentCategories,discountsAndPromo)
    }

}

@Composable
fun Content(user: User, paymentCategories: List<PaymentCategory>, discountsAndPromos: List<DiscountAndPromo>){

    Scaffold(
        topBar = { TopBar()},

        ) {

        Box(modifier = Modifier
            .fillMaxSize()
            .padding(it)){


            LazyColumn(modifier = Modifier
                .wrapContentHeight()
                .padding(start = 8.dp, end = 8.dp, top = 26.dp),verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {


                item {
                    UserData(user = user)
                }


                item {
                    MainActions()
                }


                item {

                    PaymentList(paymentCategories = paymentCategories)
                }

                item {
                    PromoAndDiscountList(discountsAndPromos)
                }
            }




        }

    }
}
@Composable
fun TopBar(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 8.dp, top = 8.dp, end = 8.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        Image(painter = painterResource(id = com.core.common.R.drawable.ic_logo), contentDescription = "logo")
        DrawAppIcon(borderColor = AppColors.Gray4, iconColor = AppColors.Blue1, icon = com.core.common.R.drawable.ic_settings ) {
        }
    }
}



@Composable
fun UserData(user:User){

    Row(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .weight(2f)) {
            AppLabel(caption = "${stringResource(id = R.string.hello)} ${user.name},", style = MaterialTheme.typography.Header18 , color = AppColors.Blue1)
            AppLabel(caption = stringResource(id = R.string.your_available_balance), style = MaterialTheme.typography.Label14 , color = AppColors.Gray1)
        }
        AppLabel(caption = "${stringResource(id = R.string.dollar_sign)} ${user.amount?.toThousands()}", style = MaterialTheme.typography.Header28 , color = AppColors.Blue1)
    }
}

@Composable
fun MainActions(){

    DrawRound(background = AppColors.Green2 ) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(90.dp)
        .padding(8.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        Spacer(modifier = Modifier.width(4.dp))
        BigButton(title = R.string.transfer, icon = com.core.common.R.drawable.ic_transfer, contentDescription = "transfer")
        VerticalDivider()
        BigButton(title = R.string.topUp, icon = com.core.common.R.drawable.ic_top_up, contentDescription = "topUp")
        VerticalDivider()
        BigButton(title = R.string.history, icon = com.core.common.R.drawable.ic_history, contentDescription = "history")
        Spacer(modifier = Modifier.width(4.dp))
    }
    }
}
@Composable
fun BigButton(@StringRes title:Int,@DrawableRes icon:Int,contentDescription:String){
    Column {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(painter = painterResource(id = icon), contentDescription = contentDescription, tint = getColor(AppColors.White))
        }
        AppLabel(caption = stringResource(id = title), style = MaterialTheme.typography.Label14 , color = AppColors.White)
    }
}
@Composable
fun VerticalDivider(){
    Box(modifier = Modifier
        .clip(RoundedCornerShape(16.dp))
        .width(1.dp)
        .fillMaxHeight()
        .background(
            brush = Brush.verticalGradient(

                colors = listOf(
                    getColor(AppColors.White2), // Start Color
                    getColor(AppColors.White3), // Middle color
                    getColor(AppColors.White2)  // End color
                ),

                )
        )){

    }
}



@Composable
fun PaymentList(paymentCategories:List<PaymentCategory>) {

    Column (modifier = Modifier.height(270.dp)){
        AppLabel(caption = stringResource(id = R.string.payment_list), style = MaterialTheme.typography.Header18, color =AppColors.Blue1 )
        LazyVerticalGrid(columns = GridCells.Fixed(4), contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            items(paymentCategories) { item ->
                GridItem(item)
            }
        }
    }
}
@Composable
fun GridItem(paymentCategory:PaymentCategory) {


        Column(modifier = Modifier.fillMaxWidth(),horizontalAlignment = Alignment.CenterHorizontally) {
            DrawRound(background = AppColors.Gray2) {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 25.dp), contentAlignment = Alignment.Center){
                    Image(painter = painterResource(paymentCategory.icon), contentDescription = paymentCategory.name)
                }

            }
            Spacer(modifier = Modifier.height(8.dp))

            AppLabel(caption = paymentCategory.name, style = MaterialTheme.typography.Label14, textAlign = TextAlign.Center, maxline = 2, color = AppColors.Blue1)
        }


}


@Composable
fun PromoAndDiscountList(discountsAndPromos:List<DiscountAndPromo>){

    Column(modifier = Modifier
        .fillMaxWidth()
        .height(280.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier = Modifier.fillMaxWidth()) {
            AppLabel(
                caption = stringResource(id = R.string.promo_discount_list),
                style = MaterialTheme.typography.Header18,
                color = AppColors.Blue1,
                modifier = Modifier.weight(1f)
            )
            AppLabel(
                caption = stringResource(id = R.string.see_more),
                style = MaterialTheme.typography.Label14,
                color = AppColors.Green2
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        val pagerState = rememberPagerState { discountsAndPromos.size }
        HorizontalPager(state = pagerState, modifier = Modifier.fillMaxWidth(), pageSpacing = 8.dp) { page ->
           with( discountsAndPromos.get(page)){
               if(this.isDiscount){
                   DrawDiscount(this.title, percentage = this.percentage!!, descripton  =this.description)
               }else{
                   DrawPromo(this.title, descripton = this.description)
               }
           }


        }
        Spacer(modifier = Modifier.height(16.dp))

        CustomPagerIndicatorFirstTry(pagerState, indicatorColor = AppColors.Green2)
    }

}
@Composable
fun DrawDiscount(title:String,percentage:String,descripton:String){
    DrawRound(
        background = AppColors.Blue2, modifier = Modifier
        .fillMaxWidth()
        ) {
        Row(modifier = Modifier.fillMaxWidth()) {

            Column(modifier = Modifier
                .height(170.dp)
                .weight(2f)
                .padding(start = 16.dp, end = 16.dp, top = 20.dp, bottom = 20.dp)) {
                AppLabel(
                    caption = "$percentage% OFF",
                    style = MaterialTheme.typography.Header14,
                    color = AppColors.White
                )
                Spacer(modifier = Modifier.height(16.dp))
                AppLabel(
                    caption = title,
                    style = MaterialTheme.typography.Header20,
                    color = AppColors.White
                )
                Spacer(modifier = Modifier.height(32.dp))
                AppLabel(
                    caption = descripton,
                    style = MaterialTheme.typography.Label12,
                    color = AppColors.Gray3,
                    maxline = 2
                )

            }

            Box(modifier = Modifier.weight(1f)){

                Box(modifier = Modifier
                    .graphicsLayer(translationY = 130f, translationX = 160f)
                    .zIndex(1f)
                    .size(40.dp, 40.dp)
                    .clip(CircleShape)
                    .background(getColor(AppColors.Orange2))
                    )

                DrawRound(
                    background = AppColors.Green2, modifier = Modifier
                        .height(170.dp)
                        .graphicsLayer(rotationZ = -20f, translationY = 200f)){}

                Box(modifier = Modifier.graphicsLayer(translationY = 300f, translationX = 40f), contentAlignment = Alignment.Center){
                    AppLabel(caption = "$percentage%", style = MaterialTheme.typography.Header28 , color = AppColors.White)
                }
            }

        }

    }
}

@Composable
fun DrawPromo(title:String,descripton:String){

    DrawRound(
        background = AppColors.Orange2, modifier = Modifier
        .fillMaxWidth()
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {

            Column(modifier = Modifier
                .height(170.dp)
                .weight(2f)
                .padding(start = 16.dp, end = 16.dp, top = 20.dp, bottom = 20.dp)) {
                Spacer(modifier = Modifier.height(16.dp))
                AppLabel(
                    caption = title,
                    style = MaterialTheme.typography.Header20,
                    color = AppColors.Blue1,
                    maxline = 2
                )
                Spacer(modifier = Modifier.height(32.dp))
                AppLabel(
                    caption = descripton,
                    style = MaterialTheme.typography.Label12,
                    color = AppColors.Blue1,
                    maxline = 2
                )

            }

            Box(modifier = Modifier.weight(1f)){


                DrawRound(
                    background = AppColors.Green2, modifier = Modifier
                        .height(170.dp)
                        .graphicsLayer(rotationZ = -20f, translationY = 200f)){}
                DrawRound(
                    background = AppColors.Blue2, modifier = Modifier
                        .height(170.dp)
                        .graphicsLayer(rotationZ = -20f, translationY = 80f, translationX = 100f)){}

            }

        }

    }
}


@Preview(showSystemUi = true)
@Composable
fun PrevHome(){
    MainActions()
}