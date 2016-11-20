package task1;

public class TranslateException extends Exception {

    public TranslateException(String message, Throwable e) {
        super(message);
        initCause(e);
    }
}