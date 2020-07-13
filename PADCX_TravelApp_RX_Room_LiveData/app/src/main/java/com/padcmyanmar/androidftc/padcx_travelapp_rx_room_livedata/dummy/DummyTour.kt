package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.dummy

import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.ScoresAndReviewsVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.TourVO

fun getDummyTour() : List<TourVO>{
    val tourOne = TourVO()
    tourOne.name = "Neo Hotel"
    tourOne.description = ""
    tourOne.location =""
    tourOne.averageRating = 0.0F
    tourOne.photos = arrayListOf()
    tourOne.scoresAndReviews = arrayListOf()

    val tourTwo = TourVO()
    tourTwo.name = "lbis Budget"
    tourTwo.description = ""
    tourTwo.location =""
    tourTwo.averageRating = 0.0F
    tourTwo.photos = arrayListOf()
    tourTwo.scoresAndReviews = arrayListOf()

    val tourThree = TourVO()
    tourThree.name = "Magical"
    tourThree.description = ""
    tourThree.location =""
    tourThree.averageRating = 0.0F
    tourThree.photos = arrayListOf()
    tourThree.scoresAndReviews = arrayListOf()

    val tourFour = TourVO()
    tourFour.name = "Neo Hotel"
    tourFour.description = ""
    tourFour.location =""
    tourFour.averageRating = 0.0F
    tourFour.photos = arrayListOf()
    tourFour.scoresAndReviews = arrayListOf()

    val tourFive = TourVO()
    tourFive.name = "Golf View"
    tourFive.description = ""
    tourFive.location =""
    tourFive.averageRating = 0.0F
    tourFive.photos = arrayListOf()
    tourFive.scoresAndReviews = arrayListOf()

    return arrayListOf(tourOne, tourTwo, tourThree, tourFour, tourFive)

}