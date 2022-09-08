package com.stevanus.setianto.sample.ibm_sample.data.model.DetailMovie

import com.google.gson.annotations.SerializedName


data class MovieDetail(
    @SerializedName("adult")
    var adult:Boolean,
    @SerializedName("backdrop_path")
    var backdrop_path:String,
    @SerializedName("poster_path")
    var poster_path:String,
    @SerializedName("overview")
    var overview:String,
    @SerializedName("release_date")
    var release_date: String,
    @SerializedName("status")
    var status:String,
    @SerializedName("title")
    var title:String,
    @SerializedName("vote_average")
    var vote_average:Number
)