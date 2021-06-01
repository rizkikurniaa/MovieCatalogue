package com.kikulabs.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import com.kikulabs.moviecatalogue.data.source.local.entity.DataEntity
import com.kikulabs.moviecatalogue.data.source.local.entity.DetailEntity

interface MovieCatalogueDataSource {
    fun getMovies(): LiveData<List<DataEntity>>
    fun getDetailMovie(movieId: String): LiveData<DetailEntity>
    fun getTvShows(): LiveData<List<DataEntity>>
    fun getDetailTvShow(tvShowId: String): LiveData<DetailEntity>
}