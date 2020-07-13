package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.fragments


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.R
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.adapters.CountryListAdapter
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.adapters.PopularTourListAdapter
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.models.TourModel
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.models.TourModelImpl
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.CountryVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.TourVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.delegates.TourItemDelegate
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.presenters.HomePresenter
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.presenters.impls.HomePresenterImpl
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.views.HomeView
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment(), HomeView{


    private lateinit var mCountryAdapter: CountryListAdapter
    private lateinit var mPopularTourAdapter: PopularTourListAdapter
    private lateinit var mPresenter : HomePresenter
    private lateinit var mTourModel : TourModelImpl
    private val compositeDisposable : CompositeDisposable = CompositeDisposable()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpPresenter()
        setUpRecyclerView()
        mPresenter.onUiReady(this)
    //     requestData()
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this)
            .get(HomePresenterImpl::class.java)

       mPresenter.initPresenter(this)
    }

    private fun setUpRecyclerView() {
        mCountryAdapter = CountryListAdapter(mPresenter)
        mPopularTourAdapter = PopularTourListAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        rvCountry.layoutManager = linearLayoutManager
        rvCountry.adapter = mCountryAdapter

        val linearLayoutManager1 = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        rvPopularTours.layoutManager = linearLayoutManager1
        rvPopularTours.adapter = mPopularTourAdapter
    }

    override fun displayCountriesList(countryList: List<CountryVO>) {
        mCountryAdapter.setNewData(countryList.toMutableList())
    }

    override fun displayToursList(toursList: List<TourVO>) {
        mPopularTourAdapter.setNewData(toursList.toMutableList())
    }

    override fun navigateToDetails(name: String) {
        fragmentManager?.beginTransaction()
            ?.replace(R.id.flBottomNavigationContainer,DetailFragment(name))
            ?.commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }


}
