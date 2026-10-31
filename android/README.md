# AKSARA - Jetpack Compose Native Mobile App
**Aplikasi Pelestarian Bahasa Daerah Inklusif (UB & PSLD)**

Implementasi native mobile menggunakan **Android Jetpack Compose**, **Material 3**, dan **WCAG 2.1 AAA Accessibility**. Dirancang khusus untuk kemudahan navigasi bagi penyandang **Disabilitas Netra** (TalkBack & Natural TTS) dan **Disleksia** (Tipografi Dinamis & Spasi Adaptif).

---

## 🚀 Cara Menjalankan Proyek di Android Studio

1. Buka **Android Studio** (Flamingo / Hedgehog / Iguana / Jellyfish / Koala / Ladybug atau versi terbaru).
2. Pilih **File > Open**, lalu arahkan ke folder `android/` di direktori ini.
3. Tunggu proses **Gradle Sync** selesai secara otomatis.
4. Pilih target perangkat (**Android Emulator** atau **HP Android via USB Debugging**).
5. Klik tombol **Run 'app'** (`Shift + F10`).

---

## 🛠️ Spesifikasi Teknologi Mobile

- **Bahasa**: Kotlin (1.9.24+)
- **UI Toolkit**: Jetpack Compose (BOM 2024.06.00) + Material 3
- **Kompatibilitas**:
  - `minSdk`: 24 (Android 7.0 Nougat ke atas)
  - `targetSdk`: 34 (Android 14)
  - `compileSdk`: 34
  - `Java Target`: JVM 17
- **Arsitektur**: MVVM (Model-View-ViewModel) dengan Kotlin Coroutines & StateFlow.

---

## ♿ Fitur Aksesibilitas Khusus (Disabilitas Netra & Disleksia)

1. **Aset Resmi Klien & Kontras Visual Tinggi**:
   - Monogram logo resmi (`ic_app_logo.png`) dan kaligrafi wordmark (`ic_app_wordmark.png`) terintegrasi pada pill kontras gading (`#FFFDF5`), menjamin visual tidak pudar pada tema terang maupun gelap.
2. **Natural Text-To-Speech (TtsManager)**:
   - Pembaca suara terintegrasi dengan sintesis audio percakapan alami (anti-bot) serta getaran haptik (`VibrationEffect`) saat tombol ditekan.
3. **Mode Disleksia Dinamis (`Aa`)**:
   - Memperlebar *letter spacing* (`0.07.sp`) dan *line height* (`1.7x`) secara realtime di seluruh komponen Compose.
4. **Perbesaran Font Bertingkat (`A / A+ / A++`)**:
   - Skalabilitas teks responsif dari 100%, 120%, hingga 140% tanpa merusak layout (*no text clipping*).
5. **Mode Gelap / Terang Adaptif**:
   - Beralih instan dengan palet warna resmi Brawijaya Navy (`#0C2340`), Saffron Gold (`#B45309`), dan footer navigasi Oranye Terang (`#FFA500`).

---

## 📱 Struktur Direktori Native

```text
android/
├── app/
│   ├── src/main/
│   │   ├── AndroidManifest.xml
│   │   ├── java/id/ac/ub/aksara/
│   │   │   ├── MainActivity.kt
│   │   │   ├── model/
│   │   │   │   └── AksaraData.kt        (Data regional: Jawa, Sunda, Madura, Bali)
│   │   │   ├── viewmodel/
│   │   │   │   └── AksaraViewModel.kt   (StateFlow, TTS, filter, i18n)
│   │   │   ├── util/
│   │   │   │   └── TtsManager.kt        (TextToSpeech & Haptic Engine)
│   │   │   └── ui/
│   │   │       ├── theme/               (Color, Type, Theme Compose)
│   │   │       ├── components/          (AksaraHeader, AksaraBottomNav)
│   │   │       └── screens/             (HomeScreen, DictionaryScreen, TranslateScreen, GameScreen)
│   │   └── res/
│   │       ├── drawable/                (ic_app_logo, ic_app_wordmark, bg)
│   │       └── values/                  (strings, colors, themes)
│   └── build.gradle.kts
├── settings.gradle.kts
├── build.gradle.kts
└── gradle.properties
```

