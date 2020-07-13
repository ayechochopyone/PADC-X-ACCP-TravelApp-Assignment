package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.instrumentationtests

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.CountryVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.ScoresAndReviewsVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.persistence.daos.CountryDao
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.persistence.db.TourDB
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DatabaseCountryTest {
    private lateinit var countryDao : CountryDao
    private lateinit var db : TourDB

    @Before
    fun createDb(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, TourDB::class.java
        ).build()

        countryDao = db.countryDao()
    }

    @After
    fun closeDb(){
        db.close()
    }

    @Test
    fun insertIntoDatabase(){
        val countryOne = CountryVO()
        countryOne.name = "Sea Flower Resort"
        countryOne.description = ""
        countryOne.location = ""
        countryOne.photos = arrayListOf()
        countryOne.averageRating = 0.0F
        countryOne.scoresAndReviews = arrayListOf<ScoresAndReviewsVO>()

        countryDao.insert(countryOne)
        assert(countryDao.getCountryByName(countryOne.name).value?.name == countryOne.name)
    }
}