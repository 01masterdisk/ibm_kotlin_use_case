package com.stevanus.setianto.sample.ibm_sample.data.model.ListMovie

import com.google.gson.annotations.SerializedName


data class MovieResponse(
    @SerializedName("page")
    var page:Int,
    @SerializedName("results")
    var results:List<MovieListData>
)