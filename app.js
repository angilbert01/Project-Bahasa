/**
 * AKSARA MOBILE - APPLICATION ENGINE
 * Art Direction: The Page is the Object (Nusantara Manuscript Codex)
 * Standard: taste-skill v2 + WCAG 2.1 AAA Inclusivity
 * Features:
 * - Pure SVG UI Icons (No raw emojis)
 * - Complete Reactive Bilingual Toggle (ID / EN)
 * - Natural Human Voice Screen Reader Announcer (Anti-Bot)
 * - Web Speech API (TTS) & Web Audio Synthesizer (Acoustic Chimes)
 * - Dialects: Jawa (Ngoko & Kromo Inggil), Sunda, Batak, Bali, Melayu
 * - Interactive Dictionary, Translator Simulator, & Cultural Quiz
 */

// =====================================================================
// DATA: I18N DICTIONARY & MULTI-DIALECT CORPUS
// =====================================================================

const I18N = {
  id: {
    brandTitle: "AKSARA",
    brandSub: "Universitas Brawijaya",
    langTag: "ID",
    langLabel: "Ganti bahasa aplikasi. Saat ini: Bahasa Indonesia",
    lblDialect: "Bahasa Daerah",
    btnListen: "Dengar",
    readScreenSR: "Bacakan seluruh isi layar saat ini dengan suara alami",

    // Navigation
    navMateri: "Beranda",
    navKamus: "Kamus",
    navTerjemah: "Translate",
    navGame: "Game",
    navEnablink: "Enablink",

    // Panel 1: Materi
    homeTitle: "Sugeng Rawuh di AKSARA",
    homeDesc: "Ruang pelestarian bahasa daerah berkeadilan akses bagi mahasiswa Universitas Brawijaya dan masyarakat digital.",
    a11yTitle: "Aksesibilitas Aktif",
    a11yDesc: "Sesuai standar WCAG AAA, font ramah disleksia Lexend, pembaca layar ramah manusia, serta tata letak tanpa silau.",
    titleRegisters: "Tingkatan Bahasa & Etika Tutur",
    titleScripts: "Aksara Tradisional Nusantara",
    titlePhrases: "Frasa Percakapan Mahasiswa UB",
    pillCasual: "Santai (Rekan Sebaya)",
    pillFormal: "Sopan (Dosen & Orang Tua)",
    lblMean: "Arti:",
    lblCtx: "Konteks:",
    valMean1: "Saya makan nasi di warung kampus",
    valCtx1: "Digunakan untuk percakapan akrab dengan teman kuliah seangkatan.",
    valMean2: "Saya makan nasi di kantin kampus (Ragam Halus)",
    valCtx2: "Wajib digunakan saat menyapa dosen, staf kampus, atau orang yang dihormati.",

    // Panel 2: Kamus
    kamusTitle: "Kamus Kosa Kata Daerah",
    kamusDesc: "Pencarian kosa kata antardialek dilengkapi perbandingan ragam sopan dan ragam santai.",
    dictPlaceholder: "Cari kata: makan, belajar, buku...",
    tagAll: "Semua",
    tagCampus: "Kampus & Kuliah",
    tagFood: "Makanan",
    tagGreet: "Salam & Sapaan",
    lblFormalReg: "Sopan (Kromo/Halus):",
    lblCasualReg: "Santai (Ngoko/Loma):",
    lblExample: "Contoh:",
    btnListenWord: "Dengar Suara",

    // Panel 3: Terjemah
    transTitle: "Simulator Terjemahan Dialek",
    transDesc: "Penerjemahan kalimat praktis ke dalam ragam santun kromo dan ragam akrab ngoko.",
    lblTransInput: "Kalimat Asal",
    transPlaceholder: "Contoh: Permisi bapak dosen, saya ingin bertanya materi...",
    lblPreset: "Pilihan cepat:",
    preset1: "Permisi bapak dosen, saya ingin bertanya materi",
    preset2: "Ayo kita ke kantin makan siang bersama",
    preset3: "Terima kasih banyak atas bantuan dan bimbingannya",
    btnTranslateText: "Terjemahkan Kalimat",
    lblTransResults: "Hasil Terjemahan",
    pillResFormal: "Ragam Sopan (Kromo / Lemes)",
    pillResCasual: "Ragam Santai (Ngoko / Loma)",

    // Panel 4: Game / Quiz
    gameTitle: "Kuis Kebudayaan & Etika",
    gameDesc: "Uji pemahaman santun berbahasa dengan umpan balik sensorik getar dan nada sintetis.",
    scoreText: "Skor:",
    counterPattern: "Pertanyaan {curr} dari {total}",
    btnReadPrompt: "Dengarkan Pertanyaan",
    btnNextQ: "Pertanyaan Berikutnya",
    quizCorrect: "Tepat Sekali!",
    quizIncorrect: "Kurang Tepat.",

    // Panel 5: Enablink UB & Settings
    enablinkTitle: "Enablink UB & Inklusi",
    enablinkDesc: "Integrasi ekosistem pendidikan inklusif Universitas Brawijaya bersama PSLD UB.",
    ubNarrative: "Pelopor pendidikan tinggi inklusif di Indonesia. Melalui inovasi AKSARA, kampus Brawijaya menjembatani pelestarian bahasa ibu bagi mahasiswa perantau nusantara tanpa batasan fisik maupun kognitif.",
    titlePreferences: "Preferensi Sensorik & Tampilan",
    lblPrefDark: "Mode Tema Gelap (Dark Theme)",
    subPrefDark: "Mengaktifkan kanvas malam berornamen batik gelap untuk kenyamanan mata di ruangan redup.",
    lblPrefDyslexia: "Mode Ramah Disleksia",
    subPrefDyslexia: "Menggunakan jenis huruf Lexend dengan bobot bawah stabil, spasi longgar, dan tata letak rata kiri.",
    lblPrefFontSize: "Ukuran Huruf Teks",
    subPrefFontSize: "Perbesar teks hingga 140% untuk mempermudah kenyamanan membaca.",
    fontScaleNormal: "Normal (100%)",
    fontScaleLarge: "Besar (120%)",
    fontScaleXLarge: "Sangat Besar (140%)",
    lblPrefHaptic: "Umpan Balik Sensorik & Suara",
    subPrefHaptic: "Menghasilkan nada sintetis dan getaran lembut pada aksi navigasi dan kuis.",
    lblPrefSpeed: "Kecepatan Pembaca Suara (TTS)",
    titleCitation: "Dasar Karya Ilmiah",

    // Audio status
    audioBannerReading: "Membacakan teks suara...",
    btnStopAudio: "Berhenti",
    srReady: "Aplikasi Aksara siap digunakan. Bahasa antarmuka: Bahasa Indonesia."
  },

  en: {
    brandTitle: "AKSARA",
    brandSub: "Brawijaya University",
    langTag: "EN",
    langLabel: "Switch application language. Currently: English",
    lblDialect: "Regional Dialect",
    btnListen: "Listen",
    readScreenSR: "Read entire screen content aloud with natural voice",

    // Navigation
    navMateri: "Home",
    navKamus: "Dictionary",
    navTerjemah: "Translate",
    navGame: "Game",
    navEnablink: "Enablink",

    // Panel 1: Materi
    homeTitle: "Welcome to AKSARA",
    homeDesc: "Equitable indigenous language preservation space for Brawijaya University students and digital citizens.",
    a11yTitle: "Accessibility Active",
    a11yDesc: "WCAG AAA compliant, Lexend dyslexia font, human-centered screen reader announcements, and glare-free surfaces.",
    titleRegisters: "Speech Levels & Politeness Etiquette",
    titleScripts: "Nusantara Traditional Scripts",
    titlePhrases: "Practical Phrases for UB Students",
    pillCasual: "Informal (Campus Peers)",
    pillFormal: "Polite (Faculty & Elders)",
    lblMean: "Meaning:",
    lblCtx: "Context:",
    valMean1: "I eat rice at the campus food stall (Casual)",
    valCtx1: "Used for relaxed conversations among college classmates.",
    valMean2: "I dine on rice in the campus dining hall (Polite)",
    valCtx2: "Mandatory when speaking to professors, campus staff, or respected figures.",

    // Panel 2: Kamus
    kamusTitle: "Regional Vocabulary Dictionary",
    kamusDesc: "Cross-dialect vocabulary search featuring polite vs casual register comparisons.",
    dictPlaceholder: "Search word: eat, study, book...",
    tagAll: "All",
    tagCampus: "Campus & Study",
    tagFood: "Food & Dining",
    tagGreet: "Greetings",
    lblFormalReg: "Polite Register:",
    lblCasualReg: "Casual Register:",
    lblExample: "Example:",
    btnListenWord: "Listen",

    // Panel 3: Terjemah
    transTitle: "Dialect Translation Simulator",
    transDesc: "Translates practical sentences into respectful formal and friendly informal registers.",
    lblTransInput: "Source Sentence",
    transPlaceholder: "Example: Excuse me professor, I would like to ask about the lecture...",
    lblPreset: "Quick phrases:",
    preset1: "Excuse me professor, I would like to ask about the lecture",
    preset2: "Let us go to the cafeteria to have lunch together",
    preset3: "Thank you very much for your kind help and mentorship",
    btnTranslateText: "Translate Sentence",
    lblTransResults: "Translation Results",
    pillResFormal: "Polite Register (Kromo / Lemes)",
    pillResCasual: "Informal Register (Ngoko / Loma)",

    // Panel 4: Game / Quiz
    gameTitle: "Cultural & Etiquette Quiz",
    gameDesc: "Test language politeness etiquette with sensory vibration and synthesized tone feedback.",
    scoreText: "Score:",
    counterPattern: "Question {curr} of {total}",
    btnReadPrompt: "Listen to Question",
    btnNextQ: "Next Question",
    quizCorrect: "Exactly Right!",
    quizIncorrect: "Not Quite Right.",

    // Panel 5: Enablink UB & Settings
    enablinkTitle: "Enablink UB & Inclusion",
    enablinkDesc: "Official inclusive education ecosystem of Brawijaya University with PSLD UB.",
    ubNarrative: "Pioneering inclusive higher education in Indonesia. Through AKSARA, Brawijaya University bridges mother tongue preservation for out-of-town students without physical or cognitive barriers.",
    titlePreferences: "Sensory & Display Preferences",
    lblPrefDark: "Dark Theme Mode",
    subPrefDark: "Activates night canvas with dark batik motif for low-light visual comfort.",
    lblPrefDyslexia: "Dyslexia-Friendly Mode",
    subPrefDyslexia: "Uses bottom-weighted Lexend typography, open tracking, and ragged-right alignment.",
    lblPrefFontSize: "Text Font Size",
    subPrefFontSize: "Enlarge text up to 140% for visual comfort.",
    fontScaleNormal: "Normal (100%)",
    fontScaleLarge: "Large (120%)",
    fontScaleXLarge: "Extra Large (140%)",
    lblPrefHaptic: "Sensory Sound & Haptic Feedback",
    subPrefHaptic: "Produces synthesized tones and soft vibration on navigation and quiz actions.",
    lblPrefSpeed: "Text-to-Speech Speed Rate",
    titleCitation: "Academic Source Credit",

    // Audio status
    audioBannerReading: "Reading text aloud...",
    btnStopAudio: "Stop",
    srReady: "Aksara application ready. Interface language: English."
  }
};

// Dialect Corpus: Jawa, Sunda, Batak, Bali, Melayu
const DIALECT_DATA = {
  jawa: {
    name: "Jawa",
    phrases: [
      {
        id: "Sugeng enjang, nyuwun sewu bapak dosen",
        en: "Good morning, excuse me professor",
        local: "Sugeng enjang, nyuwun sewu bapak dosen",
        noteId: "Disampaikan saat menyapa dosen pagi hari di kampus UB",
        noteEn: "Used when greeting professors in the morning at UB campus"
      },
      {
        id: "Ayo sinau bareng neng perpustakaan pusat",
        en: "Let's study together at the central library",
        local: "Ayo sinau bareng neng perpustakaan pusat",
        noteId: "Frasa ajakan santai antar sesama mahasiswa",
        noteEn: "Casual invitation phrase between college classmates"
      },
      {
        id: "Matur nuwun sanget kagem bimbinganipun",
        en: "Thank you very much for your guidance",
        local: "Matur nuwun sanget kagem bimbinganipun",
        noteId: "Ungkapan terima kasih sopan setelah konsultasi tugas akhir",
        noteEn: "Polite gratitude expression after thesis consultation"
      }
    ],
    scripts: [
      { char: "ꦲ", name: "Ha", descId: "Hana caraka (Ada utusan)", descEn: "Hana caraka (There were messengers)" },
      { char: "ꦤ", name: "Na", descId: "Keteguhan niat suci", descEn: "Steadfastness of pure intentions" },
      { char: "ꦕ", name: "Ca", descId: "Cipta rasa dan karsa", descEn: "Creation of thought and will" },
      { char: "ꦫ", name: "Ra", descId: "Rasa welas asih", descEn: "Deep compassion and empathy" }
    ],
    translations: {
      dosen: {
        formal: "Nyuwun sewu bapak dosen, kula badhe nyuwun pirsa babagan materi kuliah punika.",
        casual: "Nyuwun sewu pak, aku arep takon babagan materi kuliah iki.",
        noteFormalId: "Sangat direkomendasikan saat berinteraksi dengan dosen UB atau orang lebih tua.",
        noteFormalEn: "Highly recommended when communicating with UB professors or elders.",
        noteCasualId: "Gunakan ketika berdiskusi santai dengan sesama mahasiswa Brawijaya.",
        noteCasualEn: "Use when chatting informally with fellow Brawijaya students."
      },
      kantin: {
        formal: "Kula badhe tindak dhateng kantin, punapa panjenengan kersa dhahar sesarengan?",
        casual: "Ayo mangan bareng nang kantin UB rek!",
        noteFormalId: "Gaya bicara santun mengajak orang yang dihormati.",
        noteFormalEn: "Polite manner of inviting a respected person.",
        noteCasualId: "Gaya khas arek Malang (dialek Malangan dengan sapaan 'rek').",
        noteCasualEn: "Signature Malang dialect with the familiar address 'rek'."
      },
      terimakasih: {
        formal: "Matur nuwun sanget awit sedaya pambiyantu panjenengan.",
        casual: "Suwun yo rek wis dibantu!",
        noteFormalId: "Ungkapan apresiasi formal dan santun.",
        noteFormalEn: "Formal and courteous token of appreciation.",
        noteCasualId: "Ungkapan santai khas pergaulan anak muda Malang.",
        noteCasualEn: "Casual expression common among Malang students."
      }
    },
    quiz: [
      {
        qId: "Kamu ingin menyapa dosen di Gedung Rektorat UB. Kalimat manakah yang paling santun dan tepat?",
        qEn: "You want to greet a professor at the UB Rectorate building. Which sentence is the most polite and appropriate?",
        options: [
          { text: "Sugeng enjang bapak, nyuwun sewu badhe nyuwun pirsa.", correct: true },
          { text: "Halo pak, aku arep takon dong.", correct: false },
          { text: "Bapak mangan opo saiki?", correct: false },
          { text: "He pak, nyileh pulpenmu sek.", correct: false }
        ],
        explanationId: "Tepat sekali! 'Sugeng enjang' dan 'nyuwun sewu' adalah ragam Kromo Inggil yang sangat santun untuk berbicara dengan dosen.",
        explanationEn: "Correct! 'Sugeng enjang' and 'nyuwun sewu' belong to the polite Kromo Inggil register appropriate for addressing professors."
      },
      {
        qId: "Di Malang, mahasiswa sering menambahkan kata sapaan akrab di akhir kalimat, yaitu...",
        qEn: "In Malang, students often add a friendly familiar address particle at the end of sentences, which is...",
        options: [
          { text: "Rek (misal: 'Ayo mangan rek!')", correct: true },
          { text: "Euy (misal: 'Hayu euy!')", correct: false },
          { text: "Bole (misal: 'Ayo bole!')", correct: false },
          { text: "Loh (misal: 'Iya loh!')", correct: false }
        ],
        explanationId: "Benar! 'Rek' adalah partikel khas Arek Jawa Timur / Malang yang melambangkan kehangatan persaudaraan.",
        explanationEn: "Correct! 'Rek' is the signature East Javanese / Malang term expressing peer warmth."
      },
      {
        qId: "Bagaimana cara mengatakan 'Saya sedang makan' dalam ragam Kromo Inggil (halus)?",
        qEn: "How do you say 'I am eating' in polite Kromo Inggil?",
        options: [
          { text: "Kula nembe nedha", correct: true },
          { text: "Aku lagi mangan", correct: false },
          { text: "Kula lagi nguyap", correct: false },
          { text: "Aku ngganyang sego", correct: false }
        ],
        explanationId: "Bagus! 'Kula nembe nedha' adalah bentuk santun merendah untuk diri sendiri.",
        explanationEn: "Great! 'Kula nembe nedha' is the respectful humble register for oneself."
      }
    ]
  },

  sunda: {
    name: "Sunda",
    phrases: [
      {
        id: "Wilujeng enjing, hapunten bapa dosen",
        en: "Good morning, excuse me professor",
        local: "Wilujeng enjing, hapunten bapa dosen",
        noteId: "Basa lemes pikeun sasauran ka dosen",
        noteEn: "Polite Sundanese register for addressing a lecturer"
      },
      {
        id: "Hayu urang diajar bareng di perpustakaan",
        en: "Let's study together at the library",
        local: "Hayu urang diajar bareng di perpustakaan",
        noteId: "Basa loma pikeun babaturan sakuliah",
        noteEn: "Casual register for fellow university classmates"
      },
      {
        id: "Hatur nuhun pisan kana bantosanana",
        en: "Thank you very much for your kind help",
        local: "Hatur nuhun pisan kana bantosanana",
        noteId: "Ungkapan rasa syukur anu sopan",
        noteEn: "Courteous expression of gratitude"
      }
    ],
    scripts: [
      { char: "ᮃ", name: "A", descId: "Aksara Swara A", descEn: "Sundanese Vowel A" },
      { char: "ᮊ", name: "Ka", descId: "Aksara Ngalagena Ka", descEn: "Sundanese Consonant Ka" },
      { char: "ᮎ", name: "Ca", descId: "Aksara Ngalagena Ca", descEn: "Sundanese Consonant Ca" },
      { char: "ᮛ", name: "Ra", descId: "Aksara Ngalagena Ra", descEn: "Sundanese Consonant Ra" }
    ],
    translations: {
      dosen: {
        formal: "Hapunten bapa dosen, sim kuring badé tumaros perkawis materi perkuliahan.",
        casual: "Punten pak, urang rék nanya materi ieu.",
        noteFormalId: "Basa Lemes anu saé pisan kanggo nyarios ka dosen atanapi sepuh.",
        noteFormalEn: "Polite register suitable for speaking to faculty or elders.",
        noteCasualId: "Basa Loma anu merenah kanggo sesama babaturan raket.",
        noteCasualEn: "Informal register appropriate among close classmates."
      },
      kantin: {
        formal: "Mangga urang tuang sasarengan ka kantin kampus.",
        casual: "Hayu atuh urang dahar bareng ka kantin euy!",
        noteFormalId: "Ajak santun ka rerencangan kalayan hormat.",
        noteFormalEn: "Polite invitation with respect.",
        noteCasualId: "Ajak santai ka sobat akrab.",
        noteCasualEn: "Casual invitation to close friends."
      },
      terimakasih: {
        formal: "Hatur nuhun pisan kersa masihan pituduh sareng bantosan.",
        casual: "Nuhun pisan nya euy geus dibantuan!",
        noteFormalId: "Ungkapan hatur nuhun lemes pisan.",
        noteFormalEn: "Refined gratitude expression.",
        noteCasualId: "Nuhun loma keur babaturan.",
        noteCasualEn: "Casual thanks for friends."
      }
    },
    quiz: [
      {
        qId: "Pikeun ngajak rerencangan kuliah dahar bareng di kantin UB ku basa Loma (akrab), kecap nu loyog nyaéta...",
        qEn: "To invite a classmate to eat together at UB cafeteria in familiar Loma register, the suitable phrase is...",
        options: [
          { text: "Hayu atuh urang dahar bareng ka kantin!", correct: true },
          { text: "Mangga tuang nyalira waé.", correct: false },
          { text: "Tong dahar di dinya bisi mahal.", correct: false },
          { text: "Sim kuring hoyong mulih.", correct: false }
        ],
        explanationId: "Leres pisan! 'Hayu atuh urang dahar bareng' mangrupikeun basa loma anu haneut tur akrab.",
        explanationEn: "Correct! 'Hayu atuh urang dahar bareng' is a warm and natural familiar Sundanese phrase."
      }
    ]
  },

  batak: {
    name: "Batak",
    phrases: [
      {
        id: "Horas ma di hita sudena, santabi di bapa dosen",
        en: "Greetings to us all, excuse me professor",
        local: "Horas ma di hita sudena, santabi di bapa dosen",
        noteId: "Tabe santun tu angka na marsangap",
        noteEn: "Respectful greeting to an esteemed person"
      },
      {
        id: "Beta hita mangan tu kantin kampus",
        en: "Let's go eat at the campus cafeteria",
        local: "Beta hita mangan tu kantin kampus",
        noteId: "Pangkataon tu dongan sajajar",
        noteEn: "Casual invitation between university peers"
      },
      {
        id: "Mauliate godang di pangurupionmuna",
        en: "Thank you very much for your help",
        local: "Mauliate godang di pangurupionmuna",
        noteId: "Hata mauliate na denggan",
        noteEn: "Courteous word of gratitude"
      }
    ],
    scripts: [
      { char: "ᯀ", name: "A", descId: "Ina ni Surat A (Batak Toba)", descEn: "Batak Toba Vowel A" },
      { char: "ᯂ", name: "Ha", descId: "Ina ni Surat Ha", descEn: "Batak Consonant Ha" },
      { char: "ᯅ", name: "Ba", descId: "Ina ni Surat Ba", descEn: "Batak Consonant Ba" },
      { char: "ᯒ", name: "Ra", descId: "Ina ni Surat Ra", descEn: "Batak Consonant Ra" }
    ],
    translations: {
      dosen: {
        formal: "Santabi di bapa dosen, naeng manungkun ma hami taringot tu parsingkolaan on.",
        casual: "Santabi pak, naeng manungkun jolo ahu.",
        noteFormalId: "Hata santun tu bapa/inang dosen di kampus.",
        noteFormalEn: "Respectful words to university lecturers.",
        noteCasualId: "Hata tu dongan naung akrab.",
        noteCasualEn: "Words for familiar peers."
      },
      kantin: {
        formal: "Beta ma hita mangan rap tu kantin kampus bapa/inang.",
        casual: "Beta lae/ito mangan hita tu kantin!",
        noteFormalId: "Pangkataon manjou mangan na hormat.",
        noteFormalEn: "Respectful dining invitation.",
        noteCasualId: "Pangkataon akrab manjou dongan sa-kampus.",
        noteCasualEn: "Friendly dining invitation to a peer."
      },
      terimakasih: {
        formal: "Mauliate godang ma di sude pambahenan dohot pangurupionmuna.",
        casual: "Mauliate godang lae/ito!",
        noteFormalId: "Panghataon mauliate resmi.",
        noteFormalEn: "Formal gratitude expression.",
        noteCasualId: "Panghataon mauliate akrab.",
        noteCasualEn: "Friendly peer gratitude."
      }
    },
    quiz: [
      {
        qId: "Sapaan khas suku Batak yang mengandung doa keselamatan, kesehatan, dan berkat adalah...",
        qEn: "The signature Batak greeting signifying wellness, health, and prosperity is...",
        options: [
          { text: "Horas!", correct: true },
          { text: "Sampurasun!", correct: false },
          { text: "Tabea!", correct: false },
          { text: "Kuring!", correct: false }
        ],
        explanationId: "Pintar! 'Horas' adalah salam luhur penuh berkah yang dipakai oleh masyarakat Batak.",
        explanationEn: "Smart! 'Horas' is the renowned Batak greeting conferring blessings and health."
      }
    ]
  },

  bali: {
    name: "Bali",
    phrases: [
      {
        id: "Om Swastyastu, matur suksma bapak dosen",
        en: "Greetings, thank you professor",
        local: "Om Swastyastu, matur suksma bapak dosen",
        noteId: "Penyapaan suci lan hormat ring kampus",
        noteEn: "Sacred and respectful greeting on campus"
      },
      {
        id: "Jalan bareng melali ke perpustakaan",
        en: "Let's hang out together at the library",
        local: "Jalan bareng melali ke perpustakaan",
        noteId: "Basa andap ring timpal sa-jurusan",
        noteEn: "Casual register with departmental peers"
      }
    ],
    scripts: [
      { char: "ᬅ", name: "A", descId: "Aksara Suara A Bali", descEn: "Balinese Vowel A" },
      { char: "ᬓ", name: "Ka", descId: "Aksara Wianjana Ka", descEn: "Balinese Consonant Ka" },
      { char: "ᬘ", name: "Ca", descId: "Aksara Wianjana Ca", descEn: "Balinese Consonant Ca" },
      { char: "ᬭ", name: "Ra", descId: "Aksara Wianjana Ra", descEn: "Balinese Consonant Ra" }
    ],
    translations: {
      dosen: {
        formal: "Om Swastyastu bapak dosen, titiang jagi mataken indik kuliah puniki.",
        casual: "Napi gatra pak? Tiang lakar nakonin.",
        noteFormalId: "Basa Alus Singgih sane patut anggen matur ring dosen.",
        noteFormalEn: "High polite register appropriate for professors.",
        noteCasualId: "Basa Andap ring pasawitran.",
        noteCasualEn: "Casual register among companions."
      },
      kantin: {
        formal: "Durusang sareng-sareng neda ring kantin kampus.",
        casual: "Jalan ajak mekejang ngajeng di kantin!",
        noteFormalId: "Ajakan alus ring para tamiu.",
        noteFormalEn: "Polite invitation for honored guests.",
        noteCasualId: "Ajakan akrab ring timpal kampus.",
        noteCasualEn: "Friendly invitation for campus friends."
      },
      terimakasih: {
        formal: "Matur suksma banget ring sahananing wantuan bapak/ibu.",
        casual: "Suksma timpal!",
        noteFormalId: "Matur suksma sane dahat luih.",
        noteFormalEn: "Exalted expression of gratitude.",
        noteCasualId: "Suksma santai.",
        noteCasualEn: "Casual peer gratitude."
      }
    },
    quiz: [
      {
        qId: "Ungkapan terima kasih yang paling sering digunakan dalam bahasa Bali adalah...",
        qEn: "The most commonly used expression of gratitude in Balinese is...",
        options: [
          { text: "Matur Suksma", correct: true },
          { text: "Matur Nuwun", correct: false },
          { text: "Hatur Nuhun", correct: false },
          { text: "Tarimo Kasih", correct: false }
        ],
        explanationId: "Tepat! 'Matur Suksma' bermakna menghaturkan terima kasih yang tulus.",
        explanationEn: "Correct! 'Matur Suksma' translates to giving sincere gratitude."
      }
    ]
  },

  melayu: {
    name: "Melayu",
    phrases: [
      {
        id: "Selamat pagi bapak dosen, mohon izin bertanya",
        en: "Good morning professor, permission to ask a question",
        local: "Selamat pagi encik pensyarah, mohon izin bertanya",
        noteId: "Tutur berhemah kepada guru atau pensyarah",
        noteEn: "Courteous speech for professors or mentors"
      },
      {
        id: "Jom kita ke perpustakaan studi bersama",
        en: "Let's go to the library to study together",
        local: "Jom kita ke perpustakaan kaji bersama",
        noteId: "Ajakan bersahabat sesama rakan kuliah",
        noteEn: "Friendly invitation between college peers"
      }
    ],
    scripts: [
      { char: "ا", name: "Alif", descId: "Aksara Jawi Melayu Alif", descEn: "Jawi Malay Alif" },
      { char: "ب", name: "Ba", descId: "Aksara Jawi Melayu Ba", descEn: "Jawi Malay Ba" },
      { char: "ت", name: "Ta", descId: "Aksara Jawi Melayu Ta", descEn: "Jawi Malay Ta" },
      { char: "ر", name: "Ra", descId: "Aksara Jawi Melayu Ra", descEn: "Jawi Malay Ra" }
    ],
    translations: {
      dosen: {
        formal: "Selamat pagi encik pensyarah, izinkan hamba memohon pencerahan perihal tugasan ini.",
        casual: "Hai sir, nak tanya pasal assignment ni.",
        noteFormalId: "Bahasa santun beradab penuh adab sopan.",
        noteFormalEn: "Courteous language with respectful etiquette.",
        noteCasualId: "Bahasa santai sesama rakan kampus.",
        noteCasualEn: "Casual conversation among university friends."
      },
      kantin: {
        formal: "Sila jemput kita menjamu selera bersama di kafeteria kampus.",
        casual: "Jom lepak kantin makan sekali!",
        noteFormalId: "Pelawaan beradab santun.",
        noteFormalEn: "Polite dining invitation.",
        noteCasualId: "Pelawaan santai bersahaja.",
        noteCasualEn: "Casual hangout invitation."
      },
      terimakasih: {
        formal: "Jutaan terima kasih diucapkan atas budi bicara dan bantuan tuan.",
        casual: "Thanks ya geng dah tolong!",
        noteFormalId: "Ucapan syukur penuh tata krama.",
        noteFormalEn: "Formal gratitude with dignified manners.",
        noteCasualId: "Ucapan mesra rakan sebaya.",
        noteCasualEn: "Warm gratitude between peers."
      }
    },
    quiz: [
      {
        qId: "Kata 'Jom' dalam bahasa Melayu santai memiliki arti...",
        qEn: "The word 'Jom' in casual Malay means...",
        options: [
          { text: "Ayo / Mari (ajakan)", correct: true },
          { text: "Berhenti (larangan)", correct: false },
          { text: "Lapar (keadaan)", correct: false },
          { text: "Bagus (pujian)", correct: false }
        ],
        explanationId: "Tepat! 'Jom' adalah partikel ajakan yang sangat populer di kalangan anak muda.",
        explanationEn: "Correct! 'Jom' is a popular colloquial invitation particle equivalent to 'Come on / Let's go'."
      }
    ]
  }
};

// Searchable Vocabulary Database
const VOCABULARY_LIST = [
  {
    wordId: "Makan",
    wordEn: "Eat",
    category: "makan",
    jawa: { formal: "Nedha / Dhahar", casual: "Mangan", example: "Kula nembe nedha sekul wonten kantin" },
    sunda: { formal: "Tuang", casual: "Dahar", example: "Mangga urang tuang sasarengan di kampus" },
    batak: { formal: "Marsihohot Mangan", casual: "Mangan", example: "Beta hita mangan rap tu kantin" }
  },
  {
    wordId: "Belajar",
    wordEn: "Study",
    category: "kampus",
    jawa: { formal: "Sinau / Ngaos", casual: "Sinau", example: "Para mahasiswa kedah sregep sinau" },
    sunda: { formal: "Diajar", casual: "Diajar", example: "Sing getol diajar di kampus UB" },
    batak: { formal: "Marsiajar", casual: "Marsiajar", example: "Ringgas marsiajar di universitas" }
  },
  {
    wordId: "Dosen",
    wordEn: "Lecturer / Professor",
    category: "kampus",
    jawa: { formal: "Bapak / Ibu Dosen, Dwija", casual: "Dosen", example: "Nyuwun pirsa dhateng dwija pengampu" },
    sunda: { formal: "Guru Pangatik / Dosen", casual: "Dosen", example: "Tumut piwuruk dosen wali" },
    batak: { formal: "Guru Pandita / Dosen", casual: "Dosen", example: "Santabi di bapa dosen nami" }
  },
  {
    wordId: "Terima Kasih",
    wordEn: "Thank You",
    category: "salam",
    jawa: { formal: "Matur Nuwun Sanget", casual: "Suwun", example: "Matur nuwun sanget kagem pitedahipun" },
    sunda: { formal: "Hatur Nuhun Pisan", casual: "Nuhun", example: "Hatur nuhun kana sagala rupi kasaean" },
    batak: { formal: "Mauliate Godang", casual: "Mauliate", example: "Mauliate godang di pangurupionmuna" }
  },
  {
    wordId: "Permisi",
    wordEn: "Excuse Me",
    category: "salam",
    jawa: { formal: "Nyuwun Sewu / Nuwun Sewu", casual: "Nyuwun Sewu", example: "Nyuwun sewu nderek langkung wonten ngajeng" },
    sunda: { formal: "Hapunten / Punten", casual: "Punten", example: "Punten ngiring ngalangkung heula" },
    batak: { formal: "Santabi", casual: "Santabi", example: "Santabi di angka dongan sudena" }
  }
];

// =====================================================================
// APPLICATION STATE
// =====================================================================
const state = {
  lang: "id",                 // "id" or "en"
  dialect: "jawa",            // "jawa", "sunda", "batak", "bali", "melayu"
  currentTab: "panel-materi",
  darkMode: false,
  dyslexiaMode: false,
  fontSizeLevel: 0,          // 0: standard, 1: large, 2: xlarge
  hapticEnabled: true,
  speechRate: 1.0,
  currentCategory: "all",
  searchKeyword: "",
  quizIndex: 0,
  quizScore: 0,
  isSpeaking: false
};

// =====================================================================
// HANDCRAFTED WEB AUDIO SYNTHESIZER (Pure Acoustic Chimes)
// =====================================================================
class AcousticSynthesizer {
  constructor() {
    this.ctx = null;
  }

  ensureContext() {
    if (!this.ctx) {
      const AudioCtx = window.AudioContext || window.webkitAudioContext;
      if (AudioCtx) this.ctx = new AudioCtx();
    }
    if (this.ctx && this.ctx.state === "suspended") {
      this.ctx.resume();
    }
  }

  playTap() {
    if (!state.hapticEnabled) return;
    try {
      this.ensureContext();
      if (!this.ctx) return;
      const osc = this.ctx.createOscillator();
      const gain = this.ctx.createGain();
      osc.type = "sine";
      osc.frequency.setValueAtTime(440, this.ctx.currentTime);
      gain.gain.setValueAtTime(0.08, this.ctx.currentTime);
      gain.gain.exponentialRampToValueAtTime(0.001, this.ctx.currentTime + 0.06);
      osc.connect(gain);
      gain.connect(this.ctx.destination);
      osc.start();
      osc.stop(this.ctx.currentTime + 0.06);
    } catch (e) {}
  }

  playChimeSuccess() {
    if (!state.hapticEnabled) return;
    try {
      this.ensureContext();
      if (!this.ctx) return;
      const now = this.ctx.currentTime;
      // Nusantara Pentatonic Gamelan frequencies (Pelog / Slendro tone steps)
      const freqs = [523.25, 659.25, 783.99, 1046.50];
      freqs.forEach((freq, idx) => {
        const osc = this.ctx.createOscillator();
        const gain = this.ctx.createGain();
        osc.type = "sine";
        osc.frequency.setValueAtTime(freq, now + idx * 0.09);
        gain.gain.setValueAtTime(0.14, now + idx * 0.09);
        gain.gain.exponentialRampToValueAtTime(0.001, now + idx * 0.09 + 0.3);
        osc.connect(gain);
        gain.connect(this.ctx.destination);
        osc.start(now + idx * 0.09);
        osc.stop(now + idx * 0.09 + 0.3);
      });
    } catch (e) {}
  }

  playChimeFailure() {
    if (!state.hapticEnabled) return;
    try {
      this.ensureContext();
      if (!this.ctx) return;
      const now = this.ctx.currentTime;
      [220, 196].forEach((freq, idx) => {
        const osc = this.ctx.createOscillator();
        const gain = this.ctx.createGain();
        osc.type = "triangle";
        osc.frequency.setValueAtTime(freq, now + idx * 0.12);
        gain.gain.setValueAtTime(0.12, now + idx * 0.12);
        gain.gain.exponentialRampToValueAtTime(0.001, now + idx * 0.12 + 0.22);
        osc.connect(gain);
        gain.connect(this.ctx.destination);
        osc.start(now + idx * 0.12);
        osc.stop(now + idx * 0.12 + 0.22);
      });
    } catch (e) {}
  }

  triggerHaptic(pattern = [30, 20]) {
    if (state.hapticEnabled && "vibrate" in navigator) {
      try {
        navigator.vibrate(pattern);
      } catch (e) {}
    }
  }
}

const synth = new AcousticSynthesizer();

// =====================================================================
// SCREEN READER ANNOUNCER (Non-robotic human phrasing)
// =====================================================================
function announceSR(sentence) {
  const srElement = document.getElementById("sr-announcer");
  if (srElement) {
    srElement.textContent = "";
    setTimeout(() => {
      srElement.textContent = sentence;
    }, 40);
  }
}

// =====================================================================
// WEB SPEECH SYNTHESIS (Natural TTS voice)
// =====================================================================
function speakVoice(textToSpeak, overrideLang = null) {
  if (!("speechSynthesis" in window)) {
    return;
  }

  synth.ensureContext();
  window.speechSynthesis.cancel();

  const utterance = new SpeechSynthesisUtterance(textToSpeak);
  utterance.rate = state.speechRate;
  
  const targetLang = overrideLang || (state.lang === "id" ? "id-ID" : "en-US");
  utterance.lang = targetLang;

  const voices = window.speechSynthesis.getVoices();
  const found = voices.find(v => v.lang.startsWith(targetLang.slice(0, 2)));
  if (found) utterance.voice = found;

  const banner = document.getElementById("audio-banner");
  const bannerText = document.getElementById("audio-banner-text");

  utterance.onstart = () => {
    state.isSpeaking = true;
    if (banner) {
      banner.classList.remove("hidden");
      if (bannerText) bannerText.textContent = I18N[state.lang].audioBannerReading;
    }
  };

  utterance.onend = utterance.onerror = () => {
    state.isSpeaking = false;
    if (banner) banner.classList.add("hidden");
  };

  window.speechSynthesis.speak(utterance);
}

function stopVoice() {
  if ("speechSynthesis" in window) {
    window.speechSynthesis.cancel();
    state.isSpeaking = false;
    const banner = document.getElementById("audio-banner");
    if (banner) banner.classList.add("hidden");
    announceSR(state.lang === "id" ? "Pembacaan audio dihentikan." : "Audio playback stopped.");
  }
}

// =====================================================================
// I18N LANGUAGE SWITCH ENGINE
// =====================================================================
function setLanguage(newLang) {
  state.lang = newLang;
  const t = I18N[newLang];

  document.documentElement.lang = newLang;

  // Header & Brand
  const brandTextEl = document.getElementById("ui-brand-text");
  if (brandTextEl) {
    brandTextEl.textContent = t.brandTitle;
  } else {
    const brandTitleEl = document.getElementById("ui-brand-title");
    if (brandTitleEl) brandTitleEl.textContent = t.brandTitle;
  }
  const brandSub = document.getElementById("ui-brand-sub");
  if (brandSub) brandSub.textContent = t.brandSub;
  document.getElementById("flag-indicator").textContent = t.langTag;
  document.getElementById("btn-lang-toggle").setAttribute("aria-label", t.langLabel);
  document.getElementById("ui-lbl-dialect").textContent = t.lblDialect;
  document.getElementById("ui-btn-listen").textContent = t.btnListen;
  document.getElementById("btn-read-screen").setAttribute("aria-label", t.readScreenSR);

  // Bottom Navigation
  const navMateri = document.getElementById("ui-nav-materi");
  if (navMateri) navMateri.textContent = t.navMateri;
  const navKamus = document.getElementById("ui-nav-kamus");
  if (navKamus) navKamus.textContent = t.navKamus;
  const navTerjemah = document.getElementById("ui-nav-terjemah");
  if (navTerjemah) navTerjemah.textContent = t.navTerjemah;
  const navGame = document.getElementById("ui-nav-game");
  if (navGame) navGame.textContent = t.navGame;
  const navEnablink = document.getElementById("ui-nav-enablink");
  if (navEnablink) navEnablink.textContent = t.navEnablink;

  // Panel 1: Materi
  document.getElementById("ui-home-title").textContent = t.homeTitle;
  document.getElementById("ui-home-desc").textContent = t.homeDesc;
  document.getElementById("ui-a11y-title").textContent = t.a11yTitle;
  document.getElementById("ui-a11y-desc").textContent = t.a11yDesc;
  document.getElementById("ui-title-registers").textContent = t.titleRegisters;
  document.getElementById("ui-title-scripts").textContent = t.titleScripts;
  document.getElementById("ui-title-phrases").textContent = t.titlePhrases;
  document.getElementById("ui-pill-casual").textContent = t.pillCasual;
  document.getElementById("ui-pill-formal").textContent = t.pillFormal;
  document.getElementById("ui-lbl-mean-1").textContent = t.lblMean;
  document.getElementById("ui-lbl-mean-2").textContent = t.lblMean;
  document.getElementById("ui-lbl-ctx-1").textContent = t.lblCtx;
  document.getElementById("ui-lbl-ctx-2").textContent = t.lblCtx;
  document.getElementById("ui-val-mean-1").textContent = t.valMean1;
  document.getElementById("ui-val-ctx-1").textContent = t.valCtx1;
  document.getElementById("ui-val-mean-2").textContent = t.valMean2;
  document.getElementById("ui-val-ctx-2").textContent = t.valCtx2;

  // Panel 2: Kamus
  document.getElementById("ui-kamus-title").textContent = t.kamusTitle;
  document.getElementById("ui-kamus-desc").textContent = t.kamusDesc;
  document.getElementById("input-dict-search").setAttribute("placeholder", t.dictPlaceholder);
  document.getElementById("tag-all").textContent = t.tagAll;
  document.getElementById("tag-campus").textContent = t.tagCampus;
  document.getElementById("tag-food").textContent = t.tagFood;
  document.getElementById("tag-greet").textContent = t.tagGreet;

  // Panel 3: Terjemah
  document.getElementById("ui-trans-title").textContent = t.transTitle;
  document.getElementById("ui-trans-desc").textContent = t.transDesc;
  document.getElementById("ui-lbl-trans-input").textContent = t.lblTransInput;
  document.getElementById("text-translate-input").setAttribute("placeholder", t.transPlaceholder);
  document.getElementById("ui-lbl-preset").textContent = t.lblPreset;
  document.getElementById("ui-btn-translate-text").textContent = t.btnTranslateText;
  document.getElementById("ui-lbl-trans-results").textContent = t.lblTransResults;
  document.getElementById("ui-pill-res-formal").textContent = t.pillResFormal;
  document.getElementById("ui-pill-res-casual").textContent = t.pillResCasual;

  const presetChips = document.querySelectorAll(".chip-preset");
  if (presetChips.length >= 3) {
    presetChips[0].textContent = newLang === "id" ? "Tanya Dosen" : "Ask Professor";
    presetChips[0].dataset.phrase = t.preset1;
    presetChips[1].textContent = newLang === "id" ? "Ajak Makan" : "Eat Together";
    presetChips[1].dataset.phrase = t.preset2;
    presetChips[2].textContent = newLang === "id" ? "Terima Kasih" : "Thank You";
    presetChips[2].dataset.phrase = t.preset3;
  }

  // Panel 4: Game
  document.getElementById("ui-game-title").textContent = t.gameTitle;
  document.getElementById("ui-game-desc").textContent = t.gameDesc;
  document.getElementById("ui-btn-read-prompt").textContent = t.btnReadPrompt;
  document.getElementById("ui-btn-next-q").textContent = t.btnNextQ;

  // Panel 5: Enablink
  document.getElementById("ui-enablink-title").textContent = t.enablinkTitle;
  document.getElementById("ui-enablink-desc").textContent = t.enablinkDesc;
  document.getElementById("ui-ub-narrative").textContent = t.ubNarrative;
  document.getElementById("ui-title-preferences").textContent = t.titlePreferences;
  const lblPrefDark = document.getElementById("ui-lbl-pref-dark");
  if (lblPrefDark) lblPrefDark.textContent = t.lblPrefDark;
  const subPrefDark = document.getElementById("ui-sub-pref-dark");
  if (subPrefDark) subPrefDark.textContent = t.subPrefDark;
  document.getElementById("ui-lbl-pref-dyslexia").textContent = t.lblPrefDyslexia;
  document.getElementById("ui-sub-pref-dyslexia").textContent = t.subPrefDyslexia;
  const lblPrefFontSize = document.getElementById("ui-lbl-pref-fontsize");
  if (lblPrefFontSize) lblPrefFontSize.textContent = t.lblPrefFontSize;
  const subPrefFontSize = document.getElementById("ui-sub-pref-fontsize");
  if (subPrefFontSize) subPrefFontSize.textContent = t.subPrefFontSize;
  const prefFontScaleLabel = document.getElementById("pref-font-scale-label");
  if (prefFontScaleLabel) {
    if (state.fontSizeLevel === 1) prefFontScaleLabel.textContent = t.fontScaleLarge;
    else if (state.fontSizeLevel === 2) prefFontScaleLabel.textContent = t.fontScaleXLarge;
    else prefFontScaleLabel.textContent = t.fontScaleNormal;
  }
  document.getElementById("ui-lbl-pref-haptic").textContent = t.lblPrefHaptic;
  document.getElementById("ui-sub-pref-haptic").textContent = t.subPrefHaptic;
  document.getElementById("ui-lbl-pref-speed").textContent = t.lblPrefSpeed;
  document.getElementById("ui-title-citation").textContent = t.titleCitation;

  // Console Side info
  const sideLang = document.getElementById("console-lang-text");
  if (sideLang) {
    sideLang.textContent = newLang === "id" ? "Bahasa Indonesia (ID)" : "English (EN)";
  }

  renderDialectDeck();
  renderDictionaryList();
  renderQuizCard();

  announceSR(t.srReady);
}

// =====================================================================
// DIALECT DECK RENDERER
// =====================================================================
function renderDialectDeck() {
  const d = DIALECT_DATA[state.dialect] || DIALECT_DATA.jawa;

  // Render Campus Phrases
  const phraseFeed = document.getElementById("phrase-feed");
  if (phraseFeed) {
    phraseFeed.innerHTML = "";
    d.phrases.forEach((phrase) => {
      const card = document.createElement("div");
      card.className = "phrase-card";
      card.setAttribute("role", "listitem");
      card.setAttribute("aria-label", phrase.local);

      const core = document.createElement("div");
      core.className = "phrase-core";

      const heading = document.createElement("h4");
      heading.textContent = `"${phrase.local}"`;

      const desc = document.createElement("p");
      const note = state.lang === "id" ? phrase.noteId : phrase.noteEn;
      const trans = state.lang === "id" ? phrase.id : phrase.en;
      desc.textContent = `${trans} (${note})`;

      core.appendChild(heading);
      core.appendChild(desc);

      const btnVoice = document.createElement("button");
      btnVoice.className = "btn-voice-trigger";
      btnVoice.setAttribute("aria-label", `Putar audio untuk: ${phrase.local}`);
      btnVoice.innerHTML = `
        <svg class="deck-svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" aria-hidden="true">
          <polygon points="11 5 6 9 2 9 2 15 6 15 11 19 11 5"></polygon>
          <path d="M15.54 8.46a5 5 0 0 1 0 7.07"></path>
        </svg>
      `;

      btnVoice.addEventListener("click", () => {
        synth.playTap();
        speakVoice(phrase.local, "id-ID");
      });

      card.appendChild(core);
      card.appendChild(btnVoice);
      phraseFeed.appendChild(card);
    });
  }

  // Render Traditional Scripts
  const glyphGrid = document.querySelector(".glyph-grid");
  if (glyphGrid && d.scripts) {
    glyphGrid.innerHTML = "";
    d.scripts.forEach((scr) => {
      const item = document.createElement("div");
      item.className = "glyph-item";
      item.setAttribute("role", "listitem");

      const symbol = document.createElement("span");
      symbol.className = "glyph-symbol";
      symbol.setAttribute("aria-hidden", "true");
      symbol.textContent = scr.char;

      const name = document.createElement("h4");
      name.className = "glyph-label";
      name.textContent = scr.name;

      const meaning = document.createElement("p");
      meaning.className = "glyph-meaning";
      meaning.textContent = state.lang === "id" ? scr.descId : scr.descEn;

      const btn = document.createElement("button");
      btn.className = "btn-glyph-audio";
      btn.setAttribute("aria-label", `Pelafalan aksara ${scr.name}`);
      btn.innerHTML = `
        <svg class="deck-svg-sm" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" aria-hidden="true">
          <polygon points="11 5 6 9 2 9 2 15 6 15 11 19 11 5"></polygon>
          <path d="M15.54 8.46a5 5 0 0 1 0 7.07"></path>
        </svg>
        <span>${state.lang === "id" ? "Putar" : "Play"}</span>
      `;

      btn.addEventListener("click", () => {
        synth.playTap();
        const speechMsg = `${scr.name}. ${state.lang === "id" ? scr.descId : scr.descEn}`;
        speakVoice(speechMsg);
      });

      item.appendChild(symbol);
      item.appendChild(name);
      item.appendChild(meaning);
      item.appendChild(btn);
      glyphGrid.appendChild(item);
    });
  }
}

// =====================================================================
// DICTIONARY STACK ENGINE
// =====================================================================
function renderDictionaryList() {
  const stack = document.getElementById("dictionary-stack");
  if (!stack) return;

  const keyword = state.searchKeyword.toLowerCase().trim();
  const cat = state.currentCategory;
  const t = I18N[state.lang];

  const filtered = VOCABULARY_LIST.filter(item => {
    if (cat !== "all" && item.category !== cat) return false;
    if (keyword.length > 0) {
      const matchId = item.wordId.toLowerCase().includes(keyword);
      const matchEn = item.wordEn.toLowerCase().includes(keyword);
      const dial = item[state.dialect] || item.jawa;
      const matchFormal = dial.formal.toLowerCase().includes(keyword);
      const matchCasual = dial.casual.toLowerCase().includes(keyword);
      return matchId || matchEn || matchFormal || matchCasual;
    }
    return true;
  });

  stack.innerHTML = "";

  if (filtered.length === 0) {
    const emptyNotice = document.createElement("div");
    emptyNotice.style.padding = "24px 12px";
    emptyNotice.style.textAlign = "center";
    emptyNotice.style.color = "var(--ink-muted)";
    emptyNotice.innerHTML = state.lang === "id"
      ? "<strong>Kata tidak ditemukan.</strong><p style='font-size: 13px; margin-top: 4px;'>Coba kosa kata lain seperti makan, belajar, atau terima kasih.</p>"
      : "<strong>No vocabulary matches found.</strong><p style='font-size: 13px; margin-top: 4px;'>Try searching for eat, study, or thank you.</p>";
    stack.appendChild(emptyNotice);
    return;
  }

  filtered.forEach(entry => {
    const dial = entry[state.dialect] || entry.jawa;
    const card = document.createElement("div");
    card.className = "dict-entry";
    card.setAttribute("role", "article");

    const head = document.createElement("div");
    head.className = "entry-head";

    const wordTitle = document.createElement("h3");
    wordTitle.className = "entry-word";
    wordTitle.textContent = state.lang === "id" ? `${entry.wordId} (${entry.wordEn})` : `${entry.wordEn} (${entry.wordId})`;

    const tag = document.createElement("span");
    tag.className = "entry-tag";
    tag.textContent = DIALECT_DATA[state.dialect]?.name || "Jawa";

    head.appendChild(wordTitle);
    head.appendChild(tag);

    const registers = document.createElement("p");
    registers.className = "entry-registers";
    registers.innerHTML = `<strong>${t.lblFormalReg}</strong> ${dial.formal} &bull; <strong>${t.lblCasualReg}</strong> ${dial.casual}`;

    const sample = document.createElement("div");
    sample.className = "entry-sample";
    sample.innerHTML = `<strong>${t.lblExample}</strong> "${dial.example}"`;

    const btnAudio = document.createElement("button");
    btnAudio.className = "btn-glyph-audio";
    btnAudio.setAttribute("aria-label", `Dengarkan pelafalan ${dial.formal}`);
    btnAudio.innerHTML = `
      <svg class="deck-svg-sm" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" aria-hidden="true">
        <polygon points="11 5 6 9 2 9 2 15 6 15 11 19 11 5"></polygon>
        <path d="M15.54 8.46a5 5 0 0 1 0 7.07"></path>
      </svg>
      <span>${t.btnListenWord}</span>
    `;

    btnAudio.addEventListener("click", () => {
      synth.playTap();
      speakVoice(`${dial.formal}. ${dial.example}`);
    });

    card.appendChild(head);
    card.appendChild(registers);
    card.appendChild(sample);
    card.appendChild(btnAudio);
    stack.appendChild(card);
  });
}

// =====================================================================
// TRANSLATOR LOGIC
// =====================================================================
function executeTranslation() {
  const inputEl = document.getElementById("text-translate-input");
  const raw = inputEl.value.toLowerCase().trim();
  const d = DIALECT_DATA[state.dialect] || DIALECT_DATA.jawa;

  let key = "dosen";
  if (raw.includes("kantin") || raw.includes("makan") || raw.includes("eat") || raw.includes("lunch")) {
    key = "kantin";
  } else if (raw.includes("terima") || raw.includes("kasih") || raw.includes("thank")) {
    key = "terimakasih";
  }

  const result = d.translations[key] || d.translations.dosen;

  const outFormal = document.getElementById("val-trans-formal");
  const outCasual = document.getElementById("val-trans-casual");
  const noteFormal = document.getElementById("note-trans-formal");
  const noteCasual = document.getElementById("note-trans-casual");

  outFormal.textContent = result.formal;
  outCasual.textContent = result.casual;
  noteFormal.textContent = state.lang === "id" ? result.noteFormalId : result.noteFormalEn;
  noteCasual.textContent = state.lang === "id" ? result.noteCasualId : result.noteCasualEn;

  synth.playTap();
  synth.triggerHaptic([40, 20]);

  const notice = state.lang === "id"
    ? `Terjemahan selesai. Ragam sopan: ${result.formal}. Ragam santai: ${result.casual}`
    : `Translation completed. Polite register: ${result.formal}. Casual register: ${result.casual}`;
  announceSR(notice);
}

// =====================================================================
// QUIZ ENGINE
// =====================================================================
function renderQuizCard() {
  const d = DIALECT_DATA[state.dialect] || DIALECT_DATA.jawa;
  const questions = d.quiz || DIALECT_DATA.jawa.quiz;
  const t = I18N[state.lang];

  if (state.quizIndex >= questions.length) {
    state.quizIndex = 0;
  }

  const q = questions[state.quizIndex];
  const counterEl = document.getElementById("ui-quiz-counter");
  const scoreEl = document.getElementById("ui-quiz-score");
  const fillBar = document.getElementById("quiz-fill-bar");
  const promptEl = document.getElementById("ui-quiz-prompt");
  const optGroup = document.getElementById("quiz-options-group");
  const responseBox = document.getElementById("quiz-response-box");
  const btnNext = document.getElementById("btn-next-question");

  if (counterEl) {
    counterEl.textContent = t.counterPattern.replace("{curr}", state.quizIndex + 1).replace("{total}", questions.length);
  }

  if (scoreEl) {
    scoreEl.textContent = `${t.scoreText} ${state.quizScore}`;
  }

  if (fillBar) {
    const pct = ((state.quizIndex + 1) / questions.length) * 100;
    fillBar.style.width = `${pct}%`;
    fillBar.parentElement.setAttribute("aria-valuenow", pct);
  }

  if (promptEl) {
    promptEl.textContent = state.lang === "id" ? q.qId : q.qEn;
  }

  if (responseBox) {
    responseBox.className = "quiz-response-box hidden";
    responseBox.textContent = "";
  }

  if (btnNext) {
    btnNext.classList.add("hidden");
  }

  if (optGroup) {
    optGroup.innerHTML = "";
    q.options.forEach((opt, idx) => {
      const choiceBtn = document.createElement("button");
      choiceBtn.className = "quiz-choice-btn";
      choiceBtn.setAttribute("role", "radio");
      choiceBtn.setAttribute("aria-checked", "false");
      choiceBtn.setAttribute("tabindex", "0");

      const letterTag = String.fromCharCode(65 + idx);
      choiceBtn.innerHTML = `<strong>${letterTag}.</strong> <span>${opt.text}</span>`;

      choiceBtn.addEventListener("click", () => {
        const allBtns = optGroup.querySelectorAll(".quiz-choice-btn");
        allBtns.forEach(b => b.setAttribute("disabled", "true"));

        if (opt.correct) {
          choiceBtn.classList.add("is-correct");
          state.quizScore += 10;
          scoreEl.textContent = `${t.scoreText} ${state.quizScore}`;
          synth.playChimeSuccess();
          synth.triggerHaptic([30, 40, 50]);

          responseBox.className = "quiz-response-box success";
          const explanation = state.lang === "id" ? q.explanationId : q.explanationEn;
          responseBox.innerHTML = `<strong>${t.quizCorrect}</strong> ${explanation}`;
          announceSR(`${t.quizCorrect} ${explanation}`);
        } else {
          choiceBtn.classList.add("is-incorrect");
          synth.playChimeFailure();
          synth.triggerHaptic([60, 40, 60]);

          responseBox.className = "quiz-response-box error";
          const explanation = state.lang === "id" ? q.explanationId : q.explanationEn;
          responseBox.innerHTML = `<strong>${t.quizIncorrect}</strong> ${explanation}`;
          announceSR(`${t.quizIncorrect} ${explanation}`);
        }

        btnNext.classList.remove("hidden");
        btnNext.focus();
      });

      optGroup.appendChild(choiceBtn);
    });
  }
}

// =====================================================================
// INITIALIZATION & EVENT LISTENERS
// =====================================================================
document.addEventListener("DOMContentLoaded", () => {

  // --- Accessibility Toolbar Actions ---

  // Language Switcher
  const btnLang = document.getElementById("btn-lang-toggle");
  btnLang.addEventListener("click", () => {
    synth.playTap();
    const nextLang = state.lang === "id" ? "en" : "id";
    setLanguage(nextLang);
  });

  // Dyslexia Mode Toggle
  const btnDyslexia = document.getElementById("btn-dyslexia-toggle");
  const checkDyslexia = document.getElementById("check-pref-dyslexia");

  function setDyslexia(enabled) {
    state.dyslexiaMode = enabled;
    if (enabled) {
      document.body.classList.add("font-dyslexia");
      btnDyslexia.classList.add("active");
      if (checkDyslexia) checkDyslexia.checked = true;
      announceSR(state.lang === "id" ? "Mode tipografi ramah disleksia aktif." : "Dyslexia-friendly typography active.");
    } else {
      document.body.classList.remove("font-dyslexia");
      btnDyslexia.classList.remove("active");
      if (checkDyslexia) checkDyslexia.checked = false;
      announceSR(state.lang === "id" ? "Mode disleksia nonaktif." : "Dyslexia mode disabled.");
    }
  }

  btnDyslexia.addEventListener("click", () => {
    synth.playTap();
    setDyslexia(!state.dyslexiaMode);
  });

  if (checkDyslexia) {
    checkDyslexia.addEventListener("change", e => {
      setDyslexia(e.target.checked);
    });
  }

  // Dark Theme Toggle (Batik Canvas)
  const btnTheme = document.getElementById("btn-theme-toggle");
  const checkDark = document.getElementById("check-pref-dark");

  function setDarkMode(enabled) {
    state.darkMode = enabled;
    document.body.classList.toggle("theme-dark", enabled);
    if (btnTheme) btnTheme.classList.toggle("active", enabled);
    const iconMoon = document.getElementById("theme-icon-moon");
    const iconSun = document.getElementById("theme-icon-sun");
    if (iconMoon && iconSun) {
      if (enabled) {
        iconMoon.classList.add("hidden");
        iconSun.classList.remove("hidden");
      } else {
        iconMoon.classList.remove("hidden");
        iconSun.classList.add("hidden");
      }
    }
    if (checkDark) checkDark.checked = enabled;
    announceSR(state.lang === "id" 
      ? (enabled ? "Mode tema gelap batik aktif." : "Mode tema terang aktif.") 
      : (enabled ? "Dark batik theme mode enabled." : "Light theme mode enabled."));
  }

  if (btnTheme) {
    btnTheme.addEventListener("click", () => {
      synth.playTap();
      setDarkMode(!state.darkMode);
    });
  }

  if (checkDark) {
    checkDark.addEventListener("change", e => {
      setDarkMode(e.target.checked);
    });
  }

  // Font Scaling Engine (Clear, noticeable font enlargement)
  const btnFontScale = document.getElementById("btn-font-scale");
  const btnPrefFontCycle = document.getElementById("btn-pref-font-cycle");

  function setFontScale(level) {
    state.fontSizeLevel = level % 3;
    document.body.classList.remove("font-large", "font-xlarge");
    const tag = document.getElementById("font-scale-tag");
    const prefLabel = document.getElementById("pref-font-scale-label");
    const t = I18N[state.lang];

    if (state.fontSizeLevel === 1) {
      document.body.classList.add("font-large");
      if (btnFontScale) {
        btnFontScale.classList.add("active");
        btnFontScale.setAttribute("aria-label", state.lang === "id" ? "Ukuran huruf teks: Besar (120%). Klik untuk perbesar lagi." : "Text font size: Large (120%). Click to enlarge further.");
      }
      if (tag) tag.textContent = "A+";
      if (prefLabel) prefLabel.textContent = t.fontScaleLarge;
      announceSR(state.lang === "id" ? "Ukuran huruf diperbesar (120%)." : "Font size zoomed to 120%.");
    } else if (state.fontSizeLevel === 2) {
      document.body.classList.add("font-xlarge");
      if (btnFontScale) {
        btnFontScale.classList.add("active");
        btnFontScale.setAttribute("aria-label", state.lang === "id" ? "Ukuran huruf teks: Sangat Besar (140%). Klik untuk kembali normal." : "Text font size: Extra Large (140%). Click to reset.");
      }
      if (tag) tag.textContent = "A++";
      if (prefLabel) prefLabel.textContent = t.fontScaleXLarge;
      announceSR(state.lang === "id" ? "Ukuran huruf diperbesar (140%)." : "Font size zoomed to 140%.");
    } else {
      if (btnFontScale) {
        btnFontScale.classList.remove("active");
        btnFontScale.setAttribute("aria-label", state.lang === "id" ? "Ukuran huruf teks: Normal (100%). Klik untuk perbesar." : "Text font size: Normal (100%). Click to enlarge.");
      }
      if (tag) tag.textContent = "A";
      if (prefLabel) prefLabel.textContent = t.fontScaleNormal;
      announceSR(state.lang === "id" ? "Ukuran huruf standar (100%)." : "Font size reset to normal (100%).");
    }
  }

  if (btnFontScale) {
    btnFontScale.addEventListener("click", () => {
      synth.playTap();
      setFontScale(state.fontSizeLevel + 1);
    });
  }

  if (btnPrefFontCycle) {
    btnPrefFontCycle.addEventListener("click", () => {
      synth.playTap();
      setFontScale(state.fontSizeLevel + 1);
    });
  }

  // Dialect Selector
  const selectDialect = document.getElementById("select-dialect");
  selectDialect.addEventListener("change", e => {
    state.dialect = e.target.value;
    synth.playTap();
    renderDialectDeck();
    renderDictionaryList();
    renderQuizCard();
    const dName = DIALECT_DATA[state.dialect]?.name || "Jawa";
    announceSR(state.lang === "id" ? `Dialek aktif: Bahasa ${dName}.` : `Active dialect: ${dName}.`);
  });

  // Read Entire Viewport Aloud
  const btnReadScreen = document.getElementById("btn-read-screen");
  btnReadScreen.addEventListener("click", () => {
    const activePanel = document.getElementById(state.currentTab);
    if (activePanel) {
      const textToRead = activePanel.innerText.replace(/\s+/g, " ");
      speakVoice(textToRead.slice(0, 450));
    }
  });

  // Stop Audio Button
  const btnStop = document.getElementById("btn-stop-audio");
  if (btnStop) {
    btnStop.addEventListener("click", stopVoice);
  }

  // --- Bottom Navigation Tab Actions ---
  const navButtons = document.querySelectorAll(".nav-button");
  navButtons.forEach(btn => {
    btn.addEventListener("click", () => {
      const targetPanelId = btn.dataset.tab;
      if (targetPanelId === state.currentTab) return;

      synth.playTap();
      synth.triggerHaptic([20]);

      navButtons.forEach(b => {
        b.classList.remove("active");
        b.setAttribute("aria-selected", "false");
      });
      btn.classList.add("active");
      btn.setAttribute("aria-selected", "true");

      document.querySelectorAll(".screen-panel").forEach(p => p.classList.remove("active"));
      const panel = document.getElementById(targetPanelId);
      if (panel) {
        panel.classList.add("active");
        state.currentTab = targetPanelId;
        panel.focus();

        const titleText = panel.querySelector(".panel-heading")?.textContent || "Menu";
        announceSR(state.lang === "id" ? `Membuka bagian ${titleText}.` : `Opened ${titleText} section.`);
      }
    });
  });

  // Open Enablink portal from Beranda callout button
  const btnOpenEnablink = document.getElementById("btn-open-enablink");
  if (btnOpenEnablink) {
    btnOpenEnablink.addEventListener("click", () => {
      synth.playTap();
      navButtons.forEach(b => {
        b.classList.remove("active");
        b.setAttribute("aria-selected", "false");
      });
      document.querySelectorAll(".screen-panel").forEach(p => p.classList.remove("active"));
      const panel = document.getElementById("panel-enablink");
      if (panel) {
        panel.classList.add("active");
        state.currentTab = "panel-enablink";
        panel.focus();
        announceSR(state.lang === "id" ? "Membuka modul Enablink UB & Layanan Disabilitas." : "Opened Enablink UB & Disability Services.");
      }
    });
  }

  // --- Audio speech triggers in Panel 1 ---
  document.querySelectorAll(".btn-voice-trigger[data-speech]").forEach(btn => {
    btn.addEventListener("click", () => {
      synth.playTap();
      speakVoice(btn.dataset.speech, "id-ID");
    });
  });

  // --- Dictionary Search & Filters ---
  const dictSearch = document.getElementById("input-dict-search");
  const btnClearSearch = document.getElementById("btn-clear-search");

  dictSearch.addEventListener("input", e => {
    state.searchKeyword = e.target.value;
    if (e.target.value.length > 0) {
      btnClearSearch.classList.remove("hidden");
    } else {
      btnClearSearch.classList.add("hidden");
    }
    renderDictionaryList();
  });

  btnClearSearch.addEventListener("click", () => {
    dictSearch.value = "";
    state.searchKeyword = "";
    btnClearSearch.classList.add("hidden");
    dictSearch.focus();
    renderDictionaryList();
    announceSR(state.lang === "id" ? "Pencarian dibersihkan." : "Search input cleared.");
  });

  const filterTags = document.querySelectorAll(".filter-tag");
  filterTags.forEach(tag => {
    tag.addEventListener("click", () => {
      synth.playTap();
      filterTags.forEach(t => t.classList.remove("active"));
      tag.classList.add("active");
      state.currentCategory = tag.dataset.cat;
      renderDictionaryList();
      announceSR(state.lang === "id" ? `Kategori: ${tag.textContent}.` : `Category: ${tag.textContent}.`);
    });
  });

  // --- Translation Actions ---
  const btnTranslate = document.getElementById("btn-execute-translate");
  btnTranslate.addEventListener("click", executeTranslation);

  const btnVoiceInput = document.getElementById("btn-voice-input");
  btnVoiceInput.addEventListener("click", () => {
    const val = document.getElementById("text-translate-input").value;
    if (val.trim().length > 0) {
      speakVoice(val);
    } else {
      speakVoice(state.lang === "id" ? "Silakan ketik kalimat yang ingin Anda dengarkan." : "Please type a sentence to listen to.");
    }
  });

  document.querySelectorAll(".chip-preset").forEach(chip => {
    chip.addEventListener("click", () => {
      document.getElementById("text-translate-input").value = chip.dataset.phrase;
      executeTranslation();
    });
  });

  const btnAudioFormal = document.getElementById("btn-audio-formal");
  btnAudioFormal.addEventListener("click", () => {
    const text = document.getElementById("val-trans-formal").textContent;
    speakVoice(text, "id-ID");
  });

  const btnAudioCasual = document.getElementById("btn-audio-casual");
  btnAudioCasual.addEventListener("click", () => {
    const text = document.getElementById("val-trans-casual").textContent;
    speakVoice(text, "id-ID");
  });

  // --- Quiz Actions ---
  const btnQuizSpeechPrompt = document.getElementById("btn-quiz-speech-q");
  btnQuizSpeechPrompt.addEventListener("click", () => {
    const promptText = document.getElementById("ui-quiz-prompt").textContent;
    speakVoice(promptText);
  });

  const btnNextQ = document.getElementById("btn-next-question");
  btnNextQ.addEventListener("click", () => {
    synth.playTap();
    state.quizIndex++;
    renderQuizCard();
  });

  // --- Settings Actions ---
  const checkHaptic = document.getElementById("check-pref-haptic");
  if (checkHaptic) {
    checkHaptic.addEventListener("change", e => {
      state.hapticEnabled = e.target.checked;
      if (state.hapticEnabled) {
        synth.triggerHaptic([30]);
        announceSR(state.lang === "id" ? "Umpan balik suara dan getar aktif." : "Audio and haptic feedback enabled.");
      }
    });
  }

  const sliderSpeed = document.getElementById("slider-speech-speed");
  const indicatorSpeed = document.getElementById("indicator-speed");
  if (sliderSpeed) {
    sliderSpeed.addEventListener("input", e => {
      state.speechRate = parseFloat(e.target.value);
      if (indicatorSpeed) indicatorSpeed.textContent = `${state.speechRate.toFixed(1)}x`;
    });
  }

  // --- Desktop Console Simulator Actions ---
  const btnToggleViewport = document.getElementById("btn-toggle-viewport");
  if (btnToggleViewport) {
    btnToggleViewport.addEventListener("click", () => {
      const device = document.getElementById("mobile-device");
      device.classList.toggle("fullscreen-mode");
      const isFull = device.classList.contains("fullscreen-mode");
      btnToggleViewport.textContent = isFull ? "Kembali ke Mockup Ponsel" : "Beralih Layar Penuh / Mockup";
    });
  }

  const btnSimulateSR = document.getElementById("btn-simulate-sr");
  if (btnSimulateSR) {
    btnSimulateSR.addEventListener("click", () => {
      const activePanel = document.getElementById(state.currentTab);
      const title = activePanel.querySelector(".panel-heading")?.textContent || "Layar";
      const voiceNotice = `Pembaca Layar Aksara: Anda sedang berada di modul ${title}. Aksesibilitas WCAG AAA aktif.`;
      speakVoice(voiceNotice);
      announceSR(voiceNotice);
    });
  }

  // Initialize Language to ID
  setLanguage("id");
});
