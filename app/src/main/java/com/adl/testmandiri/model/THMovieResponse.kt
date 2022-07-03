package com.adl.testmandiri.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class THMovieResponse(
	@field:SerializedName("results")
	val movies: List<THMovie>
) : Parcelable{
	constructor(): this(mutableListOf())
}