package com.kikulabs.moviecatalogue.ui.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kikulabs.moviecatalogue.BuildConfig.IMAGE_URL
import com.kikulabs.moviecatalogue.R
import com.kikulabs.moviecatalogue.data.source.local.entity.MovieEntity
import com.kikulabs.moviecatalogue.data.source.local.entity.TvShowEntity
import com.kikulabs.moviecatalogue.databinding.ActivityDetailMovieBinding
import com.kikulabs.moviecatalogue.databinding.ContentDetailMovieBinding
import com.kikulabs.moviecatalogue.ui.detail.DetailMovieViewModel.Companion.MOVIE
import com.kikulabs.moviecatalogue.ui.detail.DetailMovieViewModel.Companion.TV_SHOW
import com.kikulabs.moviecatalogue.utils.DateChange
import com.kikulabs.moviecatalogue.viewmodel.ViewModelFactory
import com.kikulabs.moviecatalogue.vo.Status

class DetailMovieActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TYPE = "extra_type"
    }

    private lateinit var activityDetailMovieBinding: ActivityDetailMovieBinding
    private lateinit var detailContentBinding: ContentDetailMovieBinding
    private lateinit var viewModel: DetailMovieViewModel
    private var type: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailMovieBinding.detailContent
        setContentView(activityDetailMovieBinding.root)

        setSupportActionBar(activityDetailMovieBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        activityDetailMovieBinding.toolbar.setNavigationOnClickListener { onBackPressed() }

        showProgressBar(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(
            this,
            factory
        )[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {

            val id = extras.getString(EXTRA_MOVIE)
            type = extras.getString(EXTRA_TYPE)

            if (type != null) {
                viewModel.setSelected(id.toString(), type.toString())
                if (type.equals(MOVIE, ignoreCase = true)) {
                    viewModel.getDetailMovie().observe(this, { detail ->
                        when (detail.status) {
                            Status.LOADING -> showProgressBar(true)
                            Status.SUCCESS -> {
                                if (detail.data != null) {
                                    showProgressBar(false)
                                    setDetailMovie(detail.data)
                                    val state = detail.data.isFav
                                    setFavoriteState(state)
                                }
                            }
                            Status.ERROR -> {
                                showProgressBar(false)
                                Toast.makeText(
                                    applicationContext,
                                    "Terjadi kesalahan",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    })
                } else if (type.equals(TV_SHOW, ignoreCase = true)) {
                    supportActionBar?.title = "Detail Tv Show"
                    viewModel.getDetailTvShow().observe(this, { detail ->
                        when (detail.status) {
                            Status.LOADING -> showProgressBar(true)
                            Status.SUCCESS -> {
                                if (detail.data != null) {
                                    showProgressBar(false)
                                    setDetailTvShow(detail.data)
                                    val state = detail.data.isFav
                                    setFavoriteState(state)
                                }
                            }
                            Status.ERROR -> {
                                showProgressBar(false)
                                Toast.makeText(
                                    applicationContext,
                                    "Terjadi kesalahan",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    })
                }

            }
        }

        activityDetailMovieBinding.fabAddToFavorite.setOnClickListener(this)
    }

    private fun showProgressBar(state: Boolean) {
        detailContentBinding.progressBar.isVisible = state
    }

    private fun onFavFabClicked() {
        if (type == MOVIE) {
            viewModel.setFavoriteMovie()
        } else if (type == TV_SHOW) {
            viewModel.setFavoriteTvShow()
        }
    }

    private fun setFavoriteState(state: Boolean) {
        val fab = activityDetailMovieBinding.fabAddToFavorite
        if (state) {
            fab.setImageResource(R.drawable.ic_favorite_filled)
        } else {
            fab.setImageResource(R.drawable.ic_favorite_empty)
        }
    }

    private fun setDetailMovie(data: MovieEntity) {
        val dateChange = DateChange()

        detailContentBinding.tvTitle.text = data.title
        detailContentBinding.tvReleaseDate.text = dateChange.changeFormatDate(data.releaseDate)
        detailContentBinding.tvRating.text = data.voteAverage.toString()
        detailContentBinding.tvLanguage.text = data.language
        detailContentBinding.tvOverviewValue.text = data.overview

        Glide.with(this)
            .asBitmap()
            .load(IMAGE_URL + data.posterPath).apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(detailContentBinding.ivMovie)
    }

    private fun setDetailTvShow(data: TvShowEntity) {
        val dateChange = DateChange()

        detailContentBinding.tvTitle.text = data.name
        detailContentBinding.tvReleaseDate.text = dateChange.changeFormatDate(data.releaseDate)
        detailContentBinding.tvRating.text = data.voteAverage.toString()
        detailContentBinding.tvLanguage.text = data.language
        detailContentBinding.tvOverviewValue.text = data.overview

        Glide.with(this)
            .asBitmap()
            .load(IMAGE_URL + data.posterPath).apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(detailContentBinding.ivMovie)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.fab_add_to_favorite -> {
                onFavFabClicked()
            }
        }
    }
}