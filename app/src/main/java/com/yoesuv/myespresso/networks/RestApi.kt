package com.yoesuv.myespresso.networks

import com.yoesuv.myespresso.menu.list.models.PlaceModel
import io.reactivex.Observable
import retrofit2.http.GET

interface RestApi {

    @GET("List_place_malang_batu.json")
    fun getListPlace(): Observable<MutableList<PlaceModel>>
}