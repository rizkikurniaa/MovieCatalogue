package com.kikulabs.moviecatalogue.ui.favorite.movie

import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kikulabs.moviecatalogue.R
import com.kikulabs.moviecatalogue.databinding.FragmentFavoriteMoviesBinding
import com.kikulabs.moviecatalogue.databinding.FragmentMovieBinding
import com.kikulabs.moviecatalogue.ui.content.ContentCallback
import com.kikulabs.moviecatalogue.ui.content.movie.MovieAdapter
import com.kikulabs.moviecatalogue.ui.detail.DetailMovieActivity
import com.kikulabs.moviecatalogue.viewmodel.ViewModelFactory

class FavoriteMoviesFragment : Fragment(), ContentCallback {
    private lateinit var fragmentFavoriteMoviesBinding: FragmentFavoriteMoviesBinding
    private lateinit var viewModel: FavoriteMovieViewModel
    private lateinit var adapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentFavoriteMoviesBinding = FragmentFavoriteMoviesBinding.inflate(layoutInflater, container, false)
        return fragmentFavoriteMoviesBinding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getFavMovies().observe(viewLifecycleOwner, { favMovies ->
            if (favMovies != null) {
                adapter.submitList(favMovies)
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteMovieViewModel::class.java]

            adapter = MovieAdapter()
            adapter.setOnItemClicked(this)

            viewModel.getFavMovies().observe(viewLifecycleOwner, { favMovies ->
                if (favMovies != null) {
                    adapter.submitList(favMovies)
                }
            })

            with(fragmentFavoriteMoviesBinding.rvFavoriteMovies) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = adapter
            }
        }
    }

    override fun onItemClicked(id: String) {
        startActivity(
            Intent(context, DetailMovieActivity::class.java)
                .putExtra(DetailMovieActivity.EXTRA_MOVIE, id)
                .putExtra(DetailMovieActivity.EXTRA_TYPE, "MOVIE")
        )
    }

}