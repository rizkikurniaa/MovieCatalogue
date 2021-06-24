package com.kikulabs.moviecatalogue.ui.content.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kikulabs.moviecatalogue.data.source.local.entity.MovieEntity
import com.kikulabs.moviecatalogue.databinding.FragmentMovieBinding
import com.kikulabs.moviecatalogue.ui.content.ContentCallback
import com.kikulabs.moviecatalogue.ui.content.ContentViewModel
import com.kikulabs.moviecatalogue.ui.detail.DetailMovieActivity
import com.kikulabs.moviecatalogue.utils.SortUtils.BEST_VOTE
import com.kikulabs.moviecatalogue.viewmodel.ViewModelFactory
import com.kikulabs.moviecatalogue.vo.Status

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
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(
                this,
                factory
            )[ContentViewModel::class.java]
            val movieAdapter = MovieAdapter()

            viewModel.getMovie(BEST_VOTE).observe(viewLifecycleOwner, { movies ->
                if (movies != null) {
                    when (movies.status) {
                        Status.LOADING -> showProgressBar(true)
                        Status.SUCCESS -> {
                            showProgressBar(false)
                            movieAdapter.submitList(movies.data)
                            movieAdapter.setOnItemClicked(this)
                        }
                        Status.ERROR -> {
                            showProgressBar(false)
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(fragmentMovieBinding.rvMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

    private fun showProgressBar(state: Boolean) {
        fragmentMovieBinding.progressBar.isVisible = state
        fragmentMovieBinding.rvMovie.isInvisible = state
    }

    override fun onItemClicked(id: String) {
        startActivity(
            Intent(context, DetailMovieActivity::class.java)
                .putExtra(DetailMovieActivity.EXTRA_MOVIE, id)
                .putExtra(DetailMovieActivity.EXTRA_TYPE, "MOVIE")
        )
    }

}