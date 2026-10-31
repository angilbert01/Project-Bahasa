package id.ac.ub.aksara.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.ac.ub.aksara.model.AksaraRepository
import id.ac.ub.aksara.model.AppLanguage
import id.ac.ub.aksara.ui.theme.BrandGold
import id.ac.ub.aksara.ui.theme.BrandNavy
import id.ac.ub.aksara.viewmodel.AksaraUiState

@Composable
fun GameScreen(
    uiState: AksaraUiState,
    onSubmitAnswer: (Int) -> Unit,
    onNextQuestion: () -> Unit,
    onResetQuiz: () -> Unit,
    onSpeak: (String) -> Unit
) {
    val isId = uiState.language == AppLanguage.ID
    val questions = AksaraRepository.quizzes
    val currentQ = if (questions.isNotEmpty()) questions[uiState.quizIndex % questions.size] else null

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(12.dp))

        // Quiz Top Header & Score
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = if (isId) "Tebak Aksara & Unggah-Ungguh" else "Script & Etiquette Quiz",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.semantics { heading() }
                )
                Text(
                    text = if (isId) "Uji ketajaman membaca aksara nusantara" else "Test your regional script fluency",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
                )
            }

            Surface(
                shape = RoundedCornerShape(12.dp),
                color = BrandGold.copy(alpha = 0.15f),
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.EmojiEvents,
                        contentDescription = null,
                        tint = BrandGold,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = "${uiState.quizScore} Poin",
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = BrandGold
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Progress Bar
        val progress = (uiState.quizIndex + 1).toFloat() / questions.size.coerceAtLeast(1)
        LinearProgressIndicator(
            progress = progress,
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp)
                .clip(CircleShape),
            color = BrandGold,
            trackColor = MaterialTheme.colorScheme.surface
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (currentQ != null) {
            // Big Glyph Card Prompt
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = currentQ.scriptPrompt,
                        fontSize = 48.sp,
                        fontWeight = FontWeight.Bold,
                        color = BrandGold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = if (isId) currentQ.questionId else currentQ.questionEn,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    IconButton(
                        onClick = {
                            val text = if (isId) currentQ.questionId else currentQ.questionEn
                            onSpeak(text)
                        },
                        modifier = Modifier.size(32.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.VolumeUp,
                            contentDescription = "Bacakan pertanyaan",
                            tint = BrandGold,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Options
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                currentQ.options.forEachIndexed { idx, option ->
                    val isSelected = uiState.selectedQuizOption == idx
                    val isSubmitted = uiState.isQuizAnswerSubmitted
                    val isCorrectOption = idx == currentQ.correctIndex

                    val (containerColor, contentColor) = when {
                        isSubmitted && isCorrectOption -> Color(0xFF15803D) to Color.White
                        isSubmitted && isSelected && !isCorrectOption -> Color(0xFFB91C1C) to Color.White
                        isSelected -> BrandGold to Color.White
                        else -> MaterialTheme.colorScheme.surface to MaterialTheme.colorScheme.onSurface
                    }

                    Card(
                        colors = CardDefaults.cardColors(containerColor = containerColor),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(enabled = !isSubmitted) { onSubmitAnswer(idx) }
                            .semantics {
                                role = Role.RadioButton
                                contentDescription = "Pilihan ${idx + 1}: $option"
                            }
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(14.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = option,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 14.sp,
                                color = contentColor
                            )
                            if (isSubmitted && isCorrectOption) {
                                Icon(
                                    imageVector = Icons.Default.CheckCircle,
                                    contentDescription = "Benar",
                                    tint = Color.White,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Explanation & Next Action
            AnimatedVisibility(visible = uiState.isQuizAnswerSubmitted) {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = if (uiState.isDarkTheme) Color(0xFF1E293B) else Color(0xFFF1F5F9),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Text(
                                text = if (isId) "Penjelasan Filosofis:" else "Cultural Explanation:",
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp,
                                color = BrandGold
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = if (isId) currentQ.explanationId else currentQ.explanationEn,
                                fontSize = 13.sp,
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.85f)
                            )
                        }
                    }

                    Button(
                        onClick = onNextQuestion,
                        colors = ButtonDefaults.buttonColors(containerColor = BrandGold),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(
                                text = if (isId) "Soal Berikutnya" else "Next Question",
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                            Icon(
                                imageVector = Icons.Default.ArrowForward,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}

