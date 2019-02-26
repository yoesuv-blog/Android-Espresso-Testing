package com.yoesuv.myespresso.menu.list.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableField
import com.yoesuv.myespresso.menu.list.models.PlaceModel

class DetailMyListViewModel(application: Application) : AndroidViewModel(application) {

    var title: ObservableField<String> = ObservableField()
    var description: ObservableField<String> = ObservableField()
    var image: ObservableField<String> = ObservableField()

    fun showData(model: PlaceModel?) {
        title.set(model?.nama)
        description.set(model?.deskripsi)
        image.set(model?.gambar)
    }

}