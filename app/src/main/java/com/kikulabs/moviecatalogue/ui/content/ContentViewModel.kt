package com.kikulabs.moviecatalogue.ui.content

import androidx.lifecycle.ViewModel
import com.kikulabs.moviecatalogue.data.source.MovieCatalogueRepository

class ContentViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) :
    ViewModel() {
    fun getMovie(sort: String) = movieCatalogueRepository.getMovies(sort)
    fun getTvShow(sort: String) = movieCatalogueRepository.getTvShows(sort)
}