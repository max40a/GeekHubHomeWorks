package task1.core;

import task1.core.language.Language;

public class Translation {

    private final String originalText;
    private final Language originalLanguage;
    private final String translatedText;
    private final Language targetLanguage;

    public Translation(String originalText,
                       Language originalLanguage,
                       String translatedText,
                       Language targetLanguage) {
        this.originalText = originalText;
        this.originalLanguage = originalLanguage;
        this.translatedText = translatedText;
        this.targetLanguage = targetLanguage;
    }

    public String getOriginalText() {
        return originalText;
    }

    public Language getOriginalLanguage() {
        return originalLanguage;
    }

    public String getTranslatedText() {
        return translatedText;
    }

    public Language getTargetLanguage() {
        return targetLanguage;
    }
}