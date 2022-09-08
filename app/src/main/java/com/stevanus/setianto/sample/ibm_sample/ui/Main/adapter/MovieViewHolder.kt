package com.stevanus.setianto.sample.ibm_sample.ui.Main.adapter

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.stevanus.setianto.sample.ibm_sample.BuildConfig
import com.stevanus.setianto.sample.ibm_sample.R
import com.stevanus.setianto.sample.ibm_sample.data.model.ListMovie.MovieListData
import com.stevanus.setianto.sample.ibm_sample.ui.Detail.DetailActivity

class MovieViewHolder(
    val itemView: View,
    val context:Context
    ):RecyclerView.ViewHolder(itemView) {
        fun setMovie(data: MovieListData){
            var title = itemView.findViewById(R.id.title_item) as TextView
            var image = itemView.findViewById(R.id.image_item) as ImageView
            var detail = itemView.findViewById(R.id.detail) as FrameLayout

            title.text = data.title
            Glide.with(context)
                .load("https://image.tmdb.org/t/p/original${data.backdrop_path}")
                .into(image)

            detail.setOnClickListener {
                var intent = Intent(context,DetailActivity::class.java)
                intent.putExtra(BuildConfig.MOVIE_ID,data.id.toString())
                context.startActivities(arrayOf(intent))
            }
        }
}