package com.kikulabs.moviecatalogue.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kikulabs.moviecatalogue.BuildConfig.IMAGE_URL
import com.kikulabs.moviecatalogue.R
import com.kikulabs.moviecatalogue.data.source.local.entity.DetailEntity
import com.kikulabs.moviecatalogue.databinding.ActivityDetailMovieBinding
import com.kikulabs.moviecatalogue.databinding.ContentDetailMovieBinding
import com.kikulabs.moviecatalogue.utils.DateChange
import com.kikulabs.moviecatalogue.viewmodel.ViewModelFactory

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TYPE = "extra_type"
    }

    private lateinit var detailContentBinding: ContentDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailMovieBinding.detailContent

        setContentView(activityDetailMovieBinding.root)

        setSupportActionBar(activityDetailMovieBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        showProgressBar(true)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(
            this,
            factory
        )[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {

            val id = extras.getInt(EXTRA_MOVIE)
            val type = extras.getString(EXTRA_TYPE)

            if (type != null) {
                if (type.equals("TV_SHOW", ignoreCase = true)) {
                    supportActionBar?.title = "Detail Tv Show"
                }
                viewModel.setSelected(id.toString(), type)
                viewModel.getDetail().observe(this, { detail ->
                    setDetail(detail)
                    showProgressBar(false)
                })
            }
        }
    }

    private fun showProgressBar(state: Boolean) {
        detailContentBinding.progressBar.isVisible = state
    }

    private fun setDetail(data: DetailEntity) {
        val dateChange = DateChange()

        detailContentBinding.tvTitle.text = data.title
        detailContentBinding.tvReleaseDate.text = dateChange.changeFormatDate(data.releaseDate)
        detailContentBinding.tvRating.text = data.rating.toString()
        detailContentBinding.tvLanguage.text = data.language
        detailContentBinding.tvOverviewValue.text = data.overview

        Glide.with(this)
            .asBitmap()
            .load(IMAGE_URL + data.poster).apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(detailContentBinding.ivMovie)
    }
}