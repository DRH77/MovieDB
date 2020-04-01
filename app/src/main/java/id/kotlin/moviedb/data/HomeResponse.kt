package id.kotlin.moviedb.data

import com.google.gson.annotations.SerializedName

class HomeResponse(
    @SerializedName("results")
    val results: List<Result>
)

data class Result(
    @SerializedName("title")
    val title: String,

    @SerializedName("overview")
    val overview: String
)