package com.danielml.movies

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MoviesAdapter(private val context: Context?, private val moviesModel: MutableList<Movie>?) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
    return ViewHolder(view)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val currentMovie: Movie = moviesModel?.get(position) ?: Movie("","")
    holder.bind(currentMovie)
  }

  override fun getItemCount(): Int = moviesModel?.size ?: 0

  inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val titleTextView = itemView.findViewById<TextView>(R.id.titleTv)
    private val genreTextView = itemView.findViewById<TextView>(R.id.genreTv)

    fun bind(movie: Movie) {
      titleTextView.text = movie.name
      genreTextView.text = movie.genre
    }
  }

}
