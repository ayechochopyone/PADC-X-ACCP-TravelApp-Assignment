package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.presenter.impl

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.models.MockTravelModelImpl
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.models.TourModel
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.models.TourModelImpl
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.CountryVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.dummy.getDummyCountry
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.dummy.getDummyTour
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.presenters.impls.HomePresenterImpl
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.views.HomeView
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class HomePresenterImplTest{
    private lateinit var mPresenter : HomePresenterImpl

    @RelaxedMockK
    private lateinit var mView : HomeView
    private lateinit var mTourModel : TourModel

    @Before
    fun setUpPresenter(){
        MockKAnnotations.init(this)
        TourModelImpl.init(ApplicationProvider.getApplicationContext())
        mTourModel = MockTravelModelImpl

        mPresenter = HomePresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mTourModel = this.mTourModel
    }

    @Test
    fun onUIReady_CallDisplayCountrylList(){
        val lifecycleOwner = mock(LifecycleOwner::class.java)
        val lifecycleRegistry = LifecycleRegistry(lifecycleOwner)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        `when`(lifecycleOwner.lifecycle).thenReturn(lifecycleRegistry)

        mPresenter.onUiReady(lifecycleOwner)

        verify {
            mView.displayCountriesList(getDummyCountry())
        }
    }

    @Test
    fun onUIReady_CallDisplayTourlList(){
        val lifecycleOwner = mock(LifecycleOwner::class.java)
        val lifecycleRegistry = LifecycleRegistry(lifecycleOwner)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        `when`(lifecycleOwner.lifecycle).thenReturn(lifecycleRegistry)

        mPresenter.onUiReady(lifecycleOwner)

        verify {
            mView.displayToursList(getDummyTour())
        }
    }
}