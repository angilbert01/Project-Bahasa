package id.ac.ub.aksara.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.GTranslate
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.SportsEsports
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.ac.ub.aksara.model.AppLanguage
import id.ac.ub.aksara.model.AppScreen
import id.ac.ub.aksara.ui.theme.NavOrange

data class NavItem(
    val screen: AppScreen,
    val icon: ImageVector,
    val labelId: String,
    val labelEn: String
)

@Composable
fun AksaraBottomNav(
    currentScreen: AppScreen,
    language: AppLanguage,
    onNavigate: (AppScreen) -> Unit
) {
    val items = listOf(
        NavItem(AppScreen.HOME, Icons.Default.Home, "Beranda", "Home"),
        NavItem(AppScreen.DICTIONARY, Icons.Default.Book, "Kamus", "Dictionary"),
        NavItem(AppScreen.TRANSLATE, Icons.Default.GTranslate, "Translate", "Translate"),
        NavItem(AppScreen.GAME, Icons.Default.SportsEsports, "Game", "Game")
    )

    Surface(
        color = NavOrange,
        shadowElevation = 0.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEach { item ->
                val isSelected = currentScreen == item.screen
                val label = if (language == AppLanguage.ID) item.labelId else item.labelEn
                val activeBg = if (isSelected) Color(0x33000000) else Color.Transparent
                val contentColor = if (isSelected) Color(0xFF0F172A) else Color(0xFF334155)

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(12.dp))
                        .background(activeBg)
                        .clickable { onNavigate(item.screen) }
                        .padding(vertical = 6.dp)
                        .semantics {
                            selected = isSelected
                            role = Role.Tab
                            contentDescription = "Navigasi ke $label"
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = null,
                            tint = contentColor,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = label,
                            color = contentColor,
                            fontSize = 11.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}

