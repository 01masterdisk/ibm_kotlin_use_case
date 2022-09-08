package com.stevanus.setianto.sample.ibm_sample.ui.Main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stevanus.setianto.sample.ibm_sample.R
import com.stevanus.setianto.sample.ibm_sample.data.model.ListMovie.MovieListData

class MovieAdapter(
    val context: Context,
    val list: List<MovieListData>
    ): RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view : View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie,parent,false)
        return MovieViewHolder(view,context)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.setMovie(list[position])
    }

    override fun getItemCount(): Int = list.size
}