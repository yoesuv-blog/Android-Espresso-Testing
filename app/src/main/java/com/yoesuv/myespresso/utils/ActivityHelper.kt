package com.yoesuv.myespresso.utils

import android.content.Context
import android.widget.Toast

object ActivityHelper {

    fun displayToast(context: Context,message: Int) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}