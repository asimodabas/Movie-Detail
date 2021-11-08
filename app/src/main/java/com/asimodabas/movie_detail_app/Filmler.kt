package com.asimodabas.movie_detail_app

import java.io.Serializable

data class Filmler(
    var film_id: Int,
    var film_ad: String,
    var film_yil: Int,
    var film_resim: String,
    var kategor: Kategoriler,
    var yonetmen: Yonetmenler) :Serializable {



}