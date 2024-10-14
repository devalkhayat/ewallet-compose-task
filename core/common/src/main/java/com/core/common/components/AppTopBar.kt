package com.core.common.components


import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.TopAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.core.common.R
import com.core.common.theme.AppColors
import com.core.common.theme.Header20
import com.core.common.theme.getColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeneralTopBar(title:String, titleColor:AppColors, iconsColor:AppColors=AppColors.White,iconsBorderColor:AppColors=AppColors.White3, iconsBackground:AppColors, background:AppColors=AppColors.Transparent, @DrawableRes leftIcon:Int,@DrawableRes rightIcon:Int?=null) {
    CenterAlignedTopAppBar(title =
    {
        AppLabel(caption = title, style = MaterialTheme.typography.Header20, color = titleColor)
    },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = getColor(background)),
        navigationIcon = {

            DrawAppIcon(borderColor = iconsBorderColor,iconColor=iconsColor,leftIcon){

            }
    },
        actions = {
            rightIcon?.let { DrawAppIcon(borderColor = iconsBorderColor,iconColor=iconsColor,it){

            } }

        },
        windowInsets = WindowInsets(
            right = 4.dp,
            left = 4.dp
        ),
    )
}





@Preview(showSystemUi = true)
@Composable
fun PrevAppTopBar(){

}