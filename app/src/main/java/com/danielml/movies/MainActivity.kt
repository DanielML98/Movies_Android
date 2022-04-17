package com.danielml.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
    val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
    val navController = navHostFragment.navController
    bottomNavigationView.setupWithNavController(navController)
  }

  fun signInTapped(view: View) {
    Toast.makeText(this, "You Pressed sign in", Toast.LENGTH_SHORT).show()
  }
}