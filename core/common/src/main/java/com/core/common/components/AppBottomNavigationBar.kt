package com.core.common.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationDefaults
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.core.common.theme.AppColors
import com.core.common.theme.getColor
import com.core.feature_api.DashboardFeatureRoutes
import com.core.feature_api.NotificationFeatureRoutes
import com.core.feature_api.PaymentFeatureRoutes
import com.core.feature_api.ProfileFeatureRoutes
import com.core.feature_api.StatisticsFeatureRoutes

@Composable
fun AppBottomNavigationBar(navController: NavHostController) {

    val screens = listOf(
        BottomBarScreens.Home,
        BottomBarScreens.Statistics,
        BottomBarScreens.Payment,
        BottomBarScreens.Notification,
        BottomBarScreens.Profile
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    BottomAppBar(
        backgroundColor = getColor(AppColors.White),
        cutoutShape = MaterialTheme.shapes.small.copy(CornerSize(percent = 50))
    ) {
        BottomNavigation(backgroundColor = Color.White) {
            screens.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }


}
sealed class BottomBarScreens(val route:String ,val title:String,@DrawableRes val uncheckedIcon:Int?,@DrawableRes val checkedIcon:Int?){
    data object Home:BottomBarScreens(route = DashboardFeatureRoutes.nestedRoute,title = "Home", uncheckedIcon =com.core.common.R.drawable.ic_nav_home_unchecked , checkedIcon =com.core.common.R.drawable.ic_nav_home_checked  )
    data object Statistics:BottomBarScreens(route = StatisticsFeatureRoutes.nestedRoute,title = "Statistics", uncheckedIcon =com.core.common.R.drawable.ic_nav_statistics_unchecked  ,checkedIcon =com.core.common.R.drawable.ic_nav_statistics_checked )
    data object Payment:BottomBarScreens(route = PaymentFeatureRoutes.nestedRoute,title = "Payment", uncheckedIcon =null  ,checkedIcon =null )
    data object Notification:BottomBarScreens(route = NotificationFeatureRoutes.nestedRoute,title = "Notification", uncheckedIcon =com.core.common.R.drawable.ic_nav_notifications_unchecked  ,checkedIcon =com.core.common.R.drawable.ic_nav_notifications_checked )
    data object Profile:BottomBarScreens(route = ProfileFeatureRoutes.nestedRoute,title = "Profile", uncheckedIcon =com.core.common.R.drawable.ic_nav_profile_unchecked  ,checkedIcon =com.core.common.R.drawable.ic_nav_profile_checked )
}
@Composable
fun RowScope.AddItem(screen: BottomBarScreens, currentDestination: NavDestination?, navController: NavHostController) {

    val isSelected = currentDestination?.hierarchy?.any { it.route == screen.route } == true

    if(screen==BottomBarScreens.Payment){
        BottomNavigationItem(
            icon = {},
            onClick = {},
            selected = isSelected,
            alwaysShowLabel = false,
            enabled = false
        )
    }else{

        BottomNavigationItem(
            icon = {


                Icon(
                    painter = painterResource(id= if (isSelected) screen.checkedIcon!! else screen.uncheckedIcon!!),
                    contentDescription = screen.title,
                    tint = Color.Unspecified

                )

            },
            onClick = {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }

            },
            selected = isSelected,
            selectedContentColor = getColor(AppColors.Green1),
            unselectedContentColor = getColor(AppColors.Gray3),
            alwaysShowLabel = false
        )
    }


}