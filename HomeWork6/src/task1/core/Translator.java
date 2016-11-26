package task1.core;

public interface Translator {

    Translation translate(TranslationRequest translationRequest) throws TranslatorException;
}
