package pe.edu.upc.tmdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var movies: List<Movie>
    lateinit var movieAdaoter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        btSearch.setOnClickListener(){
            searchMovies()
        }
    }

    private fun searchMovies() {
        val apikey = "8707cdafe802bc110fca73f128b4a52f"
        val search = etSearch.text.toString()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/search/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service:MovieApi = retrofit.create(MovieApi::class.java)

        var searchMethod = service.searchMovies(apikey, search)

        searchMethod.enqueue(object : Callback<SearchResponse>{
            override fun onResponse(call: Call<SearchResponse>, response: Response<SearchResponse>) {
                if (response.isSuccessful) {
                    movies = response.body()!!.movies

                    movieAdaoter = MovieAdapter(movies)
                    rvMovies.adapter = movieAdaoter
                    rvMovies.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }
            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {

            }

        })
    }
}