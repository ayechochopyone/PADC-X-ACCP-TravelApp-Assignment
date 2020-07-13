package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.instrumentationtests

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.TourVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.persistence.daos.TourDao
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.persistence.db.TourDB
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DatabaseTourTest {

    private lateinit var tourDao : TourDao
    private lateinit var db : TourDB

    @Before
    fun createDb(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, TourDB::class.java
        ).build()

        tourDao = db.tourDao()
    }

    @After
    fun closeDb(){
        db.close()
    }

    @Test
    fun insertIntoDatabase(){
        val tourOne = TourVO()
        tourOne.name = "Neo Hotel"
        tourOne.description = ""
        tourOne.location =""
        tourOne.averageRating = 0.0F
        tourOne.photos = arrayListOf()
        tourOne.scoresAndReviews = arrayListOf()

        tourDao.insert(tourOne)
        assert(tourDao.getTourByName(tourOne.name).value?.name == tourOne.name)
    }
}