package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.views

import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.CountryVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.TourVO

interface DetailView : BaseView {
    fun displayCountryDetail (country : CountryVO )
    fun displayTourDetail (tour : TourVO)
}