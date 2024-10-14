package com.feature.payment.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.core.common.R
import com.core.common.components.AppButton
import com.core.common.components.AppCardDropDown
import com.core.common.components.AppLabel
import com.core.common.components.Card
import com.core.common.components.DrawRound
import com.core.common.components.GeneralTopBar
import com.core.common.theme.AppColors
import com.core.common.theme.Header18
import com.core.common.theme.Header24
import com.core.common.theme.Header48
import com.core.common.theme.Label14
import com.core.common.theme.getColor
import com.core.feature_api.PaymentFeatureRoutes

@Composable
fun SummaryScreen(navController: NavHostController) {

    Scaffold(topBar = { GeneralTopBar(title = stringResource(id = com.feature.payment.ui.R.string.payment_screen_2_title), titleColor = AppColors.White, iconsColor = AppColors.White , iconsBackground = AppColors.Green1 ,background= AppColors.Green1, leftIcon = R.drawable.ic_back, rightIcon = R.drawable.ic_help) }) {
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(it)
            .background(getColor(AppColors.Green1))
            .padding(top = 40.dp, start = 0.dp, end = 0.dp, bottom = 0.dp), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally){

            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
                .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally){

                Column(modifier = Modifier.fillMaxWidth(),horizontalAlignment = Alignment.CenterHorizontally) {


                    Box(

                        ){
                        Image(
                            painter = painterResource(id = R.drawable.ic_smart_coffee_logo),
                            contentDescription = "logo",
                            modifier = Modifier
                                .height(100.dp)
                                .width(100.dp)
                                .clip(
                                    RoundedCornerShape(
                                        topStart = 30.dp,
                                        topEnd = 30.dp,
                                        bottomEnd = 30.dp,
                                        bottomStart = 30.dp
                                    )
                                ),
                            contentScale = ContentScale.FillBounds




                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                        AppLabel(
                            caption = stringResource(id = com.feature.payment.ui.R.string.payment_screen_2_place_name),
                            style = MaterialTheme.typography.Header24,
                            color = AppColors.White
                        )
                        AppLabel(
                            caption = stringResource(id = com.feature.payment.ui.R.string.payment_screen_2_date),
                            style = MaterialTheme.typography.Label14,
                            color = AppColors.Orange1
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        AppLabel(
                            caption = "$15.00",
                            style = MaterialTheme.typography.Header48,
                            color = AppColors.White
                        )
                    }
                Spacer(modifier = Modifier.height(16.dp))
                    DrawRound(background = AppColors.White2, modifier = Modifier.fillMaxWidth()){
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)) {
                            Icon(painter = painterResource(id = R.drawable.ic_information), contentDescription = "information")
                            Spacer(modifier = Modifier.width(8.dp))
                            AppLabel(caption = stringResource(id = com.feature.payment.ui.R.string.payment_screen_2_info), style = MaterialTheme.typography.Label14, color = AppColors.White )
                        }
                    }



            }

            Cards(navController)
        }
    }



}

@Composable
fun Cards(navController: NavHostController){

    DrawRound(background = AppColors.White, topStartValue=30.dp, topEndValue = 30.dp, bottomStartValue= 0.dp, bottomEndValue=0.dp,modifier = Modifier.wrapContentHeight()

    ){
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp, top = 16.dp, bottom = 40.dp), horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top
        ) {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                DrawRound(background = AppColors.Gray5, modifier = Modifier.size(50.dp,5.dp))
            }

            Spacer(modifier = Modifier.height(16.dp))
            AppLabel(caption = stringResource(id = com.feature.payment.ui.R.string.payment_screen_2_headline), style = MaterialTheme.typography.Header18, color =AppColors.Blue1 )
            Spacer(modifier = Modifier.height(16.dp))
            val cardList= listOf(Card(name = "Wally Virtual Card", cardNumber = "0318-1608-2105", icon = R.drawable.ic_logo))
            AppCardDropDown(cardList)
            Spacer(modifier = Modifier.height(22.dp))
            AppButton(title = stringResource(id = com.feature.payment.ui.R.string.payment_screen_2_pay), background = AppColors.Green2) {
                navController.navigate(PaymentFeatureRoutes.confirmIdentityRoute) {
                    popUpTo(PaymentFeatureRoutes.confirmIdentityRoute) {
                        inclusive = true
                    }
                }
            }

        }
    }
}
