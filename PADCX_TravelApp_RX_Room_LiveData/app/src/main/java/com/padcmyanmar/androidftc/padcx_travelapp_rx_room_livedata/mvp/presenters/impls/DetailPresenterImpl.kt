package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.models.TourModel
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.models.TourModelImpl
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.presenters.DetailPresenter
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.views.DetailView

class DetailPresenterImpl : DetailPresenter, AppBasePresenterImpl<DetailView>() {


    var mTourModel : TourModel = TourModelImpl

    override fun onDetailsCountryUIReady(owner: LifecycleOwner, name: String) {
        mTourModel.getCountryByName(name).observe(owner, Observer {
            if(it != null) {
                mView?.displayCountryDetail(it)
            }
        })
    }

    override fun onDetailsTourUIReady(owner: LifecycleOwner, name: String) {
        mTourModel.getToursByName(name).observe(owner, Observer {
            if(it != null) {
                mView?.displayTourDetail(it)
            }
        })
    }

}