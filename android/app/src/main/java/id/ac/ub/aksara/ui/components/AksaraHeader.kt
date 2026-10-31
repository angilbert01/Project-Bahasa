package id.ac.ub.aksara.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.FormatSize
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.filled.VolumeUp
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.ac.ub.aksara.R
import id.ac.ub.aksara.model.AppLanguage
import id.ac.ub.aksara.model.Dialect
import id.ac.ub.aksara.ui.theme.BrandGold
import id.ac.ub.aksara.ui.theme.BrandNavy
import id.ac.ub.aksara.ui.theme.BrandNavyDark
import id.ac.ub.aksara.ui.theme.BrandPillIvory
import id.ac.ub.aksara.viewmodel.AksaraUiState

@Composable
fun AksaraHeader(
    uiState: AksaraUiState,
    onToggleLanguage: () -> Unit,
    onToggleDyslexia: () -> Unit,
    onCycleFontScale: () -> Unit,
    onToggleDarkTheme: () -> Unit,
    onSelectDialect: (Dialect) -> Unit,
    onStopAudio: () -> Unit
) {
    val mastheadColor = if (uiState.isDarkTheme) BrandNavyDark else BrandNavy

    Surface(
        color = mastheadColor,
        shadowElevation = 0.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            // Upper Bar: Brand Logo & A11y Toolbar
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Official Brand Block Pill (Preserves client artwork on ivory backing)
                Row(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(BrandPillIvory)
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                        .semantics {
                            contentDescription = "Aplikasi AKSARA Universitas Brawijaya"
                            role = Role.Image
                        },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_app_logo),
                        contentDescription = null,
                        modifier = Modifier.height(20.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_app_wordmark),
                        contentDescription = "AKSARA",
                        modifier = Modifier.height(18.dp)
                    )
                }

                // Quick Accessibility Toolbar
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Language Switcher (ID / EN)
                    A11yToolbarButton(
                        text = if (uiState.language == AppLanguage.ID) "ID" else "EN",
                        description = if (uiState.language == AppLanguage.ID) "Ganti ke Bahasa Inggris" else "Switch to Indonesian",
                        isActive = false,
                        onClick = onToggleLanguage
                    )

                    // Dyslexia Mode Toggle (Aa)
                    A11yToolbarButton(
                        text = "Aa",
                        description = if (uiState.isDyslexiaMode) "Nonaktifkan Mode Disleksia" else "Aktifkan Mode Disleksia",
                        isActive = uiState.isDyslexiaMode,
                        onClick = onToggleDyslexia
                    )

                    // Font Size Cycle
                    A11yToolbarButton(
                        text = when (uiState.fontScale) {
                            1.2f -> "A+"
                            1.4f -> "A++"
                            else -> "A"
                        },
                        description = "Ubah ukuran huruf",
                        isActive = uiState.fontScale > 1.0f,
                        onClick = onCycleFontScale
                    )

                    // Dark/Light Theme Toggle
                    Surface(
                        shape = CircleShape,
                        color = Color(0xFF162B47),
                        modifier = Modifier.size(34.dp)
                    ) {
                        IconButton(onClick = onToggleDarkTheme) {
                            Icon(
                                imageVector = if (uiState.isDarkTheme) Icons.Default.LightMode else Icons.Default.DarkMode,
                                contentDescription = if (uiState.isDarkTheme) "Beralih ke Tema Terang" else "Beralih ke Tema Gelap",
                                tint = if (uiState.isDarkTheme) Color(0xFFFDE68A) else Color.White,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Dialect Selector Pills
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (uiState.language == AppLanguage.ID) "Aksara:" else "Script:",
                    style = MaterialTheme.typography.labelMedium,
                    color = Color(0xFF94A3B8),
                    fontSize = 12.sp
                )

                Dialect.values().forEach { dialect ->
                    val isSelected = dialect == uiState.selectedDialect
                    val chipBg = if (isSelected) BrandGold else Color(0xFF162B47)
                    val chipTextColor = if (isSelected) Color.White else Color(0xFFCBD5E1)

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(chipBg)
                            .clickable { onSelectDialect(dialect) }
                            .padding(horizontal = 10.dp, vertical = 6.dp)
                            .semantics {
                                contentDescription = "Pilih aksara ${dialect.title}"
                                role = Role.RadioButton
                            }
                    ) {
                        Text(
                            text = dialect.title,
                            color = chipTextColor,
                            fontSize = 12.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                        )
                    }
                }
            }

            // Audio Reader Live Banner
            AnimatedVisibility(visible = uiState.isSpeaking) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFF1E3A5F),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(
                                imageVector = Icons.Default.VolumeUp,
                                contentDescription = null,
                                tint = BrandGold,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = uiState.spokenText.ifEmpty { "Membacakan teks suara..." },
                                color = Color.White,
                                fontSize = 12.sp,
                                maxLines = 1
                            )
                        }
                        IconButton(
                            onClick = onStopAudio,
                            modifier = Modifier.size(28.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Stop,
                                contentDescription = "Hentikan Suara",
                                tint = Color(0xFFF87171),
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun A11yToolbarButton(
    text: String,
    description: String,
    isActive: Boolean,
    onClick: () -> Unit
) {
    val bgColor = if (isActive) BrandGold else Color(0xFF162B47)
    val textColor = Color.White

    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(bgColor)
            .clickable(onClick = onClick)
            .padding(horizontal = 10.dp, vertical = 6.dp)
            .semantics {
                contentDescription = description
                role = Role.Button
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

