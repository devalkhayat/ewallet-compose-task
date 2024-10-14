package com.feature.payment.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.core.common.components.AppButton
import com.core.common.components.AppLabel
import com.core.common.components.DrawCircle
import com.core.common.components.DrawRound
import com.core.common.theme.AppColors
import com.core.common.theme.Header14
import com.core.common.theme.Header18
import com.core.common.theme.Header20
import com.core.common.theme.Header24
import com.core.common.theme.Header32
import com.core.common.theme.Label14
import com.core.common.theme.Label16
import com.core.common.theme.getColor
import com.feature.payment.ui.R

@Composable
fun PaymentReceiptScreen(navController: NavHostController) {

    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .background(getColor(AppColors.Green1))
        ) {


        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val topGuideLine = createGuidelineFromTop(0.59f)
            val bottomGuideLine = createGuidelineFromBottom(0.1f)
            val (divider1,header,body,footer)=createRefs()

            Divider(modifier = Modifier.constrainAs(divider1){
                top.linkTo(topGuideLine, margin = 0.dp)
            })
            FooterDivider(modifier = Modifier.constrainAs(footer){
                bottom.linkTo(bottomGuideLine, margin = -70.dp)
            })

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .paint(
                        painterResource(id = com.core.common.R.drawable.background_celebrate),
                        contentScale = ContentScale.FillBounds
                    )
                    .padding(top = 70.dp)
                    .constrainAs(header) {
                        top.linkTo(parent.top)
                    }, contentAlignment = Alignment.TopCenter
            ) {

                AppLabel(
                    caption = "Payment Receipt",
                    style = MaterialTheme.typography.Header20,
                    color = AppColors.White
                )

            }

            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .constrainAs(body) {
                        top.linkTo(header.bottom)
                    }
            ) {


                DrawRound(
                    modifier = Modifier.fillMaxSize(),
                    background = AppColors.White,
                    bottomStartValue = 0.dp,
                    bottomEndValue = 0.dp
                ) {

                    Content()

                }
            }

        }
    }
    
}

@Composable
fun Content(){

    Column(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 8.dp), horizontalAlignment = Alignment.CenterHorizontally) {

            Image(painter = painterResource(id = com.core.common.R.drawable.ic_payment_success), contentDescription = "success")
            Spacer(modifier = Modifier.height(16.dp))
            AppLabel(caption = "Payment Success", style =MaterialTheme.typography.Header24 , color = AppColors.Blue1)
            Spacer(modifier = Modifier.height(8.dp))
            AppLabel(caption = "Your payment for Smart Coffee has been successfully done", style =MaterialTheme.typography.Label16 , color = AppColors.Gray1, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(16.dp))
            AppLabel(caption = "Total Payment", style =MaterialTheme.typography.Label16 , color = AppColors.Gray1)
            AppLabel(caption = "$132.00", style =MaterialTheme.typography.Header32 , color = AppColors.Blue1)


        }
        Spacer(modifier = Modifier.height(8.dp))

        Spacer(modifier = Modifier.height(8.dp))
        PaymentInfo()
    }
   
}

@Composable
fun Divider(modifier: Modifier=Modifier){
    
    Row(modifier = modifier
        .fillMaxWidth()
        .zIndex(2f), verticalAlignment = Alignment.CenterVertically){
        DrawCircle(background = AppColors.Green1, modifier = Modifier.size(30.dp))

        val pathEffect = PathEffect.dashPathEffect(floatArrayOf(30f, 15f), 0f)
        Canvas(
            Modifier.weight(1f)
        ) {
            drawLine(
                color = getColor(AppColors.Gray6),
                strokeWidth = 3f,
                start = Offset(20f, 0f),
                end = Offset(size.width - 20, 0f),
                pathEffect = pathEffect
            )
        }
       /* Box(modifier = Modifier
            .weight(1f)
            .height(10.dp)
            .border(3.dp, getColor(AppColors.Green1), RectangleShape))*/

        DrawCircle(background = AppColors.Green1, modifier = Modifier.size(30.dp))


    }
}

@Composable
fun PaymentInfo(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 8.dp, end = 8.dp, bottom = 8.dp, top = 16.dp)
        ) {
        AppLabel(caption = "Payment for", style = MaterialTheme.typography.Label16, color =AppColors.Gray1, modifier = Modifier.fillMaxWidth() )
        Spacer(modifier = Modifier.height(8.dp))
        DrawRound(background = AppColors.Gray2){
            Row(modifier = Modifier.fillMaxWidth()) {
                Box(modifier = Modifier
                    .padding(8.dp)){

                    Image(painter = painterResource(id = com.core.common.R.drawable.ic_smart_coffee_logo),
                        contentDescription = "logo", contentScale = ContentScale.FillBounds, modifier = Modifier
                            .size(60.dp)
                            .clip(
                                RoundedCornerShape(20.dp)
                            ))
                }

                Spacer(modifier = Modifier.width(8.dp))
                Column(modifier = Modifier
                    .weight(1f)
                    .padding(top = 8.dp)) {
                    AppLabel(caption = "Smart Coffee", style = MaterialTheme.typography.Header18, color = AppColors.Blue1)

                    AppLabel(caption = "Dec 2, 2020 . 3:02 PM", style = MaterialTheme.typography.Label14, color = AppColors.Gray1)
                }
            }
        }
        
        Spacer(modifier = Modifier.height(20.dp))
        AppButton(title = "Done", background =AppColors.Green2 ) {
            
        }
        Spacer(modifier = Modifier.height(8.dp))
        AppButton(title = "Pay again", background =AppColors.White, textColor = AppColors.Green1 ) {

        }
        Spacer(modifier = Modifier.height(8.dp))

   
    }
}


@Composable
fun FooterDivider(modifier: Modifier=Modifier){

    Box(modifier = modifier.fillMaxWidth().zIndex(2f).padding(start = 20.dp, end = 20.dp)){

        Row(verticalAlignment = Alignment.CenterVertically){
            repeat(15){
                DrawCircle(background = AppColors.Green1, modifier = Modifier.size(30.dp))
            }




        }
    }
}

