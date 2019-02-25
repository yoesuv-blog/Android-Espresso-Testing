package com.yoesuv.myespresso.menu.auth.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.util.Log
import android.view.View
import com.yoesuv.myespresso.data.Constants
import com.yoesuv.myespresso.utils.bindings.BindableString

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    var username: BindableString = BindableString()
    var password: BindableString = BindableString()

    init {
        username.set("")
        password.set("")
    }

    fun clickLogin(v: View){
        Log.d(Constants.LOG_DEBUG,"LoginViewModel # click login username:${username.get()}/password:${password.get()}")
    }

}