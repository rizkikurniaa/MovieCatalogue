package com.kikulabs.moviecatalogue.ui.favorite.movie

import androidx.lifecycle.ViewModel
import com.kikulabs.moviecatalogue.data.source.MovieCatalogueRepository

class FavoriteMovieViewModel(private val repository: MovieCatalogueRepository) : ViewModel() {

    fun getFavMovies() = repository.getFavoriteMovies()

}