package com.asimodabas.movie_detail_app.model

import java.io.Serializable

data class Films(
    var filmId: Int,
    var filmName: String,
    var filmYear: Int,
    var filmImage: String,
    var category: Categories,
    var director: Directors
) :Serializable {



}