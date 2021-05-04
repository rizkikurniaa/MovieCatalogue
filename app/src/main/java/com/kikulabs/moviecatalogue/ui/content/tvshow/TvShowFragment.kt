package com.kikulabs.moviecatalogue.ui.content.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.kikulabs.moviecatalogue.R
import com.kikulabs.moviecatalogue.databinding.FragmentMovieBinding
import com.kikulabs.moviecatalogue.databinding.FragmentTvShowBinding
import com.kikulabs.moviecatalogue.ui.content.ContentAdapter
import com.kikulabs.moviecatalogue.ui.content.ContentViewModel

class TvShowFragment : Fragment() {

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
                ContentAdapter()
            movieAdapter.setMovies(movies)

            with(fragmentTvShowBinding.rvTvShow) {
                layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

}