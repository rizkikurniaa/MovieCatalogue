package com.kikulabs.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kikulabs.moviecatalogue.data.source.MovieCatalogueRepository
import com.kikulabs.moviecatalogue.data.source.local.entity.MovieEntity
import com.kikulabs.moviecatalogue.data.source.local.entity.TvShowEntity
import com.kikulabs.moviecatalogue.vo.Resource

class DetailMovieViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) :
    ViewModel() {
    companion object {
        const val MOVIE = "MOVIE"
        const val TV_SHOW = "TV_SHOW"
    }

    private lateinit var detailMovie: LiveData<Resource<MovieEntity>>
    private lateinit var detailTvShow: LiveData<Resource<TvShowEntity>>

    fun setSelected(id: String, type: String) {
        when (type) {
            MOVIE -> {
                detailMovie = movieCatalogueRepository.getDetailMovie(id.toInt())
            }
            TV_SHOW -> {
                detailTvShow = movieCatalogueRepository.getDetailTvShow(id.toInt())
            }
        }
    }

    fun setFavoriteMovie() {
        val resource = detailMovie.value
        if (resource?.data != null) {
            val newState = !resource.data.isFav
            movieCatalogueRepository.setFavoriteMovie(resource.data, newState)
        }
    }

    fun setFavoriteTvShow() {
        val resource = detailTvShow.value
        if (resource?.data != null) {
            val newState = !resource.data.isFav
            movieCatalogueRepository.setFavoriteTvShow(resource.data, newState)
        }
    }

    fun getDetailMovie() = detailMovie

    fun getDetailTvShow() = detailTvShow

}