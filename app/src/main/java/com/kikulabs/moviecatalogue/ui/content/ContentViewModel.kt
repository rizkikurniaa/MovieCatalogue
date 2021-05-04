package com.kikulabs.moviecatalogue.ui.content

import androidx.lifecycle.ViewModel
import com.kikulabs.moviecatalogue.data.DataEntity
import com.kikulabs.moviecatalogue.utils.DataDummy

class ContentViewModel: ViewModel() {
    fun getMovie() : List<DataEntity> = DataDummy.generateDummyMovies()

    fun getTvShow() : List<DataEntity> = DataDummy.generateDummyTvShows()
}