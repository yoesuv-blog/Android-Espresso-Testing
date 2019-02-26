package com.yoesuv.myespresso.menu.list.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlaceModel(
    @SerializedName("deskripsi") @Expose val deskripsi: String,
    @SerializedName("gambar") @Expose val gambar: String,
    @SerializedName("lokasi") @Expose val lokasi: String,
    @SerializedName("nama") @Expose val nama: String,
    @SerializedName("thumbnail") @Expose val thumbnail: String
): Parcelable