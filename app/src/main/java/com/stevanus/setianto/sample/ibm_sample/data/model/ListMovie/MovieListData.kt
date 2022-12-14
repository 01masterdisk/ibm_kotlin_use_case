package com.stevanus.setianto.sample.ibm_sample.data.model.ListMovie

import com.google.gson.annotations.SerializedName


data class MovieListData(
    @SerializedName("adult")
    var adult:Boolean,
    @SerializedName("backdrop_path")
    var backdrop_path:String,
    @SerializedName("genre_ids")
    var genre_ids:List<Int>,
    @SerializedName("id")
    var id: Int,
    @SerializedName("original_language")
    var original_language: String,
    @SerializedName("release_date")
    var release_date:String,
    @SerializedName("poster_path")
    var poster_path:String,
    @SerializedName("title")
    var title:String
)