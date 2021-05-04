package com.kikulabs.moviecatalogue.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kikulabs.moviecatalogue.databinding.ActivityDetailMovieBinding
import com.kikulabs.moviecatalogue.databinding.ContentDetailMovieBinding
import com.kikulabs.moviecatalogue.utils.DataDummy

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var detailContentBinding: ContentDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailMovieBinding.detailContent

        setContentView(activityDetailMovieBinding.root)

        setSupportActionBar(activityDetailMovieBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            if (movieId != null) {

                }
            }
    }
}