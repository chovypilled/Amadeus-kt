package com.example.chovypilled.amadeus_kt

import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    val voiceLines = VoiceLine.Line.getLines()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val kurisu: ImageView = findViewById(R.id.imageView_kurisu)
        val subBackground: ImageView = findViewById(R.id.imageView_subtitles)
        val settings: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        //ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.RECORD_AUDIO), 1)
        val rng = Random(System.currentTimeMillis())

        if (settings.getBoolean("show_subtitles", false)) {
            subBackground.visibility = View.INVISIBLE
            Log.d("MainActivity", "Subtitles are hidden")
        }

        val handler = Handler(Looper.getMainLooper())
        val loop: Runnable = object : Runnable {
            override fun run() {
                if (Amadeus.isLooping) {
                    Amadeus.speak(voiceLines[rng.nextInt(voiceLines.size)]!!, this@MainActivity)
                    handler.postDelayed(this, ((5000 + rng.nextInt(5) * 1000).toLong()))
                }
            }
        }
        Amadeus.isLooping = true
        handler.post(loop)


//        kurisu.setOnLongClickListener(View.OnLongClickListener{
//            if (!Amadeus.isLooping && !Amadeus.isSpeaking) {
//                handler.post(loop)
//                Amadeus.isLooping = true
//            } else {
//                handler.removeCallbacks(loop)
//                Amadeus.isLooping = false
//            }
//            true
//        })
    }
}