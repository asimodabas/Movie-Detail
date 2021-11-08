package com.asimodabas.movie_detail_app

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class FilmlerAdapter(private val mContext: Context, private val filmlerListe: List<Filmler>) :
    RecyclerView.Adapter<FilmlerAdapter.CardTasarimTutucu>() {


    inner class CardTasarimTutucu(tasarim: View) : RecyclerView.ViewHolder(tasarim) {

        var film_card: CardView
        var textViewFilmAd: TextView
        var imageViewFilmResim: ImageView

        init {
            film_card = tasarim.findViewById(R.id.film_card)
            textViewFilmAd = tasarim.findViewById(R.id.textViewFilmAd)
            imageViewFilmResim = tasarim.findViewById(R.id.imageViewFilmResim)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim =
            LayoutInflater.from(mContext).inflate(R.layout.film_card_tasarim, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {

        val film = filmlerListe.get(position)
        holder.textViewFilmAd.text = film.film_ad

        holder.imageViewFilmResim.setImageResource(mContext.resources.getIdentifier(film.film_resim, "drawable", mContext.packageName))

        holder.film_card.setOnClickListener {
            val intent = Intent(mContext, DetayActivity::class.java)
            intent.putExtra("filmNesne", film)
            mContext.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {
        return filmlerListe.size
    }


}