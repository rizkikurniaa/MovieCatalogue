package com.kikulabs.moviecatalogue.ui.content

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.kikulabs.moviecatalogue.data.source.MovieCatalogueRepository
import com.kikulabs.moviecatalogue.data.source.local.entity.DataEntity
import com.kikulabs.moviecatalogue.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ContentViewModelTest {

    private lateinit var viewModel: ContentViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var observer: Observer<List<DataEntity>>

    @Before
    fun setUp() {
        viewModel = ContentViewModel(movieCatalogueRepository)
    }

    @Test
    fun getMovie() {
        val dummyMovies = DataDummy.getMovies()
        val movies = MutableLiveData<List<DataEntity>>()
        movies.value = dummyMovies

        Mockito.`when`(movieCatalogueRepository.getMovies()).thenReturn(movies)
        val movie = viewModel.getMovie().value
        verify(movieCatalogueRepository).getMovies()
        assertNotNull(movie)
        assertEquals(3, movie?.size)

        viewModel.getMovie().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }

    @Test
    fun getTvShow() {
        val dummyTvShow = DataDummy.getTvShows()
        val tvShows = MutableLiveData<List<DataEntity>>()
        tvShows.value = dummyTvShow

        Mockito.`when`(movieCatalogueRepository.getTvShows()).thenReturn(tvShows)
        val tvShow = viewModel.getTvShow().value
        verify(movieCatalogueRepository).getTvShows()
        assertNotNull(tvShow)
        assertEquals(3, tvShow?.size)

        viewModel.getTvShow().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}