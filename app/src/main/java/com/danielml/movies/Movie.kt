package com.danielml.movies

import java.io.Serializable

data class Movie(val name: String, val genre: String, val videoName: String): Serializable

enum class VideoName(val videoName: String) {
  SONIC("sonic"),
  DR_STRANGE("dr_strange"),
  MORBIUS("morbius"),
  FANTASTIC_BEASTS( "fantastic")
}
