package com.example.chovypilled.amadeus_kt

import android.media.MediaPlayer

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
    }
}