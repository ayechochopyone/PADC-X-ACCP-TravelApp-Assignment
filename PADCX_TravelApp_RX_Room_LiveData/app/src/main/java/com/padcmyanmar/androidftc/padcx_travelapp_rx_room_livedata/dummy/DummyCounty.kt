package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.dummy

import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.CountryVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.ScoresAndReviewsVO

fun getDummyCountry() : List<CountryVO> {
    val countryOne = CountryVO()
    countryOne.name = "Sea Flower Resort"
    countryOne.description = ""
    countryOne.location = ""
    countryOne.photos = arrayListOf()
    countryOne.averageRating = 0.0F
    countryOne.scoresAndReviews = arrayListOf<ScoresAndReviewsVO>()

    val countryTwo = CountryVO()
    countryTwo.name = "Pullman Pluket"
    countryTwo.description = ""
    countryTwo.location = ""
    countryTwo.photos = arrayListOf()
    countryTwo.averageRating = 0.0F
    countryTwo.scoresAndReviews = arrayListOf<ScoresAndReviewsVO>()

    val countryThree = CountryVO()
    countryThree.name = "Resort Krabi"
    countryThree.description = ""
    countryThree.location = ""
    countryThree.photos = arrayListOf()
    countryThree.averageRating = 0.0F
    countryThree.scoresAndReviews = arrayListOf<ScoresAndReviewsVO>()

    val countryFour = CountryVO()
    countryFour.name = "Collection "
    countryFour.description = ""
    countryFour.location = ""
    countryFour.photos = arrayListOf()
    countryFour.averageRating = 0.0F
    countryFour.scoresAndReviews = arrayListOf<ScoresAndReviewsVO>()

    val countryFive = CountryVO()
    countryFive.name = "Capital"
    countryFive.description = ""
    countryFive.location = ""
    countryFive.photos = arrayListOf()
    countryFive.averageRating = 0.0F
    countryFive.scoresAndReviews = arrayListOf<ScoresAndReviewsVO>()
    return arrayListOf(countryOne,countryTwo, countryThree, countryFour, countryFive)

}