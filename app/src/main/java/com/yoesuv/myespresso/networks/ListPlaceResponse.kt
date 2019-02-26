package com.yoesuv.myespresso.networks

import com.yoesuv.myespresso.menu.list.models.PlaceModel
import io.reactivex.Observable

class ListPlaceResponse {

    private val apiService = ServiceFactory.create()

    fun getListPlace(): Observable<MutableList<PlaceModel>> {
        return apiService.getListPlace()
    }
}