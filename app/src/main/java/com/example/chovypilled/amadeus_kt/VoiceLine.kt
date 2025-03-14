package com.example.chovypilled.amadeus_kt

class VoiceLine {
    private val id: Int = 0
    private val mood: Int = 0
    private val subtitle: Int = 0

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
            val voiceLines = arrayOfNulls<VoiceLine>(40)

            val HELLO: Int = 0
            val DAGA_KOTOWARU: Int = 1
            val DEVILISH_PERVERT: Int = 2
            val I_GUESS: Int = 3
            val NICE: Int = 4
            val PERVERT_CONFIRMED: Int = 5
            val SORRY: Int = 6
            val SOUNDS_TOUGH: Int = 7
            val HOPELESS: Int = 8
            val CHRISTINA: Int = 9
            val GAH: Int = 10
            val NO_TINA: Int = 11
            val WHY_CHRISTINA: Int = 12
            val WHO_IS_CHRISTINA: Int = 13
            val ASK_ME: Int = 14
            val COULD_I_HELP: Int = 15
            val WHAT_DO_YOU_WANT: Int = 16
            val WHAT_IS_IT: Int = 17
            val HEHEHE: Int = 18
            val WHY_SAY_THAT: Int = 19
            val YOU_SURE: Int = 20
            val NICE_TO_MEET_OKABE: Int = 21
            val LOOKING_FORWARD_TO_WORKING: Int = 22
            val SENPAI_QUESTION: Int = 23
            val SENPAI_QUESTIONMARK: Int = 24
            val SENPAI_WHAT: Int = 25
            val SENPAI_WHO: Int = 26
            val SENPAI_DONT_TELL: Int = 27
            val STILL_NOT_HAPPY: Int = 28
            val DONT_CALL_ME_THAT: Int = 29
            val TM_NONSENSE: Int = 30
            val TM_NO_EVIDENCE: Int = 31
            val TM_DONT_KNOW: Int = 32
            val TM_YOU_SAID: Int = 33
            val HUMANS_SOFTWARE: Int = 34
            val MEMORY_COMPLEXITZY: Int = 35
            val SECRET_DIARY: Int = 36
            val MODIFYING_MEMORIES: Int = 37
            val MEMORIES_CHRISTINA: Int = 38
            val GAH_EXTENDED: Int = 39
            val SHOULD_CHRISTINA: Int = 40
            val OK: Int = 41
            val TM_NOT_POSSIBLE: Int = 42
            val PLEASED_TO_MEET: Int = 43
            val PERVERT_IDIOT: Int = 44

            fun getLines(): Array<VoiceLine?> {
                throw NotImplementedError()
            }
        }
    }
}