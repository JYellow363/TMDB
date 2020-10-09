package pe.edu.upc.tmdb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.prototype_movie.view.*

class MovieAdapter(val movies: List<Movie>): RecyclerView.Adapter<MoviePrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviePrototype {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.prototype_movie, parent, false)

        return MoviePrototype(view)
    }

    override fun onBindViewHolder(holder: MoviePrototype, position: Int) {
        holder.bindTo(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}

class MoviePrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindTo(movie: Movie){
        itemView.tvTitle.text = movie.title
        itemView.tvOverview.text = movie.overview
    }
}
