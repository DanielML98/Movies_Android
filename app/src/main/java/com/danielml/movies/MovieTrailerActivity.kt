package com.danielml.movies

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView

class MovieTrailerActivity() : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_movie_trailer)
    val video = findViewById<VideoView>(R.id.videoView)
    val currentMovie = intent.getSerializableExtra("currentMovie") as? Movie
    val videoPath = "android.resource://"+ packageName +"/raw/${currentMovie?.videoName}"
    val uri = Uri.parse(videoPath)
    video.setVideoURI(uri)
    val mediaController: MediaController = MediaController(this)
    mediaController.setAnchorView(video)
    video.setMediaController(mediaController)
    video.start()
  }
}