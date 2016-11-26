package task1;

import task1.core.Translation;
import task1.core.TranslationRequest;
import task1.core.Translator;
import task1.core.TranslatorException;
import task1.core.language.Language;
import task1.core.language.LanguageDetector;
import task1.core.language.LanguageDetectorException;
import task1.core.language.UnknownLanguageException;
import org.json.JSONArray;
import org.json.JSONObject;
import task1.util.EncodingUtils;
import task1.util.IOUtils;

import java.io.IOException;
import java.net.URL;

public class YandexTranslator implements Translator {

    private static final String YANDEX_TRANSLATOR_API_URL = "https://translate.yandex.net/api/v1.5/tr.json/translate?key=%s&text=%s&lang=%s";
    private static final String CHARSET = "UTF-8";

    private final String apiKey;
    private final LanguageDetector languageDetector;

    public YandexTranslator(String apiKey, LanguageDetector languageDetector) {
        this.apiKey = apiKey;
        this.languageDetector = languageDetector;
    }

    @Override
    public Translation translate(TranslationRequest translationRequest) throws TranslatorException {
        try {

            URL url = new URL(String.format(
                    YANDEX_TRANSLATOR_API_URL,
                    apiKey,
                    EncodingUtils.encode(translationRequest.getText(), CHARSET),
                    EncodingUtils.encode(prepareLanguageDirection(
                            languageDetector.detect(translationRequest.getText()),
                            translationRequest.getTargetLanguage()),
                            CHARSET)));

            String translatedText = JSONHandle(url);

            return new Translation(
                    translationRequest.getText(),
                    languageDetector.detect(translationRequest.getText()),
                    translatedText,
                    translationRequest.getTargetLanguage());

        } catch (IOException | LanguageDetectorException | UnknownLanguageException e) {
            throw new TranslatorException(e);
        }
    }

    private String JSONHandle(URL url) throws IOException {
        JSONObject response = new JSONObject(IOUtils.toString(url.openStream()));
        JSONArray responseStringsArray = response.getJSONArray("text");

        StringBuilder translatedText = new StringBuilder();
        for (Object s : responseStringsArray) {
            if(s instanceof String) {
                translatedText.append(((String) s));
            }
        }

        return translatedText.toString();
    }

    private String prepareLanguageDirection(Language from, Language to) {
        return from.getCode() + "-" + to.getCode();
    }
}