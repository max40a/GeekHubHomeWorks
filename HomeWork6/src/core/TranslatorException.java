package core;

public class TranslatorException extends Exception {
    public TranslatorException(Throwable throwable) {
        super(throwable.getMessage());
    }
}
