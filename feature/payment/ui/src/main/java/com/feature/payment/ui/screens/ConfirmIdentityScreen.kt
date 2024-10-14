package com.feature.payment.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.core.common.R
import com.core.common.components.AppButton
import com.core.common.components.AppInput
import com.core.common.components.AppLabel
import com.core.common.components.GeneralTopBar
import com.core.common.getActivity
import com.core.common.theme.AppColors
import com.core.common.theme.Label16
import com.core.common.theme.Label18
import com.core.common.theme.getColor
import com.core.feature_api.PaymentFeatureRoutes
import com.feature.payment.ui.util.BiometricPromptManager

@Composable
fun ConfirmScreen(navController: NavHostController) {

    var _data by remember {
        mutableStateOf("")
    }
    Scaffold(topBar = {
        GeneralTopBar(
            title = stringResource(id = com.feature.payment.ui.R.string.payment_screen_3_title),
            titleColor = AppColors.Blue1,
            iconsColor = AppColors.Blue1,
            iconsBorderColor=AppColors.Gray4,
            iconsBackground = AppColors.Transparent,
            background = AppColors.White,
            leftIcon = R.drawable.ic_back

        )
    }) {
        Column(
            modifier = Modifier
                .background(getColor(AppColors.White))
                .fillMaxSize()
                .padding(it)
                .padding(8.dp)
        ) {

            Column(modifier = Modifier.weight(1f)) {

                AppLabel(
                    caption = stringResource(id = com.feature.payment.ui.R.string.payment_screen_3_input_caption),
                    style = MaterialTheme.typography.Label18,
                    color = AppColors.Gray1
                )

                Spacer(modifier = Modifier.height(30.dp))

                AppInput(
                    label = stringResource(id = com.feature.payment.ui.R.string.payment_screen_3_input_label),
                    note = stringResource(
                        id = com.feature.payment.ui.R.string.payment_screen_3_input_note
                    ),
                    data = _data
                ) {

                    _data = it


                }
            }

            val context = LocalContext.current
            val bio by remember {
                mutableStateOf(context.getActivity()?.let {
                    BiometricPromptManager(activity = it)
                })
            }
            val bioResult by bio!!.promptResults.collectAsState(initial = null)

            AppButton(
                title = stringResource(id = com.feature.payment.ui.R.string.payment_screen_3_title),
                background = AppColors.Green2
            ) {
                bio?.showBiometricPrompt("test", "test description")

            }

            when(bioResult){
                is BiometricPromptManager.BiometricResult.AuthenticationError -> {

                }
                BiometricPromptManager.BiometricResult.AuthenticationFailed -> {

                }
                BiometricPromptManager.BiometricResult.AuthenticationNotSet -> {

                }
                BiometricPromptManager.BiometricResult.AuthenticationSuccess -> {

                    navController.navigate(PaymentFeatureRoutes.paymentReceiptRoute) {
                        popUpTo(PaymentFeatureRoutes.paymentReceiptRoute) {
                            inclusive = true
                        }
                    }
                }
                BiometricPromptManager.BiometricResult.FeatureUnavailable -> {

                }
                BiometricPromptManager.BiometricResult.HardwareUnavailable -> {

                }
                null -> {

                }
            }
        }
    }
}