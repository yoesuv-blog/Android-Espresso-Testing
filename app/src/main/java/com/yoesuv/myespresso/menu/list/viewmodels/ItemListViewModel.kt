package com.yoesuv.myespresso.menu.list.viewmodels

import android.arch.lifecycle.ViewModel
import android.content.Context
import android.content.Intent
import android.databinding.ObservableField
import android.util.Log
import android.view.View
import com.yoesuv.myespresso.data.Constants
import com.yoesuv.myespresso.menu.list.models.PlaceModel
import com.yoesuv.myespresso.menu.list.views.DetailMyListActivity
import java.lang.ref.WeakReference

class ItemListViewModel(placeModel: PlaceModel, private val weakContext: WeakReference<Context>): ViewModel() {

    var title: ObservableField<String> = ObservableField()
    var place: ObservableField<String> = ObservableField()
    var thumbnail: ObservableField<String> = ObservableField()

    init {
        title.set(placeModel.nama)
        place.set(placeModel.lokasi)
        thumbnail.set(placeModel.thumbnail)
    }

    fun clickItem(view: View) {
        Log.d(Constants.LOG_DEBUG,"ItemListViewModel # click item ${title.get()}")
        val intent = Intent(weakContext.get(), DetailMyListActivity::class.java)
        weakContext.get()?.startActivity(intent)
    }

}