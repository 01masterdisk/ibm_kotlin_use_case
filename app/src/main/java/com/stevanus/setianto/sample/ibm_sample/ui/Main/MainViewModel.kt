package com.stevanus.setianto.sample.ibm_sample.ui.Main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stevanus.setianto.sample.ibm_sample.data.model.ListMovie.MovieResponse
import com.stevanus.setianto.sample.ibm_sample.data.source.APIClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel() : ViewModel() {

    private var _popularResult =  MutableLiveData<Any>()
    private var _topResult = MutableLiveData<Any>()
    private var _upcomingResult = MutableLiveData<Any>()

    val popularResult: LiveData<Any> = _popularResult
    val topResult: LiveData<Any> = _topResult
    val upcomingResult: LiveData<Any> = _upcomingResult

    fun getListMoviePopular(page: String) {
        val response = APIClient.getPopularMovie(page.toInt())
        response.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                _popularResult.value = response.body()
            }
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                _popularResult.value  = t.message
            }
        })

    }

    fun getListMovieTopRated(page: String) {
        val response = APIClient.getTopRatedMovie(page.toInt())
        response.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>){
                _topResult.value = response.body()
            }
            override fun onFailure(call: Call<MovieResponse>, t: Throwable){
                _topResult.value  = t.message
            }
        })
    }


    fun getListMovieUpcoming(page: String) {
        val response = APIClient.getUpcomingMovie(page.toInt())
        response.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                _upcomingResult.value = response.body()
            }
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                _upcomingResult.value  = t.message
            }
        })
    }

}