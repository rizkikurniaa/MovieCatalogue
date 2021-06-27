package com.kikulabs.moviecatalogue.ui.favorite

import androidx.lifecycle.ViewModel
import com.kikulabs.moviecatalogue.data.source.MovieCatalogueRepository

class FavoriteViewModel (private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {

    fun getFavMovies() = movieCatalogueRepository.getFavoriteMovies()
    fun getFavTvShows() = movieCatalogueRepository.getFavoriteTvShows()

}