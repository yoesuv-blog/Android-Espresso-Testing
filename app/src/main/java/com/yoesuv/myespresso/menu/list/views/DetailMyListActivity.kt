package com.yoesuv.myespresso.menu.list.views

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yoesuv.myespresso.R
import com.yoesuv.myespresso.databinding.ActivityDetailBinding
import com.yoesuv.myespresso.menu.list.viewmodels.DetailMyListViewModel

class DetailMyListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: DetailMyListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        viewModel = ViewModelProviders.of(this).get(DetailMyListViewModel::class.java)
        binding.detail = viewModel
    }
}