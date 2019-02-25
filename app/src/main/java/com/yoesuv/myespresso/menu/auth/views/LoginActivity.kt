package com.yoesuv.myespresso.menu.auth.views

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.yoesuv.myespresso.R
import com.yoesuv.myespresso.databinding.ActivityLoginBinding
import com.yoesuv.myespresso.menu.auth.viewmodels.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding:ActivityLoginBinding
    private lateinit var viewModel:LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding.login = viewModel
    }
}
