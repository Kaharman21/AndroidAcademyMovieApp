package com.pavlodar.androidacademymovieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pavlodar.androidacademymovieapp.common.extensions.showToast
import com.pavlodar.androidacademymovieapp.movies_details.FragmentMoviesDetails
//import com.pavlodar.androidacademymovieapp.movies_details.FragmentMoviesDetails
//import com.pavlodar.androidacademymovieapp.movies_details.OnBackPressedInterface
import com.pavlodar.androidacademymovieapp.movies_list.FragmentMoviesList
import com.pavlodar.androidacademymovieapp.movies_list.presentatin.views.OnMovieClickListener

class MainActivity : AppCompatActivity(), OnMovieClickListener{  //, OnBackPressedInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_activity_container, FragmentMoviesList()).commit()
        } else {
            showToast("***onCreate***")
        }
    }

    override fun onDestroy() {
        showToast("***onDestroy***")
        super.onDestroy()
    }

    override fun onMovieItemClick(movieId: Long) {
        goToDetailsFragment(movieId)
    }

    private fun goToDetailsFragment(movieId: Long){
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_activity_container, FragmentMoviesDetails.newInstance(movieId))
            .addToBackStack(null)
            .commit()
    }

//    override fun onBackPressedAction() {
//        onBackPressed()
//    }
}