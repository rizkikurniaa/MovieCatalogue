package com.kikulabs.moviecatalogue.ui.content.tvshow

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kikulabs.moviecatalogue.R
import com.kikulabs.moviecatalogue.databinding.FragmentTvShowBinding
import com.kikulabs.moviecatalogue.ui.content.ContentCallback
import com.kikulabs.moviecatalogue.ui.content.ContentViewModel
import com.kikulabs.moviecatalogue.ui.detail.DetailMovieActivity
import com.kikulabs.moviecatalogue.ui.home.HomeActivity
import com.kikulabs.moviecatalogue.utils.SortUtils
import com.kikulabs.moviecatalogue.utils.SortUtils.BEST_RATE
import com.kikulabs.moviecatalogue.viewmodel.ViewModelFactory
import com.kikulabs.moviecatalogue.vo.Status

class TvShowFragment : Fragment(), ContentCallback {

    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding
    private lateinit var viewModel: ContentViewModel
    private lateinit var tvShowAdapter: TvShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            (activity as HomeActivity).supportActionBar?.show()
            (activity as HomeActivity).setActionBarTitle("Discover TV Shows")
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(
                this,
                factory
            )[ContentViewModel::class.java]

            tvShowAdapter = TvShowAdapter()

            viewModel.getTvShow(BEST_RATE).observe(viewLifecycleOwner, { tvShow ->
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
                layoutManager = LinearLayoutManager(context)
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        activity?.menuInflater?.inflate(R.menu.sort_menu, menu)
        return super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var sort = ""
        when (item.itemId) {
            R.id.action_sort_best -> sort = BEST_RATE
            R.id.action_sort_worst -> sort = SortUtils.WORST_RATE
            R.id.action_sort_random -> sort = SortUtils.RANDOM
        }

        viewModel.getTvShow(sort).observe(viewLifecycleOwner, { tvShows ->
            if (tvShows != null) {
                when (tvShows.status) {
                    Status.LOADING -> showProgressBar(true)
                    Status.SUCCESS -> {
                        showProgressBar(false)
                        tvShowAdapter.submitList(tvShows.data)
                        tvShowAdapter.setOnItemClicked(this)
                    }
                    Status.ERROR -> {
                        showProgressBar(false)
                        Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

        item.isChecked = true

        return super.onOptionsItemSelected(item)
    }

}