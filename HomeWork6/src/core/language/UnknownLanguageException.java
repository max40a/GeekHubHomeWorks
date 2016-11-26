package core.language;

public class UnknownLanguageException extends Exception {

    private final String unknownLanguage;

    public UnknownLanguageException(String unknownLanguage) {
        this.unknownLanguage = unknownLanguage;
    }

    public String getUnknownLanguage() {
        return unknownLanguage;
    }
}