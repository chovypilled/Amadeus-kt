package com.example.chovypilled.amadeus_kt

import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.preference.PreferenceManager

import java.util.concurrent.Executor

class MainActivity : AppCompatActivity() {
    val voiceLines = VoiceLine.Line.getLines()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val kurisu: ImageView = findViewById(R.id.imageView_kurisu)
        val subBackground: ImageView = findViewById(R.id.imageView_subtitles)
        val settings: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        //ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.RECORD_AUDIO), 1)
        Amadeus.speak(voiceLines[VoiceLine.Line.HELLO]!!, this)
    }
}