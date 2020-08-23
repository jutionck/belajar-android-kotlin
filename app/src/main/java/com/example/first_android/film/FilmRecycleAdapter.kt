package com.example.first_android.film

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
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
        holder.index = position.toString()
        holder.itemView.setOnClickListener(holder)
        Picasso.with(getActivity).load(albumList[position].albumImage).into(holder.imageSong)
        Glide.with(context).load(imageName).into(holder.imageFilm)
    }

}

class FilmViewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
    var index: String = ""
    var imageFilm: ImageView = v.findViewById(R.id.image_film)

    override fun onClick(v: View?) {
        when(v) {
            itemView -> {
                filmViewModel.getFilmByID(index)
                itemView.findNavController().navigate(R.id.action_filmFragment_to_detailFilmFragment)
            }

        }
    }
}