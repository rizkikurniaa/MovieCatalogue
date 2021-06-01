package com.kikulabs.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kikulabs.moviecatalogue.data.source.MovieCatalogueRepository
import com.kikulabs.moviecatalogue.data.source.local.entity.DetailEntity

class DetailMovieViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) :
    ViewModel() {
    companion object {
        const val MOVIE = "MOVIE"
        const val TV_SHOW = "TV_SHOW"
    }

    private lateinit var detailData: LiveData<DetailEntity>

    fun setSelected(id: String, type: String) {
        when (type) {
            MOVIE -> {
                detailData = movieCatalogueRepository.getDetailMovie(id)
            }
            TV_SHOW -> {
                detailData = movieCatalogueRepository.getDetailTvShow(id)
            }
        }
    }

    fun getDetail() = detailData

}