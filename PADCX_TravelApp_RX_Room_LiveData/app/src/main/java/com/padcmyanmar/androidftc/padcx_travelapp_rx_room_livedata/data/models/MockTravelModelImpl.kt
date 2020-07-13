package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.CountryAndTourVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.CountryVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.TourVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.dummy.getDummyCountry
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.dummy.getDummyTour
import io.reactivex.Observable

object MockTravelModelImpl : TourModel {
    override fun getAllCountriesAndTours(onError: (String) -> Unit): Observable<CountryAndTourVO> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllTours(onError: (String) -> Unit): LiveData<List<TourVO>> {
        val liveTourData = MutableLiveData<List<TourVO>>()
        liveTourData.postValue( getDummyTour())
        return liveTourData
    }

    override fun getToursByName(tourName: String): LiveData<TourVO> {
        val liveData = MutableLiveData<TourVO>()
        liveData.postValue(getDummyTour().first {
            it.name == tourName
        })
        return liveData
    }

    override fun getCountryByName(countryName: String): LiveData<CountryVO> {
        val liveData = MutableLiveData<CountryVO>()
        liveData.postValue(getDummyCountry()?.first{
            it.name == countryName
        })
        return liveData
    }

    override fun getAllCountries(onError: (String) -> Unit): LiveData<List<CountryVO>> {
        val liveCountryData = MutableLiveData<List<CountryVO>>()
        liveCountryData.postValue(getDummyCountry())
        return liveCountryData
    }

}