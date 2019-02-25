package com.yoesuv.myespresso.menu.list.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.yoesuv.myespresso.networks.ListPlaceResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MyListViewModel(application: Application) : AndroidViewModel(application) {

    private val compositeDisposable = CompositeDisposable()
    private val listPlaceResponse = ListPlaceResponse()

    fun getListPlace() {
        compositeDisposable.add(
            listPlaceResponse.getListPlace()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({

                }, {

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}