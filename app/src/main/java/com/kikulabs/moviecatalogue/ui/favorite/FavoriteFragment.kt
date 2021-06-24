package com.kikulabs.moviecatalogue.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.kikulabs.moviecatalogue.R
import com.kikulabs.moviecatalogue.databinding.FragmentFavoriteBinding
import com.kikulabs.moviecatalogue.databinding.FragmentFavoriteMoviesBinding
import com.kikulabs.moviecatalogue.ui.home.SectionsPagerAdapter

class FavoriteFragment : Fragment() {

    private lateinit var favoriteBinding: FragmentFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        favoriteBinding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return favoriteBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sectionsPagerAdapter = SectionsPagerAdapter(requireContext(), (activity as FragmentActivity).supportFragmentManager)
        favoriteBinding.viewPager.adapter = sectionsPagerAdapter
        favoriteBinding.tabs.setupWithViewPager(favoriteBinding.viewPager)
    }

}