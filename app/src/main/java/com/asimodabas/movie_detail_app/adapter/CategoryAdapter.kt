package com.asimodabas.movie_detail_app.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.asimodabas.movie_detail_app.R
import com.asimodabas.movie_detail_app.model.Categories
import com.asimodabas.movie_detail_app.ui.activity.films.FilmsActivity

class CategoryAdapter(private val mContext: Context, private val kategoriListe: List<Categories>) :
    RecyclerView.Adapter<CategoryAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(tasarim: View) : RecyclerView.ViewHolder(tasarim) {
        var categoryCard: CardView
        var tvCategoryName: TextView

        init {
            categoryCard = tasarim.findViewById(R.id.categoryCard)
            tvCategoryName = tasarim.findViewById(R.id.tvCategoryName)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val categoryLayout =
            LayoutInflater.from(mContext).inflate(R.layout.categories_card_layout, parent, false)
        return CardTasarimTutucu(categoryLayout)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val categoryList = kategoriListe[position]

        holder.tvCategoryName.text = categoryList.categoryName
        holder.categoryCard.setOnClickListener {

            val intent = Intent(mContext, FilmsActivity::class.java)
            intent.putExtra("kategoriNesne", categoryList)
            mContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return kategoriListe.size
    }
}