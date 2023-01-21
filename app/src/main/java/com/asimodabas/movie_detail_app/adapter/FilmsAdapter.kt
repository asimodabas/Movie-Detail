package com.asimodabas.movie_detail_app.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.asimodabas.movie_detail_app.ui.activity.detail.DetailActivity
import com.asimodabas.movie_detail_app.R
import com.asimodabas.movie_detail_app.model.Films

class FilmsAdapter(private val mContext: Context, private val filmlerListe: List<Films>) :
    RecyclerView.Adapter<FilmsAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(tasarim: View) : RecyclerView.ViewHolder(tasarim) {

        var film_card: CardView
        var tvFilmName: TextView
        var ivFilmImage: ImageView

        init {
            film_card = tasarim.findViewById(R.id.filmCardView)
            tvFilmName = tasarim.findViewById(R.id.tvFilmNameCard)
            ivFilmImage = tasarim.findViewById(R.id.ivFilmImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val categoryFilmLayout =
            LayoutInflater.from(mContext).inflate(R.layout.film_card_layout, parent, false)
        return CardTasarimTutucu(categoryFilmLayout)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val film = filmlerListe.get(position)

        holder.tvFilmName.text = film.filmName
        holder.ivFilmImage.setImageResource(
            mContext.resources.getIdentifier(
                film.filmImage, "drawable", mContext.packageName
            )
        )

        holder.film_card.setOnClickListener {
            val intent = Intent(mContext, DetailActivity::class.java)
            intent.putExtra("filmNesne", film)
            mContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return filmlerListe.size
    }
}