package com.example.chovypilled.amadeus_kt

import android.app.Activity
import android.content.SharedPreferences
import android.content.res.Resources
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.Drawable
import android.media.MediaPlayer
import android.media.audiofx.Visualizer
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.preference.PreferenceManager
import org.w3c.dom.Text

class Amadeus {

    companion object {
        var isSpeaking: Boolean = false
        var isLooping: Boolean = false
        lateinit var player: MediaPlayer

        //val shaman_girls: Int = -1
        val voiceLines: Array<VoiceLine?> = VoiceLine.Line.getLines()
        val responseInputMap = mutableMapOf<List<Int>, List<VoiceLine?>>()

        init {
            responseInputMap[listOf(
                R.string.christina
            )] = listOf(
                voiceLines[VoiceLine.Line.CHRISTINA],
                voiceLines[VoiceLine.Line.NO_TINA],
                voiceLines[VoiceLine.Line.WHY_CHRISTINA],
                voiceLines[VoiceLine.Line.SHOULD_CHRISTINA]
            )

            responseInputMap[listOf(
                R.string.the_zombie, R.string.the_zombie2, R.string.celeb17
            )] = listOf(
                voiceLines[VoiceLine.Line.DONT_CALL_ME_THAT]
            )

            responseInputMap[listOf(
                R.string.atchannel, R.string.kurigohan, R.string.kamehameha
            )] = listOf(
                voiceLines[VoiceLine.Line.SENPAI_DONT_TELL],
                voiceLines[VoiceLine.Line.STILL_NOT_HAPPY]
            )

            // Not bothering with the Leskinen crap for now lol
            responseInputMap[listOf(
                R.string.nullpo
            )] = listOf(
                voiceLines[VoiceLine.Line.GAH],
                voiceLines[VoiceLine.Line.GAH_EXTENDED]
            )

            responseInputMap[listOf(
                R.string.salieri, R.string.maho, R.string.hiyajo
            )] = listOf(
                voiceLines[VoiceLine.Line.SENPAI_QUESTION],
                voiceLines[VoiceLine.Line.SENPAI_QUESTIONMARK],
                voiceLines[VoiceLine.Line.SENPAI_WHAT],
                voiceLines[VoiceLine.Line.SENPAI_WHO]
            )

            responseInputMap[listOf(
                R.string.memory, R.string.amadeus, R.string.science
            )] = listOf(
                voiceLines[VoiceLine.Line.HUMANS_SOFTWARE],
                voiceLines[VoiceLine.Line.MEMORY_COMPLEXITY],
                voiceLines[VoiceLine.Line.SECRET_DIARY],
                voiceLines[VoiceLine.Line.MODIFYING_MEMORIES],
                voiceLines[VoiceLine.Line.MEMORIES_CHRISTINA]
            )

            // Yeah
            responseInputMap[listOf(
                R.string.nice_body, R.string.hot, R.string.sexy,
                R.string.boobies, R.string.oppai
            )] = listOf(
                voiceLines[VoiceLine.Line.PERVERT_CONFIRMED],
                voiceLines[VoiceLine.Line.DEVILISH_PERVERT],
                voiceLines[VoiceLine.Line.PERVERT_IDIOT]
            )

            responseInputMap[listOf(
                R.string.time_machine, R.string.time_travel2,
                R.string.cern, R.string.time_travel
            )] = listOf(
                voiceLines[VoiceLine.Line.TM_NONSENSE],
                voiceLines[VoiceLine.Line.TM_YOU_SAID],
                voiceLines[VoiceLine.Line.TM_NO_EVIDENCE],
                voiceLines[VoiceLine.Line.TM_DONT_KNOW],
                voiceLines[VoiceLine.Line.TM_NOT_POSSIBLE]
            )

            responseInputMap[listOf(
                R.string.robotics_notes,
                R.string.antimatter
            )] = listOf(
                voiceLines[VoiceLine.Line.HEHEHE]
            )

            responseInputMap[listOf(
                R.string.hello, R.string.good_morning, R.string.good_evening, R.string.konnichiwa
            )] = listOf(
                voiceLines[VoiceLine.Line.HELLO],
                voiceLines[VoiceLine.Line.PLEASED_TO_MEET],
                voiceLines[VoiceLine.Line.NICE_TO_MEET_OKABE],
                voiceLines[VoiceLine.Line.LOOKING_FORWARD_TO_WORKING]
            )
        }

        fun speak(line: VoiceLine, act: Activity) {
            val anim: AnimationDrawable
            val subs: TextView = act.findViewById(R.id.textView_subtitles)
            val kurisu: ImageView = act.findViewById(R.id.imageView_kurisu)
            var settings: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(act)

            try {
                player = MediaPlayer.create(act, line.getId())
                if (settings.getBoolean("show_subtitles", true)) {
                    subs.setText(line.getSubtitle())
                }

                var res: Resources = act.resources
                anim = Drawable.createFromXml(res, res.getXml(line.getMood())) as AnimationDrawable

                if (player.isPlaying) {
                    player.stop()
                    player.release()
                    player = MediaPlayer()
                }

                act.runOnUiThread {
                    kurisu.setImageDrawable(anim.getFrame(0))
                }

                player.start()
                player.setOnCompletionListener {
                    player.release()
                    isSpeaking = false

                    act.runOnUiThread {
                        kurisu.setImageDrawable(anim.getFrame(0))
                        // anim.start()
                    }
                }
                isSpeaking = true

            } catch (e: Exception) {
                Log.e("Amadeus", "Error in speak(line, act): ${e.message}")
            }
        }

        fun speakVisualizer(line: VoiceLine, act: Activity) {
            val anim: AnimationDrawable
            val subs: TextView = act.findViewById(R.id.textView_subtitles)
            val kurisu: ImageView = act.findViewById(R.id.imageView_kurisu)
            var settings: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(act)

            try {
                player = MediaPlayer.create(act, line.getId())
                val v: Visualizer = Visualizer(player.audioSessionId)

                if (settings.getBoolean("show_subtitles", true)) {
                    subs.setText(line.getSubtitle())
                }

                var res = act.resources
                anim = Drawable.createFromXml(res, res.getXml(line.getMood())) as AnimationDrawable

                if (player.isPlaying) {
                    player.stop()
                    player.release()
                    v.enabled = false
                    player = MediaPlayer()
                }

                player.setOnPreparedListener {
                    isSpeaking = true
                    player.start()
                    v.enabled = true
                }

                player.setOnCompletionListener {
                    isSpeaking = false
                    player.release()
                    v.enabled = false

                    act.runOnUiThread {
                        kurisu.setImageDrawable(anim.getFrame(0))
                    }
                }

                v.enabled = false
                v.captureSize = Visualizer.getCaptureSizeRange()[1]
                v.setDataCaptureListener(
                    object : Visualizer.OnDataCaptureListener {
                        override fun onWaveFormDataCapture(
                            visualizer: Visualizer?,
                            waveform: ByteArray?,
                            samplingRate: Int
                        ) {
                            var sum: Int = 0
                            for (i in 1 until waveform!!.size) {
                                sum += waveform[i] + 128
                            }

                            val normalized: Float = sum / waveform.size.toFloat()

                            act.runOnUiThread {
                                if (normalized > 50) {
                                    kurisu.setImageDrawable(anim.getFrame(Math.ceil(Math.random() * 2)
                                        .toInt()))
                                } else {
                                    kurisu.setImageDrawable(anim.getFrame(0))
                                }
                            }
                        }

                        override fun onFftDataCapture(
                            visualizer: Visualizer?,
                            fft: ByteArray?,
                            samplingRate: Int
                        ) {
                            // Do nothing
                        }
                    }, Visualizer.getMaxCaptureRate() / 2, true, false
                )

            } catch (e: Exception) {
                Log.e("Amadeus", "Error in speakVisualizer(line, act): ${e.message}")
            }
        }
    }
}