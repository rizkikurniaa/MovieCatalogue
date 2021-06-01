package com.kikulabs.moviecatalogue.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.kikulabs.moviecatalogue.data.source.MovieCatalogueRepository
import com.kikulabs.moviecatalogue.data.source.local.entity.DetailEntity
import com.kikulabs.moviecatalogue.ui.detail.DetailMovieViewModel.Companion.MOVIE
import com.kikulabs.moviecatalogue.ui.detail.DetailMovieViewModel.Companion.TV_SHOW
import com.kikulabs.moviecatalogue.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel

    private val dummyMovie = DataDummy.getDetailMovie()
    private val dummyTvShow = DataDummy.getDetailTvShow()

    private val movieId = dummyMovie.id.toString()
    private val tvShowId = dummyTvShow.id.toString()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var contentObserver: Observer<DetailEntity>

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(movieCatalogueRepository)
    }

    @Test
    fun getMovie() {
        val movie = MutableLiveData<DetailEntity>()
        movie.value = dummyMovie

        `when`(movieCatalogueRepository.getDetailMovie(movieId)).thenReturn(movie)
        viewModel.setSelected(movieId, MOVIE)
        val detailEntity = viewModel.getDetail().value as DetailEntity
        verify(movieCatalogueRepository).getDetailMovie(movieId)

        assertNotNull(detailEntity)
        assertEquals(dummyMovie.id, detailEntity.id)
        assertEquals(dummyMovie.title, detailEntity.title)
        assertEquals(dummyMovie.poster, detailEntity.poster)
        assertEquals(dummyMovie.releaseDate, detailEntity.releaseDate)
        assertEquals(dummyMovie.rating.toInt(), detailEntity.rating.toInt())
        assertEquals(dummyMovie.language, detailEntity.language)
        assertEquals(dummyMovie.overview, detailEntity.overview)

        viewModel.getDetail().observeForever(contentObserver)
        verify(contentObserver).onChanged(dummyMovie)
    }

    @Test
    fun getTvShow() {

        val tvShow = MutableLiveData<DetailEntity>()
        tvShow.value = dummyTvShow

        `when`(movieCatalogueRepository.getDetailTvShow(tvShowId)).thenReturn(tvShow)
        viewModel.setSelected(tvShowId, TV_SHOW)
        val detailEntity = viewModel.getDetail().value as DetailEntity
        verify(movieCatalogueRepository).getDetailTvShow(tvShowId)

        assertNotNull(detailEntity)
        assertEquals(dummyTvShow.id, detailEntity.id)
        assertEquals(dummyTvShow.title, detailEntity.title)
        assertEquals(dummyTvShow.poster, detailEntity.poster)
        assertEquals(dummyTvShow.releaseDate, detailEntity.releaseDate)
        assertEquals(dummyTvShow.rating.toInt(), detailEntity.rating.toInt())
        assertEquals(dummyTvShow.language, detailEntity.language)
        assertEquals(dummyTvShow.overview, detailEntity.overview)

        viewModel.getDetail().observeForever(contentObserver)
        verify(contentObserver).onChanged(dummyTvShow)
    }
}