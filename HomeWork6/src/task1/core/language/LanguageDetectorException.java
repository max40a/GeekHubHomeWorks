package task1.core.language;

public class LanguageDetectorException extends Exception {

    public LanguageDetectorException(Throwable throwable) {
        super(throwable.getMessage());
    }
}
