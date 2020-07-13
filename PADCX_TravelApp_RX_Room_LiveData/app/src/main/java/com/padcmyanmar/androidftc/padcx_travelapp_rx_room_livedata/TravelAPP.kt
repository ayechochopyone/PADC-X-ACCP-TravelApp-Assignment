package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata

import android.app.Application
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.models.TourModelImpl
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.CountryVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.persistence.db.TourDB

class TravelAPP : Application() {
    override fun onCreate() {
        super.onCreate()
        TourModelImpl.init(applicationContext)
    }
}