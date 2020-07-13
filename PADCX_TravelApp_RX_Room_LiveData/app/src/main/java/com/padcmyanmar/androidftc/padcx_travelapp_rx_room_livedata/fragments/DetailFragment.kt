package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.R
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.adapters.DetailListAdapter
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.models.TourModel
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.models.TourModelImpl
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.CountryVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.TourVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.presenters.DetailPresenter
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.presenters.impls.DetailPresenterImpl
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.views.DetailView
import kotlinx.android.synthetic.main.content_collapsing_toolbar.*

import kotlinx.android.synthetic.main.content_detail.*
import kotlinx.android.synthetic.main.fragment_detail.*

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment(val name:String) : Fragment(), DetailView {

    private lateinit var mAdapter : DetailListAdapter
    private lateinit var mPresenter : DetailPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpPresenter()

        mPresenter.onDetailsCountryUIReady(this, name)
        mPresenter.onDetailsTourUIReady(this, name)
        ivBack.setOnClickListener {
            fragmentManager?.beginTransaction()
                ?.replace(R.id.flBottomNavigationContainer,HomeFragment())
                ?.commit()
        }
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this)
            .get(DetailPresenterImpl::class.java)

        mPresenter.initPresenter(this)
    }
    private fun setUpRecyclerView(photos:ArrayList<String>) {
        mAdapter = DetailListAdapter(context)
        val linearLayoutManager = LinearLayoutManager(this.context,LinearLayoutManager.HORIZONTAL,false)
        rvImages.layoutManager = linearLayoutManager
        rvImages.adapter = mAdapter
        mAdapter.setTourImage(photos)
    }

    private fun setTourData(tour:TourVO) {

        Glide.with(this)
            .load(tour.photos[0])
            .into(this.ivCollapsingToolbar)
        collapsingToolbarLayout.title = tour.name
        tvLocation.text = tour.location
        tvRating.text = tour.averageRating.toString()
        ratingBar.rating = tour.averageRating
        tvReviewsBooking.text = "Based on ${tour.scoresAndReviews[0].totalReviews} reviews"
        tvRatingBooking.text = "${tour.scoresAndReviews[0].score}/${tour.scoresAndReviews[0].maxScore}"
        tvRatingHotelOut.text = "${tour.scoresAndReviews[1].score}/${tour.scoresAndReviews[1].maxScore}"
        tvReviewsHotelOut.text = "Based on ${tour.scoresAndReviews[1].totalReviews} reviews"
        tvDescription.text = tour.description
        setUpRecyclerView(tour.photos)
    }
    private fun setCountryData(tour:CountryVO) {

        Glide.with(this)
            .load(tour.photos[0])
            .into(this.ivCollapsingToolbar)
        collapsingToolbarLayout.title = tour.name
        tvLocation.text = tour.location
        tvRating.text = tour.averageRating.toString()
        ratingBar.rating = tour.averageRating
        tvReviewsBooking.text = "Based on ${tour.scoresAndReviews[0].totalReviews} reviews"
        tvRatingBooking.text = "${tour.scoresAndReviews[0].score}/${tour.scoresAndReviews[0].maxScore}"
        tvRatingHotelOut.text = "${tour.scoresAndReviews[1].score}/${tour.scoresAndReviews[1].maxScore}"
        tvReviewsHotelOut.text = "Based on ${tour.scoresAndReviews[1].totalReviews} reviews"
        tvDescription.text = tour.description
        setUpRecyclerView(tour.photos)
    }
    override fun displayCountryDetail(country: CountryVO) {
        setCountryData(country)
    }

    override fun displayTourDetail(tour: TourVO) {
        setTourData(tour)
    }

}
