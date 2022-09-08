package com.stevanus.setianto.sample.ibm_sample.ui.Detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stevanus.setianto.sample.ibm_sample.data.model.DetailMovie.MovieDetail
import com.stevanus.setianto.sample.ibm_sample.data.model.ListMovie.MovieResponse
import com.stevanus.setianto.sample.ibm_sample.data.source.APIClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel() : ViewModel() {

    private var _result =  MutableLiveData<Any>()

    val result: LiveData<Any> = _result

    fun getDetailMoview(movieId: String) {
        val response = APIClient.getDetailMovie(movieId)
        response.enqueue(object : Callback<MovieDetail> {
            override fun onResponse(call: Call<MovieDetail>, response: Response<MovieDetail>) {
                _result.value = response.body()
            }
            override fun onFailure(call: Call<MovieDetail>, t: Throwable) {
                _result.value  = t.message
            }
        })

    }


}