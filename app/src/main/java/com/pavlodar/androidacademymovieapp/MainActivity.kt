package com.pavlodar.androidacademymovieapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var intentButtom: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        intentButtom.setOnClickListener {
            intent = Intent(this, MovieDetailsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initViews() {
        intentButtom = findViewById(R.id.activity_intent_button)
    }
}