package com.kikulabs.moviecatalogue.ui.content.tvshow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.kikulabs.moviecatalogue.data.source.local.entity.DataEntity
import com.kikulabs.moviecatalogue.databinding.FragmentTvShowBinding
import com.kikulabs.moviecatalogue.ui.content.ContentAdapter
import com.kikulabs.moviecatalogue.ui.content.ContentCallback
import com.kikulabs.moviecatalogue.ui.content.ContentViewModel
import com.kikulabs.moviecatalogue.ui.detail.DetailMovieActivity
import com.kikulabs.moviecatalogue.viewmodel.ViewModelFactory

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
            val tvShowAdapter =
                ContentAdapter(this@TvShowFragment)

            viewModel.getTvShow().observe(viewLifecycleOwner, { tvShow ->
                showProgressBar(false)
                tvShowAdapter.setMovies(tvShow)
                tvShowAdapter.notifyDataSetChanged()
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

    override fun onItemClicked(data: DataEntity) {
        startActivity(
            Intent(context, DetailMovieActivity::class.java)
                .putExtra(DetailMovieActivity.EXTRA_MOVIE, data.id)
                .putExtra(DetailMovieActivity.EXTRA_TYPE, "TV_SHOW")
        )
    }

}