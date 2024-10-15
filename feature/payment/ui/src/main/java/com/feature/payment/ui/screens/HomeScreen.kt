package com.feature.payment.ui.screens

import android.content.pm.PackageManager
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.NavHostController
import com.core.common.components.AppLabel
import com.core.common.components.DrawRound
import com.core.common.components.GeneralTopBar
import com.core.common.theme.AppColors
import com.core.common.theme.Header18
import com.core.common.theme.Label14
import com.core.common.theme.getColor
import com.core.feature_api.PaymentFeatureRoutes
import com.feature.payment.ui.util.QRCodeAnalyzer

val TAG: String?="payment_log"

@Composable
fun HomeScreen(navController: NavHostController) {

    Scaffold(topBar = {GeneralTopBar(title = "Scan to Pay", titleColor = AppColors.White, iconsColor =AppColors.White , iconsBackground =AppColors.Green1 ,background=AppColors.Green1, leftIcon = com.core.common.R.drawable.ic_back, rightIcon = com.core.common.R.drawable.ic_help)}) {
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(it)

            .background(getColor(AppColors.Green1))
            .padding(top = 50.dp, start = 0.dp, end = 0.dp, bottom = 0.dp), verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally){

            Box(modifier = Modifier
                .paint(painterResource(id = com.core.common.R.drawable.background_scan))
                .size(300.dp)
                .padding(16.dp), contentAlignment = Alignment.Center){

                Box(modifier = Modifier
                    .background(Color.Red)
                    .fillMaxSize()){
                    CameraContent(navController)
                }
                   //

            }

            Information()
        }
    }



}


@Composable
fun CameraContent(navController: NavHostController) {
    var code by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    val cameraProviderFuture = remember {

        ProcessCameraProvider.getInstance(context)
    }
    var hasCamPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                context, "android.permission.CAMERA"
            ) == PackageManager.PERMISSION_GRANTED
        )
    }
    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestPermission(),
            onResult = { granted ->
                hasCamPermission = granted
            })


    LaunchedEffect(key1 = true) {
        launcher.launch("android.permission.CAMERA")

    }

        if (hasCamPermission) {

            val scope = rememberCoroutineScope()
            AndroidView(

                factory = { context ->
                    val previewView = PreviewView(context)
                    val preview = Preview.Builder().build()
                    val selector =
                        CameraSelector.Builder().requireLensFacing(CameraSelector.LENS_FACING_BACK)
                            .build()
                    preview.setSurfaceProvider(previewView.surfaceProvider)

                    val imageAnalysis = ImageAnalysis.Builder().setTargetResolution(
                        android.util.Size(
                            previewView.width,
                            previewView.height
                        )
                    ).setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                        .build()
                    imageAnalysis.setAnalyzer(
                        ContextCompat.getMainExecutor(context),
                        QRCodeAnalyzer { result ->
                            code = result


                        })
                    try {
                        cameraProviderFuture.get()
                            .bindToLifecycle(lifecycleOwner, selector, preview, imageAnalysis)

                    } catch (ex: Exception) {
                        ex.printStackTrace()
                    }
                    previewView
                },
                modifier = Modifier.fillMaxSize().clipToBounds(),

            )
            // AppLabel(caption = code, style = MaterialTheme.typography.labelLarge, color = AppColors.Orange1)
            LaunchedEffect(code) {


if(!code.isEmpty()){
    Log.d(TAG, "HomeScreen: $code")
    navController.navigate(PaymentFeatureRoutes.summaryScreenRoute)


}


            }



        }


}

@Composable
fun Information(){

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
            AppLabel(caption = "Payment with QR Code", style = MaterialTheme.typography.Header18, color =AppColors.Blue1 )
            Spacer(modifier = Modifier.height(16.dp))
            AppLabel(caption = "Hold the code inside the frame, it will be scanned automatically", maxline = 2, style = MaterialTheme.typography.Label14, color =AppColors.Gray1 )
        }
    }
}
