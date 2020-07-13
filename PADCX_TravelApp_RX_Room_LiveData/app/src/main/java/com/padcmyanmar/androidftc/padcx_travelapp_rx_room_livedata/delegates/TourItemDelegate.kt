package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.delegates

import android.widget.ImageView
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.CountryVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.TourVO

interface TourItemDelegate {
   // fun onTapCountryItem(country : CountryVO, imageView: ImageView)
    fun onTapTourItem(name : String)
}