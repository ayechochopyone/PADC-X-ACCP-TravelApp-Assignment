package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.models.TourModel
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.models.TourModelImpl
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.presenters.HomePresenter
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.views.HomeView

class HomePresenterImpl : HomePresenter , AppBasePresenterImpl<HomeView>(){
    override fun onTapTourItem(name: String) {
        mView?.navigateToDetails(name)
    }

    var mTourModel : TourModel = TourModelImpl
    override fun onUiReady(owner: LifecycleOwner) {
        mTourModel.getAllTours(onError = {}).observe(owner, Observer {
            mView?.displayToursList(it)
        })
        mTourModel.getAllCountries(onError = {}).observe(owner, Observer {
            mView?.displayCountriesList(it)
        })
    }


}