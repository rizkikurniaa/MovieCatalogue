package com.kikulabs.moviecatalogue.ui.detail

import androidx.lifecycle.ViewModel
import com.kikulabs.moviecatalogue.data.DataEntity
import com.kikulabs.moviecatalogue.utils.DataDummy

class DetailMovieViewModel: ViewModel() {

    private lateinit var movieId: String
    private lateinit var tvShowId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun setSelectedTvShow(tvShowId: String) {
        this.tvShowId = tvShowId
    }

    fun getMovie(): DataEntity {
        lateinit var movie: DataEntity
        val moviesEntities = DataDummy.generateDummyMovies()
        for (movieEntity in moviesEntities) {
            if (movieEntity.id == movieId) {
                movie = movieEntity
            }
        }
        return movie
    }

    fun getTvShow(): DataEntity {
        lateinit var tvShow: DataEntity
        val tvShowsEntities = DataDummy.generateDummyTvShows()
        for (tvShowEntity in tvShowsEntities) {
            if (tvShowEntity.id == tvShowId) {
                tvShow = tvShowEntity
            }
        }
        return tvShow
    }

}