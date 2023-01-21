package com.asimodabas.movie_detail_app.ui.activity.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.asimodabas.movie_detail_app.adapter.CategoryAdapter
import com.asimodabas.movie_detail_app.databinding.ActivityMainBinding
import com.asimodabas.movie_detail_app.db.dao.CategoriesDAO
import com.asimodabas.movie_detail_app.db.helper.DatabaseCopyHelper
import com.asimodabas.movie_detail_app.db.helper.DatabaseHelper
import com.asimodabas.movie_detail_app.model.Categories

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var kategoriList: ArrayList<Categories>
    private lateinit var adapter: CategoryAdapter
    private lateinit var vt: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        veritabaniKopyala()

        binding.toolbarCategory.title = "Kategoriler"
        setSupportActionBar(binding.toolbarCategory)

        binding.categoryRv.setHasFixedSize(true)
        binding.categoryRv.layoutManager = LinearLayoutManager(this)

        vt = DatabaseHelper(this)
        kategoriList = CategoriesDAO().allCategories(vt)
        adapter = CategoryAdapter(this, kategoriList)

        binding.categoryRv.adapter = adapter
    }

    fun veritabaniKopyala() {
        val copyHelper = DatabaseCopyHelper(this)

        try {
            copyHelper.createDataBase()
            copyHelper.openDataBase()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}