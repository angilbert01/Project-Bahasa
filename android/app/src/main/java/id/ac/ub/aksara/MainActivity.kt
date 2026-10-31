package id.ac.ub.aksara

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import id.ac.ub.aksara.model.AppScreen
import id.ac.ub.aksara.ui.components.AksaraBottomNav
import id.ac.ub.aksara.ui.components.AksaraHeader
import id.ac.ub.aksara.ui.screens.DictionaryScreen
import id.ac.ub.aksara.ui.screens.GameScreen
import id.ac.ub.aksara.ui.screens.HomeScreen
import id.ac.ub.aksara.ui.screens.TranslateScreen
import id.ac.ub.aksara.ui.theme.AksaraTheme
import id.ac.ub.aksara.viewmodel.AksaraViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val viewModel: AksaraViewModel = viewModel()
            val uiState by viewModel.uiState.collectAsState()

            AksaraTheme(
                darkTheme = uiState.isDarkTheme,
                dyslexiaMode = uiState.isDyslexiaMode,
                fontScale = uiState.fontScale
            ) {
                Scaffold(
                    topBar = {
                        AksaraHeader(
                            uiState = uiState,
                            onToggleLanguage = viewModel::toggleLanguage,
                            onToggleDyslexia = viewModel::toggleDyslexiaMode,
                            onCycleFontScale = viewModel::cycleFontScale,
                            onToggleDarkTheme = viewModel::toggleDarkTheme,
                            onSelectDialect = viewModel::selectDialect,
                            onStopAudio = viewModel::stopSpeaking
                        )
                    },
                    bottomBar = {
                        AksaraBottomNav(
                            currentScreen = uiState.currentScreen,
                            language = uiState.language,
                            onNavigate = viewModel::navigateTo
                        )
                    }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .background(MaterialTheme.colorScheme.background)
                    ) {
                        when (uiState.currentScreen) {
                            AppScreen.HOME -> {
                                HomeScreen(
                                    uiState = uiState,
                                    onSpeak = viewModel::speak
                                )
                            }
                            AppScreen.DICTIONARY -> {
                                DictionaryScreen(
                                    uiState = uiState,
                                    filteredVocab = viewModel.getFilteredVocabulary(),
                                    onSearchChange = viewModel::setDictSearchQuery,
                                    onCategoryChange = viewModel::selectCategory,
                                    onSpeak = viewModel::speak
                                )
                            }
                            AppScreen.TRANSLATE -> {
                                TranslateScreen(
                                    uiState = uiState,
                                    onInputChange = viewModel::updateTranslateInput,
                                    onSpeak = viewModel::speak
                                )
                            }
                            AppScreen.GAME -> {
                                GameScreen(
                                    uiState = uiState,
                                    onSubmitAnswer = viewModel::submitQuizAnswer,
                                    onNextQuestion = viewModel::nextQuizQuestion,
                                    onResetQuiz = viewModel::resetQuiz,
                                    onSpeak = viewModel::speak
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

