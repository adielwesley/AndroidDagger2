package com.example.tools.features.movies.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tools.R
import com.example.tools.features.model.Movie
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter() : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var list = mutableListOf<Movie>()

    fun setData(list : MutableList<Movie>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = list[position]
        holder.bindView(movie)
    }

    inner class MovieViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
        fun bindView(movie: Movie) {
            view.movieTitle.text = movie.title
        }
    }
}