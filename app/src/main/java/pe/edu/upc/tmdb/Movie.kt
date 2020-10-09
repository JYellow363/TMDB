package pe.edu.upc.tmdb

import com.google.gson.annotations.SerializedName

class Movie (
    @SerializedName("title")
    val title: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("poster_path")
    val poster: String
)