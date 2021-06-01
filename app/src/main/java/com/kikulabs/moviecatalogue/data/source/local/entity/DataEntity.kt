package com.kikulabs.moviecatalogue.data.source.local.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataEntity(
    var id: Int,
    var title: String,
    var poster: String,
    var releaseDate: String,
    var rating: Double,
    var overview: String
) : Parcelable