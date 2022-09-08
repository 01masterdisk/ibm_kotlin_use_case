package com.stevanus.setianto.sample.ibm_sample.data.source

import com.stevanus.setianto.sample.ibm_sample.BuildConfig
import com.stevanus.setianto.sample.ibm_sample.data.model.DetailMovie.MovieDetail
import com.stevanus.setianto.sample.ibm_sample.data.model.ListMovie.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitInterface {
    @GET(API.GETPOPULER)
    fun getPopuler(
        @Query("api_key") apikey:String = BuildConfig.API_KEY,
        @Query("page") page:Int = 1
    ): Call<MovieResponse>

    @GET(API.GETTOPRATED)
    fun getTopRated(
        @Query("api_key") apikey:String = BuildConfig.API_KEY,
        @Query("page") page:Int = 1
    ): Call<MovieResponse>

    @GET(API.GETUPCOMING)
    fun getUpcoming(
        @Query("api_key") apikey:String = BuildConfig.API_KEY,
        @Query("page") page:Int = 1
    ): Call<MovieResponse>

    @GET(API.GETDETAIL)
    fun getDetailMoview(
        @Path("movie_id") movieid:String,
        @Query("api_key") apikey:String = BuildConfig.API_KEY
    ): Call<MovieDetail>
}

class API {
    companion object {
        const val GETDETAIL = "movie/{movie_id}"
        const val GETPOPULER = "movie/popular"
        const val GETTOPRATED = "movie/top_rated"
        const val GETUPCOMING = "movie/upcoming"
    }
}