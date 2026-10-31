package id.ac.ub.aksara.ui.screens

import android.content.Intent
import android.net.Uri
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Hearing
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import id.ac.ub.aksara.model.AksaraRepository
import id.ac.ub.aksara.model.AppLanguage
import id.ac.ub.aksara.ui.theme.BadgeFormalFillDark
import id.ac.ub.aksara.ui.theme.BadgeFormalFillLight
import id.ac.ub.aksara.ui.theme.BadgeFormalInkDark
import id.ac.ub.aksara.ui.theme.BadgeFormalInkLight
import id.ac.ub.aksara.ui.theme.BrandGold
import id.ac.ub.aksara.ui.theme.BrandNavy
import id.ac.ub.aksara.viewmodel.AksaraUiState

@Composable
fun HomeScreen(
    uiState: AksaraUiState,
    onSpeak: (String) -> Unit
) {
    val context = LocalContext.current
    val isId = uiState.language == AppLanguage.ID
    val currentGlyphs = AksaraRepository.glyphs.filter { it.dialect == uiState.selectedDialect }
    val currentPhrases = AksaraRepository.phrases.filter { it.dialect == uiState.selectedDialect }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item { Spacer(modifier = Modifier.height(8.dp)) }

        // Hero Greeting Card
        item {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = if (uiState.isDarkTheme) Color(0xFF132238) else Color(0xFF0C2340)
                ),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .background(BrandGold)
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                        ) {
                            Text(
                                text = "INKLUSIF & DISLEKSIA",
                                color = Color.White,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        IconButton(
                            onClick = {
                                val textToRead = if (isId) {
                                    "Selamat datang di Aksara Brawijaya. Pelestarian bahasa ${uiState.selectedDialect.title} ramah disabilitas netra dan disleksia."
                                } else {
                                    "Welcome to Aksara Brawijaya. Inclusive preservation of ${uiState.selectedDialect.title} dialect for blind and dyslexic users."
                                }
                                onSpeak(textToRead)
                            },
                            modifier = Modifier.size(36.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Hearing,
                                contentDescription = if (isId) "Bacakan pengantar" else "Read introduction",
                                tint = Color(0xFFFDE68A)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = if (isId) "Sinau Aksara ${uiState.selectedDialect.title}" else "Learn ${uiState.selectedDialect.title} Script",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.semantics { heading() }
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = if (isId) {
                            "Dukungan pembaca suara alami (Anti-Bot), kontras visual tinggi, dan tipografi ramah disleksia."
                        } else {
                            "Natural speech feedback (Anti-Bot), high contrast visual canvas, and dyslexic-friendly spacing."
                        },
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(0xFFCBD5E1),
                        fontSize = 13.sp
                    )
                }
            }
        }

        // Section 1: Interactive Flashcards
        item {
            Text(
                text = if (isId) "Kartu Aksara Dasar" else "Core Script Flashcards",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.semantics { heading() }
            )
        }

        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(currentGlyphs) { glyph ->
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        ),
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier
                            .width(130.dp)
                            .clickable {
                                val desc = if (isId) glyph.descId else glyph.descEn
                                onSpeak("${glyph.latin}. ${desc}")
                            }
                            .semantics {
                                contentDescription = "Aksara ${glyph.latin}. Ketuk untuk mendengarkan pelafalan."
                                role = Role.Button
                            }
                    ) {
                        Column(
                            modifier = Modifier.padding(14.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = glyph.char,
                                fontSize = 36.sp,
                                fontWeight = FontWeight.Bold,
                                color = BrandGold
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = glyph.latin,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.VolumeUp,
                                    contentDescription = null,
                                    tint = BrandGold,
                                    modifier = Modifier.size(14.dp)
                                )
                                Text(
                                    text = if (isId) "Suara" else "Listen",
                                    fontSize = 11.sp,
                                    color = BrandGold,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                        }
                    }
                }
            }
        }

        // Section 2: Cultural Phrases & Etiquette
        item {
            Text(
                text = if (isId) "Ungkapan Budaya & Unggah-Ungguh" else "Cultural Expressions & Etiquette",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.semantics { heading() }
            )
        }

        items(currentPhrases) { phrase ->
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
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .background(if (uiState.isDarkTheme) BadgeFormalFillDark else BadgeFormalFillLight)
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                        ) {
                            Text(
                                text = phrase.register,
                                color = if (uiState.isDarkTheme) BadgeFormalInkDark else BadgeFormalInkLight,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        IconButton(
                            onClick = {
                                val spoken = "${phrase.phrase}. ${if (isId) phrase.translationId else phrase.translationEn}"
                                onSpeak(spoken)
                            },
                            modifier = Modifier.size(32.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.VolumeUp,
                                contentDescription = if (isId) "Dengarkan pelafalan" else "Listen pronunciation",
                                tint = BrandGold,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = phrase.phrase,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    if (phrase.script.isNotBlank()) {
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = phrase.script,
                            fontSize = 18.sp,
                            color = BrandGold
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = if (isId) phrase.translationId else phrase.translationEn,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Surface(
                        color = if (uiState.isDarkTheme) Color(0xFF1E293B) else Color(0xFFF1F5F9),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = if (isId) "Etika: ${phrase.etikaId}" else "Etiquette: ${phrase.etikaEn}",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                        )
                    }
                }
            }
        }

        // Section 3: UB Enablink Accessibility Portal
        item {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = if (uiState.isDarkTheme) Color(0xFF1A2638) else Color(0xFF0C2340)
                ),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "UNIVERSITAS BRAWIJAYA & PSLD",
                        color = BrandGold,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = if (isId) "Layanan Disabilitas Enablink UB" else "UB Enablink Disability Service",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = if (isId) {
                            "Pusat Studi dan Layanan Disabilitas UB mendukung inklusivitas pendidikan dan pelestarian bahasa daerah nusantara."
                        } else {
                            "Center for Disability Studies and Services (PSLD UB) supports educational inclusivity and regional heritage preservation."
                        },
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(0xFFCBD5E1),
                        fontSize = 12.sp
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Button(
                        onClick = {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://enablink.ub.ac.id"))
                            context.startActivity(intent)
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = BrandGold),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(
                                text = "Kunjungi enablink.ub.ac.id",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp
                            )
                            Icon(
                                imageVector = Icons.Default.OpenInNew,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(14.dp)
                            )
                        }
                    }
                }
            }
        }

        item { Spacer(modifier = Modifier.height(16.dp)) }
    }
}

