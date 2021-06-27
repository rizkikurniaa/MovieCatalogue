package com.kikulabs.moviecatalogue.ui.home

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kikulabs.moviecatalogue.R
import com.kikulabs.moviecatalogue.databinding.ActivityHomeBinding
import com.kikulabs.moviecatalogue.ui.content.movie.MovieFragment
import com.kikulabs.moviecatalogue.ui.content.tvshow.TvShowFragment
import com.kikulabs.moviecatalogue.ui.favorite.FavoriteFragment

class HomeActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private lateinit var activityHomeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)

        initView(savedInstanceState)
    }

    private fun initView(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            loadFragment(MovieFragment())
        }
        // add listener when item/menu bottom navigation selected
        activityHomeBinding.bnMain.setOnNavigationItemSelectedListener(this)
    }

    // method to load fragment
    private fun loadFragment(fragment: Fragment?): Boolean {
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fl_container, fragment)
                .commit()
            return true
        }
        return false
    }

    // method listener for choosing fragment
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? = null
        when (item.itemId) {
            R.id.menu_movies -> fragment = MovieFragment()
            R.id.menu_tv_shows -> fragment = TvShowFragment()
            R.id.menu_favorite -> fragment = FavoriteFragment()
        }
        return loadFragment(fragment)
    }

    fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }
}