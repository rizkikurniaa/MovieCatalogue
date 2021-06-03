package com.kikulabs.moviecatalogue.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.kikulabs.moviecatalogue.R
import com.kikulabs.moviecatalogue.utils.DataDummy
import com.kikulabs.moviecatalogue.utils.EspressoIdlingResource
import org.hamcrest.CoreMatchers.not
import org.junit.After
import org.junit.Before
import org.junit.Test

class HomeActivityTest {
    private val dummyMovies = DataDummy.getMovies()
    private val dummyTvShows = DataDummy.getTvShows()

    @Before
    fun setup() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovies.size
            )
        )
    }

    @Test
    fun loadDetailMovies() {
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(not(withText(""))))
        onView(withId(R.id.cv_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release_date)).check(matches(not(withText(""))))
        onView(withId(R.id.tv_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rating)).check(matches(not(withText(""))))
        onView(withId(R.id.tv_language)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_language)).check(matches(not(withText(""))))
        onView(withId(R.id.tv_overview_value)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview_value)).check(matches(not(withText(""))))
    }

    @Test
    fun loadTvShows() {
        onView(withText("Tv Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTvShows.size
            )
        )
    }

    @Test
    fun loadDetailTvShows() {
        onView(withText("Tv Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                1,
                click()
            )
        )
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(not(withText(""))))
        onView(withId(R.id.cv_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release_date)).check(matches(not(withText(""))))
        onView(withId(R.id.tv_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rating)).check(matches(not(withText(""))))
        onView(withId(R.id.tv_language)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_language)).check(matches(not(withText(""))))
        onView(withId(R.id.tv_overview_value)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview_value)).check(matches(not(withText(""))))
    }
}