package id.ac.ub.aksara.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

fun getAksaraTypography(
    dyslexiaMode: Boolean,
    fontScale: Float
): Typography {
    val scale = fontScale.coerceIn(1.0f, 1.4f)
    val letterSpacing = if (dyslexiaMode) 0.07.sp else 0.01.sp
    val lineHeightMultiplier = if (dyslexiaMode) 1.7f else 1.35f

    val bodySize = (15 * scale).sp
    val titleSize = (20 * scale).sp
    val headlineSize = (26 * scale).sp
    val labelSize = (13 * scale).sp

    return Typography(
        headlineMedium = TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = headlineSize,
            lineHeight = headlineSize * lineHeightMultiplier,
            letterSpacing = letterSpacing
        ),
        titleMedium = TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.SemiBold,
            fontSize = titleSize,
            lineHeight = titleSize * lineHeightMultiplier,
            letterSpacing = letterSpacing
        ),
        bodyMedium = TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Normal,
            fontSize = bodySize,
            lineHeight = bodySize * lineHeightMultiplier,
            letterSpacing = letterSpacing
        ),
        labelMedium = TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.SemiBold,
            fontSize = labelSize,
            lineHeight = labelSize * lineHeightMultiplier,
            letterSpacing = letterSpacing
        )
    )
}

