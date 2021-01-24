package com.pavlodar.androidacademymovieapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.pavlodar.androidacademymovieapp.movies_details.FragmentMoviesDetails
import com.pavlodar.androidacademymovieapp.movies_details.OnBackPressedInterface
import com.pavlodar.androidacademymovieapp.movies_list.FragmentMoviesList
import com.pavlodar.androidacademymovieapp.movies_list.data.models.Movie
import com.pavlodar.androidacademymovieapp.movies_list.presentatin.views.OnMovieClickListener

class MainActivity : AppCompatActivity(), OnMovieClickListener, OnBackPressedInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_activity_container, FragmentMoviesList()).commit()
        } else {
            Toast.makeText(this, "***onCreate***", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        Toast.makeText(this, "***onDestroy***", Toast.LENGTH_SHORT).show()
        super.onDestroy()
    }

    private fun goToDetailsFragment(movie: Movie){
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_activity_container, FragmentMoviesDetails.newInstance(movie))
            .addToBackStack(null)
            .commit()
    }

    override fun onMovieItemClick(movie: Movie) {
        goToDetailsFragment(movie)
    }

    override fun onBackPressedAction() {
        onBackPressed()
    }
}