package com.kikulabs.moviecatalogue.ui.content.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kikulabs.moviecatalogue.data.DataEntity
import com.kikulabs.moviecatalogue.databinding.FragmentMovieBinding
import com.kikulabs.moviecatalogue.ui.content.ContentAdapter
import com.kikulabs.moviecatalogue.ui.content.ContentCallback
import com.kikulabs.moviecatalogue.ui.content.ContentViewModel
import com.kikulabs.moviecatalogue.ui.detail.DetailMovieActivity

class MovieFragment : Fragment(), ContentCallback {

    private lateinit var fragmentMovieBinding: FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val viewModel = ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            )[ContentViewModel::class.java]
            val movies = viewModel.getMovie()

            val movieAdapter =
                ContentAdapter(this@MovieFragment)
            movieAdapter.setMovies(movies)

            with(fragmentMovieBinding.rvMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

    override fun onItemClicked(data: DataEntity) {
        startActivity(
            Intent(context, DetailMovieActivity::class.java)
                .putExtra(DetailMovieActivity.EXTRA_MOVIE, data.id)
                .putExtra(DetailMovieActivity.EXTRA_TYPE, "MOVIE")
        )
    }

}