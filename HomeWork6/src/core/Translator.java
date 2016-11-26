package core;

public interface Translator {

    Translation translate(TranslationRequest translationRequest) throws TranslatorException;
}
