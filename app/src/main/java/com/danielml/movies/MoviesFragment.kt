package com.danielml.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MoviesFragment : Fragment() {

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
    moviesRV.adapter = MoviesAdapter(view.context, getMoviesModel())
    moviesRV.layoutManager = LinearLayoutManager(activity)
    return view
  }

  private fun getMoviesModel(): MutableList<Movie>? {
    return mutableListOf(
      Movie("Sonic 2", "Action"),
      Movie("Dr. Strange in the multiverse of madness", "Suspense"),
      Movie("Morbius", "Thriller"),
      Movie("Fantastic beasts 3", "Science Fiction")
    )
  }

}