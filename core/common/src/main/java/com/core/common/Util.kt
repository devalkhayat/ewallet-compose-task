package com.core.common


import android.content.Context
import android.net.Uri

object Util {

    fun getURLForResource(resourceId: Int): String {

        return Uri.parse("android.resource://com.core.common/$resourceId")
            .toString()
    }


    /*fun getIdForResource(context:Context, path:String):Int
    {
        val uri = "@drawable/ic_bill"

        val imageResource: Int = context.resources.getIdentifier(uri, "drawable", "com.core.common")
        return  imageResource

    }*/
}
