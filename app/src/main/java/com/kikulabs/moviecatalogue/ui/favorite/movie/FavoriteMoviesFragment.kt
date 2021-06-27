package com.kikulabs.moviecatalogue.ui.favorite.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kikulabs.moviecatalogue.databinding.FragmentFavoriteMoviesBinding
import com.kikulabs.moviecatalogue.ui.content.ContentCallback
import com.kikulabs.moviecatalogue.ui.content.movie.MovieAdapter
import com.kikulabs.moviecatalogue.ui.detail.DetailMovieActivity
import com.kikulabs.moviecatalogue.ui.favorite.FavoriteViewModel
import com.kikulabs.moviecatalogue.viewmodel.ViewModelFactory

class FavoriteMoviesFragment : Fragment(), ContentCallback {
    private lateinit var fragmentFavoriteMoviesBinding: FragmentFavoriteMoviesBinding
    private lateinit var viewModel: FavoriteViewModel
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentFavoriteMoviesBinding =
            FragmentFavoriteMoviesBinding.inflate(layoutInflater, container, false)
        return fragmentFavoriteMoviesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

            movieAdapter = MovieAdapter()

            viewModel.getFavMovies().observe(viewLifecycleOwner, { favMovies ->
                if (favMovies != null) {
                    movieAdapter.submitList(favMovies)
                    movieAdapter.setOnItemClicked(this)
                }
            })

            with(fragmentFavoriteMoviesBinding.rvFavoriteMovies) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getFavMovies().observe(viewLifecycleOwner, { favMovies ->
            if (favMovies != null) {
                movieAdapter.submitList(favMovies)
            }
        })
    }

    override fun onItemClicked(id: String) {
        startActivity(
            Intent(context, DetailMovieActivity::class.java)
                .putExtra(DetailMovieActivity.EXTRA_MOVIE, id)
                .putExtra(DetailMovieActivity.EXTRA_TYPE, "MOVIE")
        )
    }

}