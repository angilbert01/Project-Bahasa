package id.ac.ub.aksara.ui.screens

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.ac.ub.aksara.model.AppLanguage
import id.ac.ub.aksara.ui.theme.BrandGold
import id.ac.ub.aksara.ui.theme.BrandNavy
import id.ac.ub.aksara.viewmodel.AksaraUiState

@Composable
fun TranslateScreen(
    uiState: AksaraUiState,
    onInputChange: (String) -> Unit,
    onSpeak: (String) -> Unit
) {
    val context = LocalContext.current
    val isId = uiState.language == AppLanguage.ID
    val quickPrompts = listOf(
        "Terima kasih banyak",
        "Permisi mau bertanya",
        "Mari makan bersama",
        "Selamat pagi semuanya"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = if (isId) "Penerjemah Unggah-Ungguh" else "Polite Dialect Translator",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.semantics { heading() }
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = if (isId) {
                "Menerjemahkan teks dengan penyesuaian tata krama santun ${uiState.selectedDialect.title}."
            } else {
                "Translate into respectful ${uiState.selectedDialect.title} dialect registers."
            },
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
            fontSize = 13.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Language Exchange Header
        Card(
            colors = CardDefaults.cardColors(
                containerColor = if (uiState.isDarkTheme) Color(0xFF1E293B) else Color(0xFFF1F5F9)
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Bahasa Indonesia",
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Icon(
                    imageVector = Icons.Default.SwapHoriz,
                    contentDescription = null,
                    tint = BrandGold
                )
                Text(
                    text = "Basa ${uiState.selectedDialect.title}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    color = BrandGold
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Source Input Box
        OutlinedTextField(
            value = uiState.translateInput,
            onValueChange = onInputChange,
            placeholder = {
                Text(if (isId) "Ketik kalimat yang ingin diterjemahkan..." else "Type sentence to translate...")
            },
            trailingIcon = {
                if (uiState.translateInput.isNotEmpty()) {
                    IconButton(onClick = { onInputChange("") }) {
                        Icon(imageVector = Icons.Default.Clear, contentDescription = "Bersihkan teks")
                    }
                }
            },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .semantics {
                    contentDescription = if (isId) "Kolom input terjemahan" else "Translation input field"
                }
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Quick Suggestion Chips
        Text(
            text = if (isId) "Saran Percakapan:" else "Suggested Phrases:",
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(6.dp))

        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(quickPrompts) { prompt ->
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(if (uiState.isDarkTheme) Color(0xFF1E293B) else Color(0xFFE2E8F0))
                        .clickable { onInputChange(prompt) }
                        .padding(horizontal = 10.dp, vertical = 6.dp)
                        .semantics {
                            role = Role.Button
                            contentDescription = "Pilih frasa: $prompt"
                        }
                ) {
                    Text(
                        text = prompt,
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurface,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        // Translation Result Card
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            shape = RoundedCornerShape(14.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = if (isId) "Hasil Terjemahan Santun:" else "Polite Translation:",
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = BrandGold
                    )

                    Row {
                        IconButton(
                            onClick = {
                                if (uiState.translateResult.isNotBlank()) {
                                    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                                    val clip = ClipData.newPlainText("Terjemahan Aksara", uiState.translateResult)
                                    clipboard.setPrimaryClip(clip)
                                    Toast.makeText(context, "Teks terjemahan disalin", Toast.LENGTH_SHORT).show()
                                }
                            },
                            enabled = uiState.translateResult.isNotBlank(),
                            modifier = Modifier.size(30.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.ContentCopy,
                                contentDescription = "Salin hasil terjemahan",
                                tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                                modifier = Modifier.size(16.dp)
                            )
                        }

                        IconButton(
                            onClick = {
                                if (uiState.translateResult.isNotBlank()) {
                                    onSpeak(uiState.translateResult)
                                }
                            },
                            enabled = uiState.translateResult.isNotBlank(),
                            modifier = Modifier.size(30.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.VolumeUp,
                                contentDescription = "Dengarkan hasil terjemahan",
                                tint = BrandGold,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = if (uiState.translateResult.isNotBlank()) {
                        uiState.translateResult
                    } else {
                        if (isId) "Hasil terjemahan akan tampil di sini..." else "Translation will appear here..."
                    },
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 15.sp,
                    color = if (uiState.translateResult.isNotBlank()) {
                        MaterialTheme.colorScheme.onSurface
                    } else {
                        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f)
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}

