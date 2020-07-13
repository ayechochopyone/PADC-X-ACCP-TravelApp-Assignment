package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.views.DetailView

interface DetailPresenter : BasePresenter<DetailView>{
    fun onDetailsCountryUIReady (owner : LifecycleOwner, name : String)
    fun onDetailsTourUIReady (owner: LifecycleOwner, name : String)

}