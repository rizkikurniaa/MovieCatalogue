package com.kikulabs.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kikulabs.moviecatalogue.data.source.local.entity.MovieEntity
import com.kikulabs.moviecatalogue.data.source.local.entity.DetailEntity
import com.kikulabs.moviecatalogue.data.source.remote.RemoteDataSource
import com.kikulabs.moviecatalogue.data.source.remote.response.movie.MovieDetailResponse
import com.kikulabs.moviecatalogue.data.source.remote.response.movie.MovieList
import com.kikulabs.moviecatalogue.data.source.remote.response.tv.TvShowDetailResponse
import com.kikulabs.moviecatalogue.data.source.remote.response.tv.TvShowList

class FakeMovieCatalogueRepository(private val remoteDataSource: RemoteDataSource) :
    MovieCatalogueDataSource {

    override fun getMovies(): LiveData<List<MovieEntity>> {
        val movieResult = MutableLiveData<List<MovieEntity>>()

        remoteDataSource.getMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onMoviesLoaded(movies: List<MovieList>?) {
                val movieList = ArrayList<MovieEntity>()
                if (movies != null) {
                    for (response in movies) {
                        with(response) {
                            val movie = MovieEntity(
                                id,
                                title,
                                posterPath,
                                releaseDate,
                                voteAverage,
                                overview
                            )
                            movieList.add(movie)
                        }
                    }
                    movieResult.postValue(movieList)
                }
            }
        })
        return movieResult
    }

    override fun getDetailMovie(movieId: String): LiveData<DetailEntity> {
        val movieDetailResult = MutableLiveData<DetailEntity>()

        remoteDataSource.getDetailMovie(object : RemoteDataSource.LoadDetailMovieCallback {
            override fun onDetailMovieLoaded(movieDetail: MovieDetailResponse?) {
                if (movieDetail != null) {
                    with(movieDetail) {

                        val detailMovie = DetailEntity(
                            id = id,
                            title = title,
                            poster = posterPath,
                            releaseDate = releaseDate,
                            rating = voteAverage,
                            language = originalLanguage,
                            overview = overview
                        )
                        movieDetailResult.postValue(detailMovie)
                    }
                }
            }
        }, movieId)
        return movieDetailResult
    }

    override fun getTvShows(): LiveData<List<MovieEntity>> {
        val tvResult = MutableLiveData<List<MovieEntity>>()

        remoteDataSource.getTvShows(object : RemoteDataSource.LoadTvShowsCallback {
            override fun onTvShowsLoaded(tvShows: List<TvShowList>?) {
                val tvList = ArrayList<MovieEntity>()
                if (tvShows != null) {
                    for (response in tvShows) {
                        with(response) {
                            val tvShow = MovieEntity(
                                id,
                                name,
                                posterPath,
                                firstAirDate,
                                voteAverage,
                                overview
                            )
                            tvList.add(tvShow)
                        }
                    }
                    tvResult.postValue(tvList)
                }
            }
        })
        return tvResult
    }

    override fun getDetailTvShow(tvShowId: String): LiveData<DetailEntity> {
        val movieDetailResult = MutableLiveData<DetailEntity>()

        remoteDataSource.getDetailTvShow(object : RemoteDataSource.LoadDetailTvShowCallback {
            override fun onDetailTvShowLoaded(tvShowDetail: TvShowDetailResponse?) {
                if (tvShowDetail != null) {
                    with(tvShowDetail) {

                        val detailTvShow = DetailEntity(
                            id = id,
                            title = name,
                            poster = posterPath,
                            releaseDate = firstAirDate,
                            rating = voteAverage,
                            language = originalLanguage,
                            overview = overview
                        )
                        movieDetailResult.postValue(detailTvShow)
                    }
                }
            }
        }, tvShowId)
        return movieDetailResult
    }
}