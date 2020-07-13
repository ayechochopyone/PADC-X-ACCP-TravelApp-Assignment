package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.presenters.impls

import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.presenters.AbstractBasePresenter
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.presenters.BasePresenter
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.views.BaseView

abstract class AppBasePresenterImpl<V: BaseView> : AbstractBasePresenter<V>(), BasePresenter<V>{
}