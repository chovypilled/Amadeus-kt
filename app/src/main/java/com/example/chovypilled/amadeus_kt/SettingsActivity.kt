package com.example.chovypilled.amadeus_kt

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

class SettingsActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager
            .beginTransaction()
            .replace(android.R.id.content, SettingsFragment())
            .commit()
    }
}