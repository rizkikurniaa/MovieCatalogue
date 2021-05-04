package com.kikulabs.moviecatalogue.ui.content.tvshow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.kikulabs.moviecatalogue.data.DataEntity
import com.kikulabs.moviecatalogue.databinding.FragmentTvShowBinding
import com.kikulabs.moviecatalogue.ui.content.ContentAdapter
import com.kikulabs.moviecatalogue.ui.content.ContentCallback
import com.kikulabs.moviecatalogue.ui.content.ContentViewModel
import com.kikulabs.moviecatalogue.ui.detail.DetailMovieActivity

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

            val viewModel = ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            )[ContentViewModel::class.java]
            val movies = viewModel.getTvShow()

            val movieAdapter =
                ContentAdapter(this@TvShowFragment)
            movieAdapter.setMovies(movies)

            with(fragmentTvShowBinding.rvTvShow) {
                layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

    override fun onItemClicked(data: DataEntity) {
        startActivity(
            Intent(context, DetailMovieActivity::class.java)
                .putExtra(DetailMovieActivity.EXTRA_MOVIE, data.id)
                .putExtra(DetailMovieActivity.EXTRA_TYPE, "TV_SHOW")
        )
    }

}