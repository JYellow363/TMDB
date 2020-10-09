package pe.edu.upc.tmdb

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("movie")
    fun searchMovies(
        @Query("api_key")apiKey: String,
        @Query("query")movie: String
    ): Call<SearchResponse>
}