package com.kikulabs.moviecatalogue.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kikulabs.moviecatalogue.BuildConfig.API_KEY
import com.kikulabs.moviecatalogue.data.source.remote.response.movie.MovieDetailResponse
import com.kikulabs.moviecatalogue.data.source.remote.response.movie.MovieList
import com.kikulabs.moviecatalogue.data.source.remote.response.movie.MoviesResponse
import com.kikulabs.moviecatalogue.data.source.remote.response.tv.TvShowDetailResponse
import com.kikulabs.moviecatalogue.data.source.remote.response.tv.TvShowList
import com.kikulabs.moviecatalogue.data.source.remote.response.tv.TvShowResponse
import com.kikulabs.moviecatalogue.network.ApiConfig
import com.kikulabs.moviecatalogue.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }
    }

    fun getMovies(): LiveData<ApiResponse<List<MovieList>>> {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getMovies(API_KEY)
        val resultMovies = MutableLiveData<ApiResponse<List<MovieList>>>()

        client.enqueue(object : Callback<MoviesResponse> {
            override fun onResponse(
                call: Call<MoviesResponse>,
                response: Response<MoviesResponse>
            ) {
                resultMovies.value = ApiResponse.success(response.body()?.results as List<MovieList>)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "getMovies onFailure : ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })

        return resultMovies
    }

    fun getDetailMovie(movieId: String): LiveData<ApiResponse<MovieDetailResponse>> {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getMovieDetail(movieId, API_KEY)
        val resultDetailMovie = MutableLiveData<ApiResponse<MovieDetailResponse>>()

        client.enqueue(object : Callback<MovieDetailResponse> {
            override fun onResponse(
                call: Call<MovieDetailResponse>,
                response: Response<MovieDetailResponse>
            ) {
                resultDetailMovie.value = ApiResponse.success(response.body() as MovieDetailResponse)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "getMovieDetail onFailure : ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })

        return resultDetailMovie
    }

    fun getTvShows(): LiveData<ApiResponse<List<TvShowList>>> {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getTvShows(API_KEY)
        val resultTvShows = MutableLiveData<ApiResponse<List<TvShowList>>>()

        client.enqueue(object : Callback<TvShowResponse> {
            override fun onResponse(
                call: Call<TvShowResponse>,
                response: Response<TvShowResponse>
            ) {
                resultTvShows.value = ApiResponse.success(response.body()?.results as List<TvShowList>)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "getTvShows onFailure : ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })

        return resultTvShows
    }

    fun getDetailTvShow(tvShowId: String): LiveData<ApiResponse<TvShowDetailResponse>> {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getTvShowDetail(tvShowId, API_KEY)
        val resultDetailTvShow = MutableLiveData<ApiResponse<TvShowDetailResponse>>()

        client.enqueue(object : Callback<TvShowDetailResponse> {
            override fun onResponse(
                call: Call<TvShowDetailResponse>,
                response: Response<TvShowDetailResponse>
            ) {
                resultDetailTvShow.value = ApiResponse.success(response.body() as TvShowDetailResponse)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvShowDetailResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "getDetailTvShow onFailure : ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })

        return resultDetailTvShow
    }

    //delete soon
    interface LoadMoviesCallback {
        fun onMoviesLoaded(movies: List<MovieList>?)
    }

    interface LoadDetailMovieCallback {
        fun onDetailMovieLoaded(movieDetail: MovieDetailResponse?)
    }

    interface LoadTvShowsCallback {
        fun onTvShowsLoaded(tvShows: List<TvShowList>?)
    }

    interface LoadDetailTvShowCallback {
        fun onDetailTvShowLoaded(tvShowDetail: TvShowDetailResponse?)
    }
}