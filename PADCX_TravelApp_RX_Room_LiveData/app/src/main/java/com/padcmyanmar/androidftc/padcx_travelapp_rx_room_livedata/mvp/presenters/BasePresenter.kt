package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.views.BaseView

interface BasePresenter <V: BaseView>{
    fun initPresenter(view: V)
}