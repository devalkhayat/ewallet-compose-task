package com.example.ewallet

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton

import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.core.common.components.AppBottomNavigationBar
import com.core.common.components.DrawRound
import com.core.common.theme.AppColors
import com.core.common.theme.EwalletTheme
import com.core.common.theme.Label12
import com.core.common.theme.getColor
import com.core.feature_api.PaymentFeatureRoutes
import com.example.ewallet.navigation.AppNavGraph
import com.example.ewallet.navigation.NavigationProvider
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navigationProvider: NavigationProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {

           /* val view = LocalView.current
            val activity = view.context as Activity
            activity.window.statusBarColor = Color.WHITE*/
           /* enableEdgeToEdge(statusBarStyle = SystemBarStyle.auto(
                MaterialTheme.colorScheme.primary.toArgb(),
                MaterialTheme.colorScheme.primary.toArgb()
            ))*/
            EwalletTheme {

                val navController= rememberNavController()
                App(navHostController = navController)
            }
        }
    }

    @Composable
    fun App(navHostController: NavHostController){



            Scaffold(modifier = Modifier.fillMaxSize(),
                bottomBar = { AppBottomNavigationBar(navController = navHostController) },
                floatingActionButtonPosition = FabPosition.Center,
                isFloatingActionButtonDocked = true,
                floatingActionButton = {

                    FloatingActionButton(
                        onClick = {
                            navHostController.navigate(PaymentFeatureRoutes.nestedRoute) {
                                popUpTo(PaymentFeatureRoutes.homeScreenRoute) {
                                    inclusive = true
                                }
                            }
                        },
                        backgroundColor =   com.core.common.theme.getColor(AppColors.Orange1),


                    ) {
                        Icon(
                            painter = painterResource(id = com.core.common.R.drawable.ic_nav_scan_unchecked),
                            contentDescription = null,

                            tint = com.core.common.theme.getColor(AppColors.White)
                        )

                    }

                },
                contentColor = getColor(AppColors.White)) { innerPadding ->
                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)) {

                    AppNavGraph(
                        navController = navHostController,
                        navigationProvider = navigationProvider
                    )
                }

            }

        }
        }











@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EwalletTheme {

    }
}