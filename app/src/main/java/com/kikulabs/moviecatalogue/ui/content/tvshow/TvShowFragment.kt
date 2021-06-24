package com.kikulabs.moviecatalogue.ui.content.tvshow

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
import com.kikulabs.moviecatalogue.data.source.local.entity.MovieEntity
import com.kikulabs.moviecatalogue.databinding.FragmentTvShowBinding
import com.kikulabs.moviecatalogue.ui.content.movie.MovieAdapter
import com.kikulabs.moviecatalogue.ui.content.ContentCallback
import com.kikulabs.moviecatalogue.ui.content.ContentViewModel
import com.kikulabs.moviecatalogue.ui.detail.DetailMovieActivity
import com.kikulabs.moviecatalogue.utils.SortUtils.BEST_VOTE
import com.kikulabs.moviecatalogue.viewmodel.ViewModelFactory
import com.kikulabs.moviecatalogue.vo.Status

class TvShowFragment : Fragment(), ContentCallback {

    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(
                this,
                factory
            )[ContentViewModel::class.java]
            val tvShowAdapter = TvShowAdapter()

            viewModel.getTvShow(BEST_VOTE).observe(viewLifecycleOwner, { tvShow ->
                if (tvShow != null) {
                    when (tvShow.status) {
                        Status.LOADING -> showProgressBar(true)
                        Status.SUCCESS -> {
                            showProgressBar(false)
                            tvShowAdapter.submitList(tvShow.data)
                            tvShowAdapter.setOnItemClicked(this)
                        }
                        Status.ERROR -> {
                            showProgressBar(false)
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(fragmentTvShowBinding.rvTvShow) {
                layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }

    private fun showProgressBar(state: Boolean) {
        fragmentTvShowBinding.progressBar.isVisible = state
        fragmentTvShowBinding.rvTvShow.isInvisible = state
    }

    override fun onItemClicked(id: String) {
        startActivity(
            Intent(context, DetailMovieActivity::class.java)
                .putExtra(DetailMovieActivity.EXTRA_MOVIE, id)
                .putExtra(DetailMovieActivity.EXTRA_TYPE, "TV_SHOW")
        )
    }

}