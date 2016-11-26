
import core.Translation;
import core.TranslationRequest;
import core.Translator;
import core.TranslatorException;
import core.language.Language;
import core.language.LanguageDetector;
import core.language.LanguageDetectorException;
import core.language.UnknownLanguageException;

import java.io.IOException;
import java.util.Scanner;

public class TranslatorController {

    private static final String YANDEX_API_KEY = "trnsl.1.1.20131116T095927Z.86fe567e8de2cf44.5be1510f166cd444fdd9363db18bb3b5537bb7e9";

    public static void main(String[] args) throws LanguageDetectorException, IOException {
        LanguageDetector languageDetector = new YandexLanguageDetector(YANDEX_API_KEY);
        Translator translator = new YandexTranslator(YANDEX_API_KEY, languageDetector);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String text = scanner.nextLine();
            if ("exit".equals(text)) {
                break;
            }

            try {
                String targetLanguage = scanner.nextLine();
                TranslationRequest translationRequest = new TranslationRequest(text, Language.find(targetLanguage));
                Translation translation = translator.translate(translationRequest);

                System.out.println("Original text: " + translation.getOriginalText());
                System.out.println("Original language: " + translation.getOriginalLanguage());

                System.out.println("Translated text: " + translation.getTranslatedText());
                System.out.println("Target language: " + translation.getTargetLanguage());
            } catch (UnknownLanguageException e) {
                System.out.println("Language '" + e.getUnknownLanguage() + "' is not supported yet");
                break;
            } catch (TranslatorException e) {
                System.out.println("Something went wrong during translating");
                break;
            }
        }
    }
}