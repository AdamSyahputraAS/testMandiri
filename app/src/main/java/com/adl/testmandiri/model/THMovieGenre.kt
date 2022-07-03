package com.adl.testmandiri.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class THMovieGenre(
    @SerializedName("genres")
    val genres : String ?,
) : Parcelable {
    constructor(): this("")
}