package com.example.chovypilled.amadeus_kt

import android.speech.tts.Voice
import android.util.Log

class VoiceLine (
    private val id: Int,
    private val mood: Int,
    private val subtitle: Int
)
{
    fun getId(): Int { return id }
    fun getMood(): Int { return mood }
    fun getSubtitle(): Int { return subtitle }

     class Mood {
         companion object {
             val HAPPY: Int = R.drawable.kurisu_happy
             val PISSED: Int = R.drawable.kurisu_pissed
             val ANNOYED: Int = R.drawable.kurisu_annoyed
             val ANGRY: Int = R.drawable.kurisu_angry
             val BLUSH: Int = R.drawable.kurisu_blush
             val SIDE: Int = R.drawable.kurisu_side
             val SAD: Int = R.drawable.kurisu_sad
             val NORMAL: Int = R.drawable.kurisu_normal
             val SLEEPY: Int = R.drawable.kurisu_eyes_closed
             val WINKING: Int = R.drawable.kurisu_winking
             val DISAPPOINTED: Int = R.drawable.kurisu_disappointed
             val INDIFFERENT: Int = R.drawable.kurisu_indifferent
             val SIDED_PLEASANT: Int = R.drawable.kurisu_sided_pleasant
             val SIDED_WORRIED: Int = R.drawable.kurisu_sided_worried
         }
    }

    class Line {
        companion object {
            val voiceLines = arrayOfNulls<VoiceLine>(45)

            const val HELLO: Int = 0
            const val DAGA_KOTOWARU: Int = 1
            const val DEVILISH_PERVERT: Int = 2
            const val I_GUESS: Int = 3
            const val NICE: Int = 4
            const val PERVERT_CONFIRMED: Int = 5
            const val SORRY: Int = 6
            const val SOUNDS_TOUGH: Int = 7
            const val HOPELESS: Int = 8
            const val CHRISTINA: Int = 9
            const val GAH: Int = 10
            const val NO_TINA: Int = 11
            const val WHY_CHRISTINA: Int = 12
            const val WHO_IS_CHRISTINA: Int = 13
            const val ASK_ME: Int = 14
            const val COULD_I_HELP: Int = 15
            const val WHAT_DO_YOU_WANT: Int = 16
            const val WHAT_IS_IT: Int = 17
            const val HEHEHE: Int = 18
            const val WHY_SAY_THAT: Int = 19
            const val YOU_SURE: Int = 20
            const val NICE_TO_MEET_OKABE: Int = 21
            const val LOOKING_FORWARD_TO_WORKING: Int = 22
            const val SENPAI_QUESTION: Int = 23
            const val SENPAI_QUESTIONMARK: Int = 24
            const val SENPAI_WHAT: Int = 25
            const val SENPAI_WHO: Int = 26
            const val SENPAI_DONT_TELL: Int = 27
            const val STILL_NOT_HAPPY: Int = 28
            const val DONT_CALL_ME_THAT: Int = 29
            const val TM_NONSENSE: Int = 30
            const val TM_NO_EVIDENCE: Int = 31
            const val TM_DONT_KNOW: Int = 32
            const val TM_YOU_SAID: Int = 33
            const val HUMANS_SOFTWARE: Int = 34
            const val MEMORY_COMPLEXITY: Int = 35
            const val SECRET_DIARY: Int = 36
            const val MODIFYING_MEMORIES: Int = 37
            const val MEMORIES_CHRISTINA: Int = 38
            const val GAH_EXTENDED: Int = 39
            const val SHOULD_CHRISTINA: Int = 40
            const val OK: Int = 41
            const val TM_NOT_POSSIBLE: Int = 42
            const val PLEASED_TO_MEET: Int = 43
            const val PERVERT_IDIOT: Int = 44

            fun getLines(): Array<VoiceLine?> {
                try {
                    // Time machine-related lines
                    voiceLines[TM_NONSENSE] = VoiceLine(R.raw.tm_nonsense, Mood.DISAPPOINTED, R.string.line_tm_nonsense)
                    voiceLines[TM_NO_EVIDENCE] = VoiceLine(R.raw.tm_scientist_no_evidence, Mood.NORMAL, R.string.line_tm_scientist_no_evidence)
                    voiceLines[TM_DONT_KNOW] = VoiceLine(R.raw.tm_we_dont_know, Mood.NORMAL, R.string.line_tm_we_dont_know)
                    voiceLines[TM_YOU_SAID] = VoiceLine(R.raw.tm_you_said, Mood.SIDED_WORRIED, R.string.line_tm_you_said)
                    voiceLines[TM_NOT_POSSIBLE] = VoiceLine(R.raw.tm_not_possible, Mood.DISAPPOINTED, R.string.line_tm_not_possible)

                    //Disappointed/sad
                    voiceLines[HOPELESS] = VoiceLine(R.raw.this_guy_hopeless, Mood.DISAPPOINTED, R.string.line_this_guy_hopeless)

                    voiceLines[SORRY] = VoiceLine(R.raw.sorry, Mood.SAD, R.string.line_sorry)

                    //Annoyed/angry/pissed
                    voiceLines[DAGA_KOTOWARU] = VoiceLine(R.raw.daga_kotowaru, Mood.ANNOYED, R.string.line_but_i_refuse)
                    voiceLines[CHRISTINA] = VoiceLine(R.raw.christina, Mood.ANNOYED, R.string.line_christina)

                    voiceLines[DEVILISH_PERVERT] = VoiceLine(R.raw.devilish_pervert, Mood.ANGRY, R.string.line_devilish_pervert)
                    voiceLines[NO_TINA] = VoiceLine(R.raw.dont_add_tina, Mood.ANGRY, R.string.line_dont_add_tina)
                    voiceLines[DONT_CALL_ME_THAT] = VoiceLine(R.raw.dont_call_me_like_that, Mood.ANGRY, R.string.line_dont_call_me_like_that)
                    voiceLines[PERVERT_IDIOT] = VoiceLine(R.raw.pervert_idot_wanttodie, Mood.ANGRY, R.string.line_pervert_idiot_wanttodie)

                    voiceLines[PERVERT_CONFIRMED] = VoiceLine(R.raw.pervert_confirmed, Mood.PISSED, R.string.line_pervert_confirmed)
                    voiceLines[WHY_CHRISTINA] = VoiceLine(R.raw.why_christina, Mood.PISSED, R.string.line_why_christina)
                    voiceLines[WHO_IS_CHRISTINA] = VoiceLine(R.raw.who_the_hell_christina, Mood.PISSED, R.string.line_who_the_hell_christina)
                    voiceLines[SHOULD_CHRISTINA] = VoiceLine(R.raw.should_christina, Mood.PISSED, R.string.line_should_christina)

                    //Indifferent/normal
                    voiceLines[I_GUESS] = VoiceLine(R.raw.i_guess, Mood.INDIFFERENT, R.string.line_i_guess)
                    voiceLines[GAH] = VoiceLine(R.raw.gah, Mood.INDIFFERENT, R.string.line_gah)
                    voiceLines[MEMORY_COMPLEXITY] = VoiceLine(R.raw.memory_complex, Mood.INDIFFERENT, R.string.line_memory_complex)
                    voiceLines[SECRET_DIARY] = VoiceLine(R.raw.secret_diary, Mood.INDIFFERENT, R.string.line_secret_diary)
                    voiceLines[MODIFYING_MEMORIES] = VoiceLine(R.raw.modifying_memories_impossible, Mood.INDIFFERENT, R.string.line_modifying_memories_impossible)

                    voiceLines[SENPAI_WHO] = VoiceLine(R.raw.senpai_who_is_this, Mood.NORMAL, R.string.line_senpai_who_is_this)
                    voiceLines[HUMANS_SOFTWARE] = VoiceLine(R.raw.humans_software, Mood.NORMAL, R.string.line_humans_software)

                    //Side/worried/pleasant
                    voiceLines[SOUNDS_TOUGH] = VoiceLine(R.raw.sounds_tough, Mood.SIDE, R.string.line_sounds_tough)
                    voiceLines[SENPAI_QUESTION] = VoiceLine(R.raw.senpai_question, Mood.SIDE, R.string.line_senpai_question)
                    voiceLines[SENPAI_QUESTIONMARK] = VoiceLine(R.raw.senpai_questionmark, Mood.SIDE, R.string.line_senpai_question_mark)

                    voiceLines[WHY_SAY_THAT] = VoiceLine(R.raw.huh_why_say, Mood.SIDED_WORRIED, R.string.line_huh_why_say)
                    voiceLines[YOU_SURE] = VoiceLine(R.raw.you_sure, Mood.SIDED_WORRIED, R.string.line_you_sure)
                    voiceLines[SENPAI_WHAT] = VoiceLine(R.raw.senpai_what_we_talkin, Mood.SIDED_WORRIED, R.string.line_senpai_what_we_talkin)

                    voiceLines[NICE_TO_MEET_OKABE] = VoiceLine(R.raw.nice_to_meet_okabe, Mood.SIDED_PLEASANT, R.string.line_nice_to_meet_okabe)
                    voiceLines[PLEASED_TO_MEET] = VoiceLine(R.raw.pleased_to_meet_you, Mood.SIDED_PLEASANT, R.string.line_pleased_to_meet_you)

                    //Winking
                    voiceLines[NICE] = VoiceLine(R.raw.nice, Mood.WINKING, R.string.line_nice)
                    voiceLines[HEHEHE] = VoiceLine(R.raw.heheh, Mood.WINKING, R.string.line_heheh)
                    voiceLines[MEMORIES_CHRISTINA] = VoiceLine(R.raw.memories_christina, Mood.WINKING, R.string.line_memories_christina)

                    //Happy
                    voiceLines[HELLO] = VoiceLine(R.raw.hello, Mood.HAPPY, R.string.line_hello)
                    voiceLines[ASK_ME] = VoiceLine(R.raw.ask_me_whatever, Mood.HAPPY, R.string.line_ask_me_whatever)
                    voiceLines[COULD_I_HELP] = VoiceLine(R.raw.could_i_help, Mood.HAPPY, R.string.line_could_i_help)
                    voiceLines[WHAT_DO_YOU_WANT] = VoiceLine(R.raw.what_do_you_want, Mood.HAPPY, R.string.line_what_do_you_want)
                    voiceLines[WHAT_IS_IT] = VoiceLine(R.raw.what_is_it, Mood.HAPPY, R.string.line_what_is_it)
                    voiceLines[LOOKING_FORWARD_TO_WORKING] = VoiceLine(R.raw.look_forward_to_working, Mood.HAPPY, R.string.line_look_forward_to_working)
                    voiceLines[OK] = VoiceLine(R.raw.ok, Mood.HAPPY, R.string.line_ok)

                    //Blushing
                    voiceLines[SENPAI_DONT_TELL] = VoiceLine(R.raw.senpai_please_dont_tell, Mood.BLUSH, R.string.line_senpai_please_dont_tell)
                    voiceLines[STILL_NOT_HAPPY] = VoiceLine(R.raw.still_not_happy, Mood.BLUSH, R.string.line_still_not_happy)
                    voiceLines[GAH_EXTENDED] = VoiceLine(R.raw.gah_extended, Mood.BLUSH, R.string.line_gah_extended)

                    return voiceLines
                } catch (e: Exception) {
                    e.printStackTrace()
                    Log.e("VoiceLine", "Error loading voice lines: ${e.message}")
                    return arrayOfNulls(0)
                }
            }
        }
    }
}