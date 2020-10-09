package pe.edu.upc.tmdb

import com.google.gson.annotations.SerializedName

class SearchResponse (
    @SerializedName("results")
    val movies: List<Movie>
)