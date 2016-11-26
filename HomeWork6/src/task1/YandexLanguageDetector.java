package task1;

import task1.core.language.Language;
import task1.core.language.LanguageDetector;
import task1.core.language.LanguageDetectorException;
import task1.core.language.UnknownLanguageException;
import org.json.JSONException;
import org.json.JSONObject;
import task1.util.EncodingUtils;
import task1.util.IOUtils;

import java.io.IOException;
import java.net.URL;

public class YandexLanguageDetector implements LanguageDetector {

    private static final String YANDEX_LANGUAGE_DETECTOR_API_URL = "https://translate.yandex.net/api/v1.5/tr.json/detect?key=%s&text=%s";
    private static final String CHARSET = "UTF-8";

    private final String apiKey;

    public YandexLanguageDetector(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public Language detect(String text) throws LanguageDetectorException {
        try {
            URL url = new URL(String.format(YANDEX_LANGUAGE_DETECTOR_API_URL, apiKey, EncodingUtils.encode(text,  CHARSET)));
            JSONObject response = new JSONObject(IOUtils.toString(url.openStream()));
            return Language.find(response.getString("lang"));
        } catch (IOException | JSONException | UnknownLanguageException e) {
            throw new LanguageDetectorException(e);
        }
    }
}