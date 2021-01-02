package com.pavlodar.androidacademymovieapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.pavlodar.androidacademymovieapp.movies_list.FragmentMoviesList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        supportFragmentManager.beginTransaction().replace(R.id.main_activity_container, FragmentMoviesList()).commit()
    }

    private fun initViews() {

    }
}