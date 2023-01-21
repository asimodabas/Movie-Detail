package com.asimodabas.movie_detail_app.db.dao

import android.annotation.SuppressLint
import com.asimodabas.movie_detail_app.db.helper.DatabaseHelper
import com.asimodabas.movie_detail_app.model.Categories
import com.asimodabas.movie_detail_app.model.Directors
import com.asimodabas.movie_detail_app.model.Films

class FilmsDAO {
    @SuppressLint("Range")
    fun allFilmlesByKategoryId(vt: DatabaseHelper, kategori_id: Int): ArrayList<Films> {
        val db = vt.writableDatabase
        val filmlerListe = ArrayList<Films>()
        val c = db.rawQuery(
            "SELECT * FROM kategoriler,yonetmenler,filmler WHERE filmler.kategori_id=kategoriler.kategori_id and filmler.yonetmen_id =yonetmenler.yonetmen_id and filmler.kategori_id=$kategori_id",
            null
        )

        while (c.moveToNext()) {
            val category = Categories(
                c.getInt(c.getColumnIndex("kategori_id")),
                c.getString(c.getColumnIndex("kategori_ad"))
            )

            val director = Directors(
                c.getInt(c.getColumnIndex("yonetmen_id")),
                c.getString(c.getColumnIndex("yonetmen_ad"))
            )

            val film = Films(
                c.getInt(c.getColumnIndex("film_id")),
                c.getString(c.getColumnIndex("film_ad")),
                c.getInt(c.getColumnIndex("film_yil")),
                c.getString(c.getColumnIndex("film_resim")),
                category,
                director
            )

            filmlerListe.add(film)
        }
        return filmlerListe
    }
}