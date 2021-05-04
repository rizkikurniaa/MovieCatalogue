package com.kikulabs.moviecatalogue.data

data class DataEntity (
    var movieId: String,
    var title: String,
    var poster: Int,
    var releaseDate: String,
    var rating: String,
    var language: String,
    var overview: String
)