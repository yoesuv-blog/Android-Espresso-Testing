package com.yoesuv.myespresso.menu.list.viewmodels

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.yoesuv.myespresso.menu.list.models.PlaceModel

class ItemListViewModel(placeModel: PlaceModel): ViewModel() {

    var title: ObservableField<String> = ObservableField()
    var place: ObservableField<String> = ObservableField()
    var thumbnail: ObservableField<String> = ObservableField()

    init {
        title.set(placeModel.nama)
        place.set(placeModel.lokasi)
        thumbnail.set(placeModel.thumbnail)
    }

}