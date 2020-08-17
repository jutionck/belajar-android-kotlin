package com.example.first_android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.first_android.view_model.SongViewModel
import com.squareup.picasso.Picasso

class SongRecycleAdapter(
    private val songList: SongViewModel,
    private val getActivity: FragmentActivity?
): RecyclerView.Adapter<SongViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.song_item_layout, parent, false)
        return SongViewHolder(view, songList)
    }

    override fun getItemCount(): Int {
        return songList.songData.value!!.size
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.songTitle.text = songList.songData.value!![position]["title"]
        holder.artistSong.text = songList.songData.value!![position]["name"]
        Picasso.with(getActivity).load(songList.songData.value!![position]["image"]).into(holder.imageSong)
        println(songList.songData.value!![position]["image"])
        holder.orderNumber = position
        holder.itemView.setOnClickListener(holder)
    }

}

class SongViewHolder(v: View, private val songList: SongViewModel): RecyclerView.ViewHolder(v), View.OnClickListener {
    var orderNumber: Int  = 0
    val songTitle: TextView = v.findViewById<TextView>(R.id.song_title)
    val artistSong: TextView = v.findViewById<TextView>(R.id.artist_song)
    val imageSong: ImageView = v.findViewById<ImageView>(R.id.image_song)

    override fun onClick(v: View?) {
        when(v){
            itemView -> {
                songList.detailSong(orderNumber)
                itemView.findNavController().navigate(R.id.action_fragmentHome_to_fragmentDetail)
            }
        }
    }
}

