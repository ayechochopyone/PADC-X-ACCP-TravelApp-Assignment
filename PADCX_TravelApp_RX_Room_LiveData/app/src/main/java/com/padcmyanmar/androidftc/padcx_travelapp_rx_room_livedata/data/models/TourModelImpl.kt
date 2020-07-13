package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.models

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.CountryAndTourVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.CountryVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.TourVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.persistence.db.TourDB
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.utils.EM_NO_INTERNET_CONNECTION
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.BiFunction
import io.reactivex.rxkotlin.toObservable
import io.reactivex.schedulers.Schedulers

object TourModelImpl: BaseModel(),TourModel {

  //  private val mTheDB:TourDB = TourDB.getDBInstance()
    override fun getAllTours(onError: (String) -> Unit): LiveData<List<TourVO>> {
        return Transformations.distinctUntilChanged(
            mTheDB.tourDao().getAllTour())

    }

    override fun getToursByName(tourName: String): LiveData<TourVO> {
        return Transformations.distinctUntilChanged(
            mTheDB.tourDao().getTourByName(tourName))
    }

    override fun getCountryByName(countryName: String): LiveData<CountryVO> {
        return Transformations.distinctUntilChanged(
            mTheDB.countryDao().getCountryByName(countryName))
    }

    override fun getAllCountries(onError: (String) -> Unit): LiveData<List<CountryVO>> {
        return Transformations.distinctUntilChanged(
            mTheDB.countryDao().getAllCountry())
    }

    override fun getAllCountriesAndTours(onError: (String) -> Unit): Observable<CountryAndTourVO> {


        val countryObservable = mTourApi.getAllCountries().map {
            it.data?.toList()
        }
        val tourObservable = mTourApi.getAllTours().map {
            it.data?.toList()
        }
        val countryAndTourObservable =  Observable.zip<List<CountryVO>,List<TourVO>,CountryAndTourVO>(
            countryObservable,
            tourObservable,
            BiFunction{
                countries,tours ->
                // save to persistence database
                mTheDB.countryDao().insertAllCountry(countries)
                mTheDB.tourDao().insertAllTour(tours)

                val countryAndTour = CountryAndTourVO(
                countries = countries,
                    tours = tours
            )
                return@BiFunction countryAndTour
            }
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
        return countryAndTourObservable

    }

    @SuppressLint("CheckResult")
    private fun getAllTourFromApiAndSaveToDatabase(onError:(String)->Unit) {
        mTourApi
            .getAllTours()
            .map { it.data?.toList()?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.tourDao().insertAllTour(it)
            },{
                onError(it.localizedMessage?: EM_NO_INTERNET_CONNECTION)
            })
    }

    @SuppressLint("CheckResult")
    private fun getAllCountryFromApiAndSaveToDatabase(onError: (String) -> Unit) {
        mTourApi
            .getAllCountries()
            .map { it.data?.toList()?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.countryDao().insertAllCountry(it)
            },{
                onError(it.localizedMessage?: EM_NO_INTERNET_CONNECTION)
            })
    }
}