package com.example.first_android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.first_android.room.music.Song

class SongRecycleAdapter(private val listSong: List<Song>) :

    RecyclerView.Adapter<SongViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.song_item_layout, parent, false)
        return SongViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.songTitle.text = listSong[position].songName
        holder.songDuration.text = listSong[position].songDuration
        holder.playMusic.setOnClickListener {
            holder.playMusic.setImageResource(R.drawable.ic_baseline_pause_24)
        }
    }

    override fun getItemCount(): Int {
        return listSong.size
    }

}

class SongViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val songTitle: TextView = view.findViewById<TextView>(R.id.songTitleDetail)
    val songDuration: TextView = view.findViewById<TextView>(R.id.songDuration)
    val playMusic: ImageView = view.findViewById<ImageView>(R.id.playMusic)
}