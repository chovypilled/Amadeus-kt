package com.example.chovypilled.amadeus_kt

import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.preference.PreferenceManager
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    val voiceLines = VoiceLine.Line.getLines()
    private lateinit var speak: (line: VoiceLine, activity: MainActivity) -> Unit

    private fun hasPermissions(): Boolean {
        return ActivityCompat.checkSelfPermission(this, android.Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED
    }

    private fun chooseSpeakFunc() {
        speak = if (hasPermissions()) {
            { line, activity ->
                Amadeus.speakVisualizer(line, activity)
            }
        } else {
            { line, activity ->
                Amadeus.speak(line, activity)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val kurisu: ImageView = findViewById(R.id.imageView_kurisu)
        val subBackground: ImageView = findViewById(R.id.imageView_subtitles)
        val logo: ImageView = findViewById(R.id.imageView_logo_small)
        val settings: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.RECORD_AUDIO), 1)
        chooseSpeakFunc() // needs restart to take effect, I'll fix this later

        if (settings.getBoolean("show_subtitles", false)) {
            subBackground.visibility = View.INVISIBLE
            Log.d("MainActivity", "Subtitles are hidden")
        }

        val rng = Random(System.currentTimeMillis())
        speak(voiceLines[VoiceLine.Line.HELLO]!!, this)

        val handler = Handler(Looper.getMainLooper())
        val loop: Runnable = object : Runnable {
            override fun run() {
                if (Amadeus.isLooping) {
                    Log.d("MainActivity", "Looping")
                        speak(voiceLines[rng.nextInt(voiceLines.size)]!!, this@MainActivity)
                        handler.postDelayed(this, ((5000 + rng.nextInt(5) * 1000).toLong()))
                }
            }
        }

        kurisu.setOnLongClickListener {
            Log.d("MainActivity", "Long click on Kurisu")
            if (!Amadeus.isLooping && !Amadeus.isSpeaking) {
                handler.post(loop)
                Amadeus.isLooping = true
                Log.d("MainActivity", "Looping started")
            } else {
                Log.d("MainActivity", "Looping stopped")
                handler.removeCallbacks(loop)
                Amadeus.isLooping = false
            }
            true
        }

        kurisu.setOnClickListener {
            Log.d("MainActivity", "Click on Kurisu")
        }

        logo.setOnClickListener {
            Log.d("MainActivity", "Click on logo")
        }

        logo.setOnLongClickListener {
            Log.d("MainActivity", "Long click on logo")
            true
        }

        subBackground.setOnClickListener {
            Log.d("MainActivity", "Click on subtitles")
        }

        subBackground.setOnLongClickListener {
            Log.d("MainActivity", "Long click on subtitles")
            true
        }
    }
}