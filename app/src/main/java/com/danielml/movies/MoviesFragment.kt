package com.danielml.movies

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MoviesFragment : Fragment(), MoviesAdapter.OnMovieClick {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    val view = inflater.inflate(R.layout.fragment_movies, container, false)
    view.context.setTheme(R.style.Theme_Movies)
    val moviesRV = view.findViewById<RecyclerView>(R.id.moviesRV)
    moviesRV.adapter = MoviesAdapter(view.context, getMoviesModel(), this)
    moviesRV.layoutManager = LinearLayoutManager(activity)
    return view
  }

  private fun getMoviesModel(): MutableList<Movie>? {
    return mutableListOf(
      Movie("Sonic 2", "Action", VideoName.SONIC.videoName),
      Movie("Dr. Strange in the multiverse of madness", "Suspense", VideoName.DR_STRANGE.videoName),
      Movie("Morbius", "Thriller", VideoName.MORBIUS.videoName),
      Movie("Fantastic beasts 3", "Science Fiction", VideoName.FANTASTIC_BEASTS.videoName)
    )
  }

  override fun onMovieClick(movie: Movie) {
    val intent = Intent(view?.context, MovieTrailerActivity::class.java)
    intent.putExtra("currentMovie", movie)
    startActivity(intent)
  }

}