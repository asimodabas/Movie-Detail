package com.asimodabas.movie_detail_app.db.dao

import android.annotation.SuppressLint
import com.asimodabas.movie_detail_app.db.helper.DatabaseHelper
import com.asimodabas.movie_detail_app.model.Categories

class CategoriesDAO {
    @SuppressLint("Range")
    fun allCategories(vt: DatabaseHelper): ArrayList<Categories> {
        val db = vt.writableDatabase
        val categoryList = ArrayList<Categories>()
        val c = db.rawQuery("SELECT * FROM kategoriler", null)

        while (c.moveToNext()) {

            val categories = Categories(
                c.getInt(c.getColumnIndex("kategori_id")),
                c.getString(c.getColumnIndex("kategori_ad"))
            )
            categoryList.add(categories)
        }
        return categoryList
    }
}