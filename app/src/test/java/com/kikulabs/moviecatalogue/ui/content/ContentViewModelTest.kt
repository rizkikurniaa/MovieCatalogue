package com.kikulabs.moviecatalogue.ui.content

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class ContentViewModelTest {

    private lateinit var viewModel: ContentViewModel

    @Before
    fun setUp(){
        viewModel = ContentViewModel()
    }

    @Test
    fun getMovie() {
        val movieEntities = viewModel.getMovie()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities.size)
    }

    @Test
    fun getTvShow() {
        val tvShowEntities = viewModel.getTvShow()
        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities.size)
    }
}