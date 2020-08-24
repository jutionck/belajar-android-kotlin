package com.example.first_android.transaksi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.first_android.R
import com.squareup.picasso.Picasso

class TransaksiRecycleAdapter (private val transaksiList: List<Transaksi>) : RecyclerView.Adapter<FilmViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.history_list_item, parent, false)
        return FilmViewHolder(view)
    }

    override fun getItemCount(): Int {
        return transaksiList.size
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.moneyView.text = transaksiList[position].amount
        holder.dateView.text = transaksiList[position].trans_date
        val bundle = bundleOf(Pair("user_owner_id", transaksiList[position].user_owner_id))
        holder.itemView.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_homeFragment_to_historyFragment, bundle)
        }
    }
}

class FilmViewHolder(v: View): RecyclerView.ViewHolder(v) {
    val moneyView: TextView = v.findViewById<TextView>(R.id.moneyViewText)
    val dateView: TextView = v.findViewById<TextView>(R.id.dateViewText)
}