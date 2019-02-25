package com.yoesuv.myespresso.menu.auth.viewmodels

import android.app.Activity
import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.content.Intent
import android.util.Log
import android.view.View
import com.yoesuv.myespresso.R
import com.yoesuv.myespresso.data.Constants
import com.yoesuv.myespresso.menu.list.views.MyListActivity
import com.yoesuv.myespresso.utils.ActivityHelper
import com.yoesuv.myespresso.utils.bindings.BindableString
import java.lang.ref.WeakReference

class LoginViewModel(application: Application, private val weakActivity: WeakReference<Activity>) : AndroidViewModel(application) {

    var username: BindableString = BindableString()
    var password: BindableString = BindableString()

    init {
        username.set("")
        password.set("")
    }

    fun clickLogin(v: View){
        Log.d(Constants.LOG_DEBUG,"LoginViewModel # click login username:${username.get()}/password:${password.get()}")
        dummyLogin(username.get(), password.get())
    }

    private fun dummyLogin(username: String, password: String){
        if (username.equals("admin", false) && password.equals("password", false)) {
            val intent = Intent(weakActivity.get(), MyListActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            weakActivity.get()?.startActivity(intent)
        } else {
            ActivityHelper.displayToast(weakActivity.get()!!.applicationContext, R.string.toast_login_failed)
        }
    }

}