package com.asimodabas.movie_detail_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detay.*

class DetayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        val film = intent.getSerializableExtra("filmNesne") as Filmler

        textViewFilmAdi.text = film.film_ad
        textViewFilmYili.text = film.film_yil.toString()
        textViewFilmYonetmeni.text = film.yonetmen.yonetmen_ad

        imageViewResim.setImageResource(resources.getIdentifier(film.film_resim, "drawable",packageName))



    }
}