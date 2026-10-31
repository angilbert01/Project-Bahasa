package id.ac.ub.aksara.model

enum class AppLanguage(val code: String, val displayName: String) {
    ID("id", "ID"),
    EN("en", "EN")
}

enum class Dialect(val id: String, val title: String, val aksaraName: String) {
    JAWA("jawa", "Jawa", "ꦲꦤꦕꦫꦏ"),
    SUNDA("sunda", "Sunda", "ᮃᮊ᮪ᮞᮛ ᮞᮥᮔ᮪ᮓ"),
    MADURA("madura", "Madura", "Bhâsa Madhurâ"),
    BALI("bali", "Bali", "ᬅᬓ᭄ᬱᬭ ᬩᬮᬶ")
}

enum class AppScreen(val route: String, val titleId: String, val titleEn: String) {
    HOME("home", "Beranda", "Home"),
    DICTIONARY("dictionary", "Kamus", "Dictionary"),
    TRANSLATE("translate", "Translate", "Translate"),
    GAME("game", "Game", "Game")
}

data class AksaraGlyph(
    val char: String,
    val latin: String,
    val audioHint: String,
    val dialect: Dialect,
    val descId: String,
    val descEn: String
)

data class CulturalPhrase(
    val dialect: Dialect,
    val phrase: String,
    val script: String,
    val register: String,
    val translationId: String,
    val translationEn: String,
    val etikaId: String,
    val etikaEn: String
)

data class VocabEntry(
    val word: String,
    val script: String,
    val register: String,
    val category: String,
    val meaningId: String,
    val meaningEn: String,
    val dialect: Dialect,
    val example: String
)

data class QuizQuestion(
    val dialect: Dialect,
    val scriptPrompt: String,
    val questionId: String,
    val questionEn: String,
    val options: List<String>,
    val correctIndex: Int,
    val explanationId: String,
    val explanationEn: String
)

object AksaraRepository {

    val glyphs = listOf(
        AksaraGlyph("ꦲ", "Ha", "ha", Dialect.JAWA, "Melambangkan urip utawa napas kehidupan", "Symbolizes life breath and human spirit"),
        AksaraGlyph("ꦤ", "Na", "na", Dialect.JAWA, "Wujud keteguhan lan krenteg ati", "Represents steadfastness and pure intention"),
        AksaraGlyph("ꦕ", "Ca", "ca", Dialect.JAWA, "Cipta rasa lan budi pekerti luhur", "Represents high morality and conscious intellect"),
        AksaraGlyph("ꦫ", "Ra", "ra", Dialect.JAWA, "Rasa pangrasa marang sesama", "Empathy and emotional connection with fellow beings"),
        AksaraGlyph("ꦏ", "Ka", "ka", Dialect.JAWA, "Kersaning Hyang Widhi", "Acceptance of divine guidance and wisdom"),
        
        AksaraGlyph("ᮃ", "A", "a", Dialect.SUNDA, "Aksara swara murni Sunda", "Pure vowel representing beginning and honesty"),
        AksaraGlyph("ᮊ", "Ka", "ka", Dialect.SUNDA, "Karakter kuat masagi Pasundan", "Strong character representing balanced Pasundan wisdom"),
        AksaraGlyph("ᮞ", "Sa", "sa", Dialect.SUNDA, "Silih asah, silih asih, silih asuh", "Mutual nurturing, loving, and teaching"),

        AksaraGlyph("ᬅ", "A", "a", Dialect.BALI, "Aksara swara pembuka naskah Bali", "Opening sacred vowel of Balinese palm leaf codex"),
        AksaraGlyph("ᬓ", "Ka", "ka", Dialect.BALI, "Aksara wianjana pertama", "First consonant in Balinese script tradition"),
        AksaraGlyph("ᬲ", "Sa", "sa", Dialect.BALI, "Simbol kasucian lan harmoni jagat", "Symbol of purity and cosmic harmony")
    )

    val phrases = listOf(
        CulturalPhrase(
            Dialect.JAWA,
            "Sugeng rawuh wonten ing tlatah Jawa",
            "ꦱꦸꦒꦼꦁ ꦫꦮꦸꦃ ꦮꦺꦴꦤ꧀ꦠꦼꦤ꧀ ꦲꦶꦁ ꦠ꧀ꦭꦠꦃ ꦗꦮ",
            "Krama Alus",
            "Selamat datang di tanah Jawa",
            "Welcome to the land of Java",
            "Diucapkan dengan menundukkan kepala sedikit sebagai tanda penghormatan luhur.",
            "Spoken with a gentle nod as a gesture of profound respect."
        ),
        CulturalPhrase(
            Dialect.SUNDA,
            "Wilujeng sumping di tatar Pasundan",
            "ᮝᮤᮜᮥᮏᮨᮀ ᮞᮥᮙ᮪ᮕᮤᮀ ᮓᮤ ᮒᮒᮁ ᮕᮞᮥᮔ᮪ᮓᮔ᮪",
            "Loma / Lemes",
            "Selamat datang di tanah Pasundan",
            "Welcome to the land of Pasundan",
            "Salam keramahan yang diiringi senyuman hangat penuh kekeluargaan.",
            "Hospitality greeting accompanied by a warm fraternal smile."
        ),
        CulturalPhrase(
            Dialect.MADURA,
            "Mator sakalangkong bân salam seddha",
            "Mator sakalangkong",
            "Alos Tenggi",
            "Terima kasih banyak dan salam sejahtera",
            "Thank you very much and peaceful greetings",
            "Bentuk kesantunan tertinggi masyarakat Madura saat menerima tamu.",
            "Highest form of Madurese courtesy when welcoming guests."
        ),
        CulturalPhrase(
            Dialect.BALI,
            "Om Swastyastu, rahayu sareng sami",
            "ᬒᬁ ᬲ᭄ᬯᬲ᭄ᬢ᭄ᬬᬲ᭄ᬢᬸ",
            "Alus Singgih",
            "Semoga dalam lindungan Hyang Widhi dan sejahtera bersama",
            "May divine blessings and prosperity be upon us all",
            "Diucapkan dengan merapatkan kedua telapak tangan di depan dada (anjali).",
            "Spoken while joining palms at chest level in anjali reverence."
        )
    )

    val vocabulary = listOf(
        VocabEntry("Matur Nuwun", "ꦩꦠꦸꦂ ꦤꦸꦮꦸꦤ꧀", "Krama Alus", "Sopan Santun", "Terima kasih", "Thank you", Dialect.JAWA, "Matur nuwun sanget kagem pitulungan panjenengan."),
        VocabEntry("Nyuwun Sewu", "ꦚꦸꦮꦸꦤ꧀ ꦱꦺꦮꦸ", "Krama", "Sopan Santun", "Permisi / Maaf", "Excuse me / Pardon", Dialect.JAWA, "Nyuwun sewu, derek langkung."),
        VocabEntry("Dahar", "ꦝꦲꦂ", "Krama Inggil", "Sehari-hari", "Makan (untuk orang yang dihormati)", "Eat (honorific)", Dialect.JAWA, "Bapak nembe dahar wonten wingking."),
        VocabEntry("Mangan", "ꦩꦔꦤ꧀", "Ngoko", "Sehari-hari", "Makan (kasual)", "Eat (casual)", Dialect.JAWA, "Ayo mangan bareng ning warung."),
        VocabEntry("Sare", "ꦱꦫꦺ", "Krama Inggil", "Sehari-hari", "Tidur (hormat)", "Sleep (honorific)", Dialect.JAWA, "Eyang sampun sare wiwit wau dalu."),

        VocabEntry("Hatur Nuhun", "ᮠᮒᮥᮁ ᮔᮥᮠᮥᮔ᮪", "Lemes", "Sopan Santun", "Terima kasih", "Thank you", Dialect.SUNDA, "Hatur nuhun kana kasaean anjeun."),
        VocabEntry("Punten", "ᮕᮥᮔ᮪ᮒᮨᮔ᮪", "Loma", "Sopan Santun", "Permisi / Maaf", "Excuse me", Dialect.SUNDA, "Punten bade tumaros alamat ieu."),
        VocabEntry("Tuang", "ᮒᮥᮃᮀ", "Lemes", "Sehari-hari", "Makan (halus)", "Eat (honorific)", Dialect.SUNDA, "Mangga urang tuang heula sasarengan."),
        VocabEntry("Neda", "ᮔᮨᮓ", "Sedeng", "Sehari-hari", "Makan (diri sendiri)", "Eat (humble for self)", Dialect.SUNDA, "Abdi nuju neda di payun."),

        VocabEntry("Mator Sakalangkong", "Mator Sakalangkong", "Alos Tenggi", "Sopan Santun", "Terima kasih banyak", "Thank you very much", Dialect.MADURA, "Mator sakalangkong ghâbây kabbhi bântowanna."),
        VocabEntry("Ngireng", "Ngireng", "Alos", "Sopan Santun", "Silakan / Mari ikut", "Please / Welcome along", Dialect.MADURA, "Ngireng maso' ka dâlem roma."),
        VocabEntry("Neddha", "Neddha", "Alos", "Sehari-hari", "Makan", "Eat", Dialect.MADURA, "Sampeyan ampon neddha ghi'?"),

        VocabEntry("Suksma", "ᬲᬸᬓ᭄ᬱ᭄ᬫ", "Alus", "Sopan Santun", "Terima kasih", "Thank you", Dialect.BALI, "Matur suksma banget antuk uratianne."),
        VocabEntry("Nunas Lugra", "ᬦᬸᬦᬲ᭄ ᬮᬸᬕ᭄ᬭ", "Alus Singgih", "Sopan Santun", "Mohon izin / Permisi", "Excuse me / Request permission", Dialect.BALI, "Nunas lugra titiang jagi ngaturang sembah."),
        VocabEntry("Ngajeng", "ᬗᬚᭂᬂ", "Alus Madia", "Sehari-hari", "Makan", "Eat", Dialect.BALI, "Ritatkala ngajeng patut saling asah asih asuh.")
    )

    val quizzes = listOf(
        QuizQuestion(
            Dialect.JAWA,
            "ꦲ",
            "Aksara Jawa di atas berbunyi apa?",
            "What is the Latin reading for this Javanese script?",
            listOf("Ha", "Na", "Ca", "Ra"),
            0,
            "Aksara ꦲ dibaca 'Ha', merupakan aksara carakan urutan pertama yang melambangkan hembusan hidup.",
            "Character ꦲ is read 'Ha', the first symbol in the Javanese alphabet representing the spark of life."
        ),
        QuizQuestion(
            Dialect.JAWA,
            "ꦩꦠꦸꦂ ꦤꦸꦮꦸꦤ꧀",
            "Ungkapan santun 'Matur Nuwun' memiliki arti...",
            "What does the polite phrase 'Matur Nuwun' mean?",
            listOf("Terima kasih", "Selamat jalan", "Permisi", "Minta tolong"),
            0,
            "'Matur Nuwun' adalah bentuk krama alus untuk mengucapkan terima kasih penuh takzim.",
            "'Matur Nuwun' is the highest polite register expressing sincere gratitude."
        ),
        QuizQuestion(
            Dialect.SUNDA,
            "ᮠᮒᮥᮁ ᮔᮥᮠᮥᮔ᮪",
            "Kata 'Hatur Nuhun' dalam bahasa Sunda diucapkan untuk...",
            "In Sundanese culture, 'Hatur Nuhun' is expressed to...",
            listOf("Mengucapkan terima kasih", "Meminta maaf", "Menyapa pagi", "Berpamitan"),
            0,
            "'Hatur nuhun' merupakan ungkapan terima kasih yang santun dan hangat di tatar Sunda.",
            "'Hatur nuhun' expresses warm and polite thanks in Sundanese society."
        ),
        QuizQuestion(
            Dialect.BALI,
            "ᬲᬸᬓ᭄ᬱ᭄ᬫ",
            "Ungkapan 'Suksma' di Bali lazim digunakan untuk...",
            "The phrase 'Suksma' in Bali is commonly used for...",
            listOf("Menyatakan terima kasih", "Meminta izin", "Menolak tawaran", "Mengucapkan salam tidur"),
            0,
            "'Suksma' atau 'Matur Suksma' bermakna terima kasih atas kebaikan yang diterima.",
            "'Suksma' means thank you for the kindness and presence received."
        )
    )
}

