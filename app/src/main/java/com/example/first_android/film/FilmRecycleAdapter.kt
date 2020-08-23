package com.example.first_android.film

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.first_android.R
import com.squareup.picasso.Picasso

class FilmRecycleAdapter(
    private val filmList: List<Film>,
    private val getActivity: FragmentActivity?) :
    RecyclerView.Adapter<FilmViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.film_list_item, parent, false)
        return FilmViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filmList.size
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        Picasso.with(getActivity).load(filmList[position].filmImageURL).into(holder.imageSong)
        val bundle = bundleOf(Pair("filmID", filmList[position].filmID))
        holder.itemView.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_filmFragment_to_filmDetailFragment, bundle)
        }
    }
}

class FilmViewHolder(v: View): RecyclerView.ViewHolder(v) {
    val imageSong: ImageView = v.findViewById<ImageView>(R.id.image_film)
}