package com.stevanus.setianto.sample.ibm_sample.data.source

import com.stevanus.setianto.sample.ibm_sample.data.model.DetailMovie.MovieDetail
import com.stevanus.setianto.sample.ibm_sample.data.model.ListMovie.MovieResponse
import retrofit2.Call

class APIClient {
    companion object{
        fun getPopularMovie(page:Int): Call<MovieResponse> {
            return RetrofitClient.getClient().create(RetrofitInterface::class.java).getPopuler(page=page)
        }

        fun getTopRatedMovie(page:Int):Call<MovieResponse>{
            return RetrofitClient.getClient().create(RetrofitInterface::class.java).getTopRated(page=page)
        }

        fun getUpcomingMovie(page:Int):Call<MovieResponse> {
            return RetrofitClient.getClient().create(RetrofitInterface::class.java).getUpcoming(page=page)
        }
        fun getDetailMovie(id:String):Call<MovieDetail> {
            return RetrofitClient.getClient().create(RetrofitInterface::class.java).getDetailMoview(movieid = id)
        }
    }
}