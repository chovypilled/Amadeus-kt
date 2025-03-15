package com.example.chovypilled.amadeus_kt

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val kurisu: ImageView = findViewById(R.id.imageView_kurisu)
        val subBackground: ImageView = findViewById(R.id.imageView_subtitles)
        val settings: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
    }
}