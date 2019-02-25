package com.yoesuv.myespresso.menu.list.views

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yoesuv.myespresso.R
import com.yoesuv.myespresso.databinding.ActivityListBinding
import com.yoesuv.myespresso.menu.list.viewmodels.ListViewModel

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    private lateinit var viewModel: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list)
        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        binding.list = viewModel
    }

}