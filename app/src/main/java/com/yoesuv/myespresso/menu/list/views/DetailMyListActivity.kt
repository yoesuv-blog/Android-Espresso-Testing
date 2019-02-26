package com.yoesuv.myespresso.menu.list.views

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.yoesuv.myespresso.R
import com.yoesuv.myespresso.databinding.ActivityDetailBinding
import com.yoesuv.myespresso.menu.list.models.PlaceModel
import com.yoesuv.myespresso.menu.list.viewmodels.DetailMyListViewModel

class DetailMyListActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA_PLACE: String = "extra_data_place"
    }

    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: DetailMyListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        viewModel = ViewModelProviders.of(this).get(DetailMyListViewModel::class.java)
        binding.detail = viewModel

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupData()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId==android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupData() {
        val placeModel: PlaceModel? = intent?.getParcelableExtra(EXTRA_DATA_PLACE)
        viewModel.showData(placeModel)
    }
}