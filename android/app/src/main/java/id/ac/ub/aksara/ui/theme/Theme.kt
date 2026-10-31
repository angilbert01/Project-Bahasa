package id.ac.ub.aksara.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = BrandGoldLight,
    onPrimary = CanvasDark,
    secondary = NavOrange,
    background = CanvasDark,
    surface = SurfaceDark,
    onBackground = InkPrimaryDark,
    onSurface = InkPrimaryDark
)

private val LightColorScheme = lightColorScheme(
    primary = BrandNavy,
    onPrimary = SurfaceLight,
    secondary = BrandGold,
    background = CanvasLight,
    surface = SurfaceLight,
    onBackground = InkPrimaryLight,
    onSurface = InkPrimaryLight
)

@Composable
fun AksaraTheme(
    darkTheme: Boolean = false,
    dyslexiaMode: Boolean = false,
    fontScale: Float = 1.0f,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as? Activity)?.window
            if (window != null) {
                window.statusBarColor = BrandNavy.toArgb()
                window.navigationBarColor = NavOrange.toArgb()
                val insetsController = WindowCompat.getInsetsController(window, view)
                insetsController.isAppearanceLightStatusBars = false
                insetsController.isAppearanceLightNavigationBars = false
            }
        }
    }

    val typography = getAksaraTypography(dyslexiaMode, fontScale)

    MaterialTheme(
        colorScheme = colorScheme,
        typography = typography,
        content = content
    )
}

