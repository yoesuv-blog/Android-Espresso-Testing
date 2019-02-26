package com.yoesuv.myespresso.menu.auth.viewmodels

import android.app.Activity
import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import java.lang.ref.WeakReference

class LoginViewModelProviders(private val application: Application, private val weakActivity: WeakReference<Activity>): ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(application, weakActivity) as T
    }
}