package com.kikulabs.moviecatalogue.ui.favorite.tvshow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kikulabs.moviecatalogue.databinding.FragmentFavoriteTvShowsBinding
import com.kikulabs.moviecatalogue.ui.content.ContentCallback
import com.kikulabs.moviecatalogue.ui.content.tvshow.TvShowAdapter
import com.kikulabs.moviecatalogue.ui.detail.DetailMovieActivity
import com.kikulabs.moviecatalogue.ui.favorite.FavoriteViewModel
import com.kikulabs.moviecatalogue.viewmodel.ViewModelFactory


class FavoriteTvShowsFragment : Fragment(), ContentCallback {
    private lateinit var fragmentFavoriteTvShowsBinding: FragmentFavoriteTvShowsBinding
    private lateinit var viewModel: FavoriteViewModel
    private lateinit var tvShowAdapter: TvShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentFavoriteTvShowsBinding =
            FragmentFavoriteTvShowsBinding.inflate(layoutInflater, container, false)
        return fragmentFavoriteTvShowsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

            tvShowAdapter = TvShowAdapter()

            viewModel.getFavTvShows().observe(viewLifecycleOwner, { favMovies ->
                if (favMovies != null) {
                    tvShowAdapter.submitList(favMovies)
                    tvShowAdapter.setOnItemClicked(this)
                }
            })

            with(fragmentFavoriteTvShowsBinding.rvFavoriteTvShows) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getFavTvShows().observe(viewLifecycleOwner, { favTvShow ->
            if (favTvShow != null) {
                tvShowAdapter.submitList(favTvShow)
            }
        })
    }

    override fun onItemClicked(id: String) {
        startActivity(
            Intent(context, DetailMovieActivity::class.java)
                .putExtra(DetailMovieActivity.EXTRA_MOVIE, id)
                .putExtra(DetailMovieActivity.EXTRA_TYPE, "TV_SHOW")
        )
    }
}