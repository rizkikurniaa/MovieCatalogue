package com.kikulabs.moviecatalogue.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kikulabs.moviecatalogue.R
import com.kikulabs.moviecatalogue.data.DataEntity
import com.kikulabs.moviecatalogue.databinding.ActivityDetailMovieBinding
import com.kikulabs.moviecatalogue.databinding.ContentDetailMovieBinding

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TYPE = "extra_type"
    }

    private lateinit var content: DataEntity

    private lateinit var detailContentBinding: ContentDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailMovieBinding.detailContent

        setContentView(activityDetailMovieBinding.root)

        setSupportActionBar(activityDetailMovieBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val id = extras.getString(EXTRA_MOVIE)
            val type = extras.getString(EXTRA_TYPE)

            if (type.equals("MOVIE", ignoreCase = true)) {
                if (id != null) {
                    viewModel.setSelectedMovie(id)
                }
                content = viewModel.getMovie()
            } else if (type.equals("TV_SHOW", ignoreCase = true)) {
                if (id != null) {
                    viewModel.setSelectedTvShow(id)
                }
                content = viewModel.getTvShow()
                supportActionBar?.title = "Detail Tv Show"
            }

            detailContentBinding.tvTitle.text = content.title
            detailContentBinding.tvReleaseDate.text = content.releaseDate
            detailContentBinding.tvRating.text = content.rating
            detailContentBinding.tvLanguage.text = content.language
            detailContentBinding.tvOverviewValue.text = content.overview

            Glide.with(this)
                .load(content.poster).apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(detailContentBinding.ivMovie)

        }
    }
}