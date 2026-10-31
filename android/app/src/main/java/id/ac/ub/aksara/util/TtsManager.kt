package id.ac.ub.aksara.util

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import android.speech.tts.TextToSpeech
import java.util.Locale

class TtsManager(private val context: Context) : TextToSpeech.OnInitListener {

    private var tts: TextToSpeech? = null
    private var isReady = false
    private var indonesianLocale: Locale = Locale("id", "ID")

    init {
        tts = TextToSpeech(context.applicationContext, this)
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            isReady = true
            setupIndonesianLocale()
            tts?.setPitch(1.0f)
            tts?.setSpeechRate(0.95f) // Natural conversational speed
        }
    }

    private fun setupIndonesianLocale() {
        val candidates = listOf(
            Locale("id", "ID"),
            Locale("in", "ID"), // Android/Java legacy ISO code for Indonesian
            Locale("id"),
            Locale("in")
        )

        var matched = false
        for (loc in candidates) {
            val availability = tts?.isLanguageAvailable(loc) ?: TextToSpeech.LANG_NOT_SUPPORTED
            if (availability >= TextToSpeech.LANG_AVAILABLE) {
                tts?.setLanguage(loc)
                indonesianLocale = loc
                matched = true
                break
            }
        }

        // Check specific installed voices
        if (!matched && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            try {
                val idVoice = tts?.voices?.firstOrNull { voice ->
                    val lang = voice.locale.language.lowercase(Locale.ROOT)
                    lang == "id" || lang == "in"
                }
                if (idVoice != null) {
                    tts?.voice = idVoice
                    indonesianLocale = idVoice.locale
                    matched = true
                }
            } catch (_: Exception) {}
        }

        // Default to id-ID, NEVER fall back to English for Indonesian speech
        if (!matched) {
            tts?.setLanguage(Locale("id", "ID"))
            indonesianLocale = Locale("id", "ID")
        }
    }

    fun speak(text: String, isEnglish: Boolean = false) {
        if (!isReady || tts == null) return

        if (isEnglish) {
            tts?.language = Locale.ENGLISH
        } else {
            // Guarantee Indonesian locale is active
            tts?.language = indonesianLocale
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                try {
                    val idVoice = tts?.voices?.firstOrNull {
                        val lang = it.locale.language.lowercase(Locale.ROOT)
                        lang == "id" || lang == "in"
                    }
                    if (idVoice != null) {
                        tts?.voice = idVoice
                    }
                } catch (_: Exception) {}
            }
        }

        tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "AksaraTtsUtterance")
    }

    fun stop() {
        tts?.stop()
    }

    fun vibrateShort() {
        try {
            val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val vm = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as? VibratorManager
                vm?.defaultVibrator
            } else {
                @Suppress("DEPRECATION")
                context.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator?.vibrate(VibrationEffect.createOneShot(30, VibrationEffect.DEFAULT_AMPLITUDE))
            } else {
                @Suppress("DEPRECATION")
                vibrator?.vibrate(30)
            }
        } catch (_: Exception) {
            // gracefully fallback if vibration is restricted
        }
    }

    fun destroy() {
        tts?.stop()
        tts?.shutdown()
        tts = null
        isReady = false
    }
}
