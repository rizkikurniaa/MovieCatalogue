package com.kikulabs.moviecatalogue.data.source.local.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DetailEntity(
    var id: Int,
    var title: String,
    var poster: String,
    var releaseDate: String,
    var rating: Double,
    var language: String,
    var overview: String
) : Parcelable