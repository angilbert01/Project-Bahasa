package id.ac.ub.aksara.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import id.ac.ub.aksara.model.AksaraGlyph
import id.ac.ub.aksara.model.AksaraRepository
import id.ac.ub.aksara.model.AppLanguage
import id.ac.ub.aksara.model.AppScreen
import id.ac.ub.aksara.model.CulturalPhrase
import id.ac.ub.aksara.model.Dialect
import id.ac.ub.aksara.model.QuizQuestion
import id.ac.ub.aksara.model.VocabEntry
import id.ac.ub.aksara.util.TtsManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class AksaraUiState(
    val currentScreen: AppScreen = AppScreen.HOME,
    val language: AppLanguage = AppLanguage.ID,
    val selectedDialect: Dialect = Dialect.JAWA,
    val isDarkTheme: Boolean = false,
    val isDyslexiaMode: Boolean = false,
    val fontScale: Float = 1.0f,
    
    // Audio Player State
    val isSpeaking: Boolean = false,
    val spokenText: String = "",
    
    // Dictionary State
    val dictSearchQuery: String = "",
    val selectedCategory: String = "Semua",
    
    // Translate State
    val translateInput: String = "",
    val translateResult: String = "",
    val translateRegister: String = "Krama Alus",

    // Quiz State
    val quizIndex: Int = 0,
    val quizScore: Int = 0,
    val selectedQuizOption: Int? = null,
    val isQuizAnswerSubmitted: Boolean = false
)

class AksaraViewModel(application: Application) : AndroidViewModel(application) {

    private val _uiState = MutableStateFlow(AksaraUiState())
    val uiState: StateFlow<AksaraUiState> = _uiState.asStateFlow()

    val ttsManager = TtsManager(application)

    fun navigateTo(screen: AppScreen) {
        ttsManager.vibrateShort()
        _uiState.update { it.copy(currentScreen = screen) }
    }

    fun toggleLanguage() {
        ttsManager.vibrateShort()
        _uiState.update {
            val newLang = if (it.language == AppLanguage.ID) AppLanguage.EN else AppLanguage.ID
            it.copy(language = newLang)
        }
    }

    fun selectDialect(dialect: Dialect) {
        ttsManager.vibrateShort()
        _uiState.update { it.copy(selectedDialect = dialect) }
    }

    fun toggleDarkTheme() {
        ttsManager.vibrateShort()
        _uiState.update { it.copy(isDarkTheme = !it.isDarkTheme) }
    }

    fun toggleDyslexiaMode() {
        ttsManager.vibrateShort()
        _uiState.update { it.copy(isDyslexiaMode = !it.isDyslexiaMode) }
    }

    fun cycleFontScale() {
        ttsManager.vibrateShort()
        _uiState.update {
            val nextScale = when (it.fontScale) {
                1.0f -> 1.2f
                1.2f -> 1.4f
                else -> 1.0f
            }
            it.copy(fontScale = nextScale)
        }
    }

    fun speak(text: String) {
        ttsManager.vibrateShort()
        _uiState.update { it.copy(isSpeaking = true, spokenText = text) }
        ttsManager.speak(text, isEnglish = _uiState.value.language == AppLanguage.EN)
    }

    fun stopSpeaking() {
        ttsManager.stop()
        _uiState.update { it.copy(isSpeaking = false, spokenText = "") }
    }

    // Dictionary Actions
    fun setDictSearchQuery(query: String) {
        _uiState.update { it.copy(dictSearchQuery = query) }
    }

    fun selectCategory(cat: String) {
        _uiState.update { it.copy(selectedCategory = cat) }
    }

    fun getFilteredVocabulary(): List<VocabEntry> {
        val state = _uiState.value
        return AksaraRepository.vocabulary.filter { entry ->
            val matchDialect = entry.dialect == state.selectedDialect
            val matchCategory = state.selectedCategory == "Semua" || state.selectedCategory == "All" || entry.category.equals(state.selectedCategory, ignoreCase = true)
            val matchQuery = state.dictSearchQuery.isBlank() ||
                entry.word.contains(state.dictSearchQuery, ignoreCase = true) ||
                entry.meaningId.contains(state.dictSearchQuery, ignoreCase = true) ||
                entry.meaningEn.contains(state.dictSearchQuery, ignoreCase = true)
            matchDialect && matchCategory && matchQuery
        }
    }

    // Translation Actions
    fun updateTranslateInput(text: String) {
        _uiState.update {
            it.copy(
                translateInput = text,
                translateResult = computeTranslation(text, it.selectedDialect)
            )
        }
    }

    private fun computeTranslation(input: String, dialect: Dialect): String {
        val clean = input.trim().lowercase()
        if (clean.isBlank()) return ""
        return when (dialect) {
            Dialect.JAWA -> when {
                clean.contains("terima kasih") -> "Matur nuwun sanget (ꦩꦠꦸꦂ ꦤꦸꦮꦸꦤ꧀)"
                clean.contains("makan") -> "Dahar (Krama Inggil) / Mangan (Ngoko)"
                clean.contains("tidur") -> "Sare (Krama Inggil) / Turu (Ngoko)"
                clean.contains("selamat pagi") -> "Sugeng enjang"
                clean.contains("selamat datang") -> "Sugeng rawuh wonten ing tlatah Jawi"
                clean.contains("permisi") -> "Nyuwun sewu, ndherek langkung"
                else -> "Krama: \"${input}\" dipun serat mawi unggah-ungguh basa Jawi ingkang trep."
            }
            Dialect.SUNDA -> when {
                clean.contains("terima kasih") -> "Hatur nuhun pisan (ᮠᮒᮥᮁ ᮔᮥᮠᮥᮔ᮪)"
                clean.contains("makan") -> "Tuang (Lemes) / Neda (Sedeng)"
                clean.contains("permisi") -> "Punten, bade ngalangkung"
                clean.contains("selamat datang") -> "Wilujeng sumping di tatar Pasundan"
                else -> "Basa Lemes: \"${input}\" diserat kalayan tata krama Sunda."
            }
            Dialect.MADURA -> when {
                clean.contains("terima kasih") -> "Mator sakalangkong bân salam seddha"
                clean.contains("makan") -> "Neddha (Alos)"
                clean.contains("permisi") -> "Amit, ngireng langkong"
                else -> "Basa Alos: \"${input}\" dâlem tata krama Madhurâ."
            }
            Dialect.BALI -> when {
                clean.contains("terima kasih") -> "Matur suksma banget (ᬲᬸᬓ᭄ᬱ᭄ᬫ)"
                clean.contains("makan") -> "Ngajeng (Alos Madia)"
                clean.contains("permisi") -> "Nunas lugra titiang"
                else -> "Basa Alus: \"${input}\" kasurat antuk tata krama Bali."
            }
        }
    }

    // Quiz Actions
    fun submitQuizAnswer(index: Int) {
        val state = _uiState.value
        val questions = AksaraRepository.quizzes
        if (state.quizIndex >= questions.size) return

        val question = questions[state.quizIndex]
        val isCorrect = index == question.correctIndex
        val addedScore = if (isCorrect) 100 else 0

        ttsManager.vibrateShort()
        _uiState.update {
            it.copy(
                selectedQuizOption = index,
                isQuizAnswerSubmitted = true,
                quizScore = it.quizScore + addedScore
            )
        }
        
        val feedback = if (isCorrect) {
            if (state.language == AppLanguage.ID) "Jawaban benar! Luar biasa." else "Correct answer! Excellent."
        } else {
            if (state.language == AppLanguage.ID) "Belum tepat. Coba perhatikan penjelasannya." else "Not quite right. Check the explanation."
        }
        ttsManager.speak(feedback, isEnglish = state.language == AppLanguage.EN)
    }

    fun nextQuizQuestion() {
        ttsManager.vibrateShort()
        val questions = AksaraRepository.quizzes
        _uiState.update {
            val nextIdx = (it.quizIndex + 1) % questions.size
            it.copy(
                quizIndex = nextIdx,
                selectedQuizOption = null,
                isQuizAnswerSubmitted = false
            )
        }
    }

    fun resetQuiz() {
        _uiState.update {
            it.copy(
                quizIndex = 0,
                quizScore = 0,
                selectedQuizOption = null,
                isQuizAnswerSubmitted = false
            )
        }
    }

    override fun onCleared() {
        super.onCleared()
        ttsManager.destroy()
    }
}

