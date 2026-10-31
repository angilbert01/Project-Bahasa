package id.ac.ub.aksara.ui.screens

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import id.ac.ub.aksara.model.AppLanguage
import id.ac.ub.aksara.model.VocabEntry
import id.ac.ub.aksara.ui.theme.BadgeCasualFillDark
import id.ac.ub.aksara.ui.theme.BadgeCasualFillLight
import id.ac.ub.aksara.ui.theme.BadgeCasualInkDark
import id.ac.ub.aksara.ui.theme.BadgeCasualInkLight
import id.ac.ub.aksara.ui.theme.BadgeFormalFillDark
import id.ac.ub.aksara.ui.theme.BadgeFormalFillLight
import id.ac.ub.aksara.ui.theme.BadgeFormalInkDark
import id.ac.ub.aksara.ui.theme.BadgeFormalInkLight
import id.ac.ub.aksara.ui.theme.BrandGold
import id.ac.ub.aksara.viewmodel.AksaraUiState

@Composable
fun DictionaryScreen(
    uiState: AksaraUiState,
    filteredVocab: List<VocabEntry>,
    onSearchChange: (String) -> Unit,
    onCategoryChange: (String) -> Unit,
    onSpeak: (String) -> Unit
) {
    val isId = uiState.language == AppLanguage.ID
    val categories = if (isId) listOf("Semua", "Sopan Santun", "Sehari-hari") else listOf("All", "Sopan Santun", "Sehari-hari")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = if (isId) "Kamus Basa ${uiState.selectedDialect.title}" else "${uiState.selectedDialect.title} Dictionary",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.semantics { heading() }
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = if (isId) "Kosa kata adat, tingkatan tutur, dan unggah-ungguh resmi." else "Traditional vocabulary, formality registers, and etiquette.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
            fontSize = 13.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Search Bar
        OutlinedTextField(
            value = uiState.dictSearchQuery,
            onValueChange = onSearchChange,
            placeholder = {
                Text(if (isId) "Cari kata atau arti..." else "Search word or meaning...")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = null, tint = BrandGold)
            },
            trailingIcon = {
                if (uiState.dictSearchQuery.isNotEmpty()) {
                    IconButton(onClick = { onSearchChange("") }) {
                        Icon(imageVector = Icons.Default.Clear, contentDescription = "Hapus pencarian")
                    }
                }
            },
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .semantics {
                    contentDescription = if (isId) "Kolom pencarian kamus" else "Dictionary search box"
                }
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Category Filter Chips
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(categories) { category ->
                val isSelected = (category == "All" && uiState.selectedCategory == "Semua") || category == uiState.selectedCategory
                val chipBg = if (isSelected) BrandGold else if (uiState.isDarkTheme) Color(0xFF1E293B) else Color(0xFFE2E8F0)
                val chipTextColor = if (isSelected) Color.White else MaterialTheme.colorScheme.onBackground

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(chipBg)
                        .clickable {
                            val targetCat = if (category == "All") "Semua" else category
                            onCategoryChange(targetCat)
                        }
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                        .semantics {
                            role = Role.Tab
                            contentDescription = "Filter kategori $category"
                        }
                ) {
                    Text(
                        text = category,
                        color = chipTextColor,
                        fontSize = 12.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Results List
        if (filteredVocab.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = if (isId) "Tidak ada kosa kata yang cocok." else "No vocabulary entries matched.",
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
                    fontSize = 14.sp
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(filteredVocab) { item ->
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        ),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        text = item.word,
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(6.dp))
                                            .background(if (uiState.isDarkTheme) BadgeFormalFillDark else BadgeFormalFillLight)
                                            .padding(horizontal = 6.dp, vertical = 2.dp)
                                    ) {
                                        Text(
                                            text = item.register,
                                            color = if (uiState.isDarkTheme) BadgeFormalInkDark else BadgeFormalInkLight,
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                }

                                IconButton(
                                    onClick = {
                                        val text = "${item.word}. Artinya: ${if (isId) item.meaningId else item.meaningEn}"
                                        onSpeak(text)
                                    },
                                    modifier = Modifier.size(30.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.VolumeUp,
                                        contentDescription = "Dengarkan arti ${item.word}",
                                        tint = BrandGold,
                                        modifier = Modifier.size(18.dp)
                                    )
                                }
                            }

                            if (item.script.isNotBlank()) {
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = item.script,
                                    fontSize = 16.sp,
                                    color = BrandGold
                                )
                            }

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = if (isId) item.meaningId else item.meaningEn,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.85f),
                                fontSize = 13.sp
                            )

                            if (item.example.isNotBlank()) {
                                Spacer(modifier = Modifier.height(6.dp))
                                Surface(
                                    color = if (uiState.isDarkTheme) Color(0xFF1E293B) else Color(0xFFF8FAFC),
                                    shape = RoundedCornerShape(6.dp),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        text = "Contoh: \"${item.example}\"",
                                        fontSize = 11.sp,
                                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                    )
                                }
                            }
                        }
                    }
                }
                item { Spacer(modifier = Modifier.height(16.dp)) }
            }
        }
    }
}

