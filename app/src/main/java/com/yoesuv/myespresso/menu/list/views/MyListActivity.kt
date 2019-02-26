package com.yoesuv.myespresso.menu.list.views

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.yoesuv.myespresso.R
import com.yoesuv.myespresso.databinding.ActivityListBinding
import com.yoesuv.myespresso.menu.list.adapters.MyListAdapter
import com.yoesuv.myespresso.menu.list.models.PlaceModel
import com.yoesuv.myespresso.menu.list.viewmodels.MyListViewModel
import java.util.*

class MyListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    private lateinit var viewModel: MyListViewModel

    private var listData: MutableList<PlaceModel> = mutableListOf()
    private lateinit var adapter: MyListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list)
        viewModel = ViewModelProviders.of(this).get(MyListViewModel::class.java)
        binding.list = viewModel

        setupRecycler()
        setupSwipeRefresh()
        observeLiveData()

        viewModel.getListPlace()
    }

    private fun setupRecycler(){
        val layoutManager = LinearLayoutManager(this)
        adapter = MyListAdapter(listData)
        binding.recyclerViewList.layoutManager = layoutManager
        binding.recyclerViewList.adapter = adapter
    }

    private fun setupSwipeRefresh() {
        binding.swipeRefreshList.setOnRefreshListener {
            viewModel.getListPlace()
        }
    }

    private fun observeLiveData(){
        viewModel.isLoading.observe(this, Observer {
            binding.swipeRefreshList.isRefreshing = it!!
        })
        viewModel.myListData.observe(this, Observer {
            listData.clear()
            for (i:Int in 0 until it!!.size) {
                listData.add(it[i])
            }
            adapter.notifyDataSetChanged()
        })
    }

}