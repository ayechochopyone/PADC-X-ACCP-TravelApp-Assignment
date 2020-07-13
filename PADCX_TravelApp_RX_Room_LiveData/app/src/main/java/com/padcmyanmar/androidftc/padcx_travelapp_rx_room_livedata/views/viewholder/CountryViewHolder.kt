package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.views.viewholder

import android.view.View
import com.bumptech.glide.Glide
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.CountryVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.TourVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.delegates.TourItemDelegate
import kotlinx.android.synthetic.main.country_list_item.view.*
import kotlinx.android.synthetic.main.country_list_item.view.tvRating

class CountryViewHolder(itemView:View,private val delegate: TourItemDelegate):
    BaseCountryViewHolder(itemView){
    override fun bindData(data: CountryVO) {
        Glide.with(itemView.context)
            .load(data.photos[0])
            .into(itemView.ivBackground)
//        itemView.tvCountryName.text = data.location
        itemView.tvRating.text = data.averageRating.toString()
        mData = data
    }

    override fun bindImage(image: String) {

    }

    init {
        itemView.setOnClickListener{mData?.let {
            delegate.onTapTourItem(mData!!.name)
        }}
//        itemView.ivBack.setOnClickListener {
//            delegate.onTapBack()
//        }
    }
}