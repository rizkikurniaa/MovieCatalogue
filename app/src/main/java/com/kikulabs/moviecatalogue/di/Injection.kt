package com.kikulabs.moviecatalogue.di

import android.content.Context
import com.kikulabs.moviecatalogue.data.source.MovieCatalogueRepository
import com.kikulabs.moviecatalogue.data.source.remote.RemoteDataSource

object Injection {
    fun provideRepository(context: Context): MovieCatalogueRepository {

        val remoteDataSource = RemoteDataSource.getInstance()

        return MovieCatalogueRepository.getInstance(remoteDataSource)
    }
}