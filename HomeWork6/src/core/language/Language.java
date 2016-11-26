package core.language;

public enum Language {

    ENGLISH("en"), UKRAINIAN("uk"), RUSSIAN("ru");

    private String code;

    public static Language find(String abbr) throws UnknownLanguageException {
        Language[] languages = Language.values();
        for (Language language : languages) {
            if (abbr.equals(language.getCode())) {
                return language;
            }
        }
        throw new UnknownLanguageException(abbr);
    }

    Language(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code;
    }
}
