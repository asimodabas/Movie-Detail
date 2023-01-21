package com.asimodabas.movie_detail_app.ui.activity.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.asimodabas.movie_detail_app.databinding.ActivityDetailBinding
import com.asimodabas.movie_detail_app.model.Films

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val film = intent.getSerializableExtra("filmNesne") as Films

        binding.tvFilmName.text = film.filmName
        binding.tvFilmYear.text = film.filmYear.toString()
        binding.tvFilmDirector.text = film.director.directorName

        binding.ivImage.setImageResource(
            resources.getIdentifier(
                film.filmImage, "drawable", packageName
            )
        )
    }
}