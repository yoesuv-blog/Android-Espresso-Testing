package com.yoesuv.myespresso.utils.bindings

import android.databinding.BaseObservable
import org.parceler.Parcel

@Parcel
class BindableString: BaseObservable() {
    internal var value: String? = null

    val isEmpty: Boolean
        get() = value == null || value!!.isEmpty()

    fun get(): String {
        return value ?: ""
    }

    fun set(value: String?) {
        if (!MyObjects.equals(this.value, value)) {
            this.value = value
            notifyChange()
        }
    }
}