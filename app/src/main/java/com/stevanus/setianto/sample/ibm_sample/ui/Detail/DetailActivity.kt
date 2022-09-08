package com.stevanus.setianto.sample.ibm_sample.ui.Detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.stevanus.setianto.sample.ibm_sample.BuildConfig
import com.stevanus.setianto.sample.ibm_sample.R
import com.stevanus.setianto.sample.ibm_sample.data.model.DetailMovie.MovieDetail
import com.stevanus.setianto.sample.ibm_sample.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailBinding
    lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var id = intent.extras?.getString(BuildConfig.MOVIE_ID)?: ""
        viewModel = DetailViewModel()

        binding.loadingLayout.root.visibility = View.VISIBLE
        viewModel.getDetailMoview(id)
        event()
        observe()

    }

    private fun event() {
        binding.toolbar.setOnClickListener {
            finish()
        }
    }

    private fun observe() {
        viewModel.result.observe(this@DetailActivity, Observer {
            val result = it?: return@Observer

            binding.loadingLayout.root.visibility = View.GONE
            if(result is MovieDetail){
                Glide.with(this@DetailActivity)
                    .load("https://image.tmdb.org/t/p/original${result.poster_path}")
                    .placeholder(R.drawable.ic_baseline_broken_image_24)
                    .into(binding.poster)
                Glide.with(this@DetailActivity)
                    .load("https://image.tmdb.org/t/p/original${result.backdrop_path}")
                    .placeholder(R.drawable.ic_baseline_broken_image_24)
                    .into(binding.coverPhoto)
                binding.title.text = result.title
                binding.rating.text = "Rating : ${result.vote_average}"
                binding.releaseDate.text = "Release Date : ${result.release_date}"
                binding.sumary.text = "\t${result.overview}"
            }else{
                Toast.makeText(this@DetailActivity,"No Data Available for This Moview",Toast.LENGTH_SHORT).show()
                finish()
            }
        })
    }
}