package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.activities

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.presenters.AbstractBasePresenter
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.views.BaseView

abstract class BaseActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }
    fun showSnackbar(message : String) {
        Snackbar
            .make(window.decorView,message, Snackbar.LENGTH_LONG).show()
    }

//    inline fun <reified T : AbstractBasePresenter<W>, reified W: BaseView> getPresenter(): T {
//        val presenter = ViewModelProviders.of(this).get(T::class.java)
//        if (this is W) presenter.initPresenter(this)
//        return presenter
//    }
}