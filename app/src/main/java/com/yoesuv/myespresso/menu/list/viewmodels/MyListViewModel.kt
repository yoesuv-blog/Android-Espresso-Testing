package com.yoesuv.myespresso.menu.list.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.yoesuv.myespresso.menu.list.models.PlaceModel
import com.yoesuv.myespresso.networks.ListPlaceResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MyListViewModel(application: Application) : AndroidViewModel(application) {

    private val compositeDisposable = CompositeDisposable()
    private val listPlaceResponse = ListPlaceResponse()

    var myListData: MutableLiveData<MutableList<PlaceModel>> = MutableLiveData()
    var isLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun getListPlace() {
        isLoading.postValue(true)
        compositeDisposable.add(
            listPlaceResponse.getListPlace()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    isLoading.postValue(false)
                    myListData.postValue(it)
                }, {
                    isLoading.postValue(false)
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}