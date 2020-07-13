package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.uitests

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.R
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.activities.MainActivity
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.views.viewholder.CountryViewHolder
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.views.viewholder.PopularTourViewHolder
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class GoToTravelDetailTest {

    private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    open fun setUp(){
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun tapOnCountry_navigateToCountryDetail(){
        onView(withId(R.id.rvCountry))
            .perform(RecyclerViewActions.actionOnItemAtPosition<CountryViewHolder>(0,click()))

        onView(withId(R.id.tvDescription))
            .check(matches(isDisplayed()))
    }

    @Test
    fun tapOnTour_navigateToTourDetail(){
        onView(withId(R.id.rvPopularTours))
            .perform(RecyclerViewActions.actionOnItemAtPosition<PopularTourViewHolder>(0,click()))

        onView(withId(R.id.tvDescription))
            .check(matches(isDisplayed()))
    }


}