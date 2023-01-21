package com.asimodabas.movie_detail_app.ui.activity.films

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.asimodabas.movie_detail_app.adapter.FilmsAdapter
import com.asimodabas.movie_detail_app.databinding.ActivityFilmsBinding
import com.asimodabas.movie_detail_app.db.dao.FilmsDAO
import com.asimodabas.movie_detail_app.db.helper.DatabaseHelper
import com.asimodabas.movie_detail_app.model.Categories
import com.asimodabas.movie_detail_app.model.Films

class FilmsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFilmsBinding
    private lateinit var filmList: ArrayList<Films>
    private lateinit var adapter: FilmsAdapter
    private lateinit var vt: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilmsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val kategori = intent.getSerializableExtra("kategoriNesne") as Categories

        binding.toolbarFilms.title = "Filmler : ${kategori.categoryName}"
        setSupportActionBar(binding.toolbarFilms)

        binding.filmsRv.setHasFixedSize(true)
        binding.filmsRv.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        vt = DatabaseHelper(this)
        filmList = FilmsDAO().allFilmlesByKategoryId(vt, kategori.categoryId)

        adapter = FilmsAdapter(this, filmList)
        binding.filmsRv.adapter = adapter
    }
}