package core.language;

import java.io.IOException;

public interface LanguageDetector {

    Language detect(String text) throws LanguageDetectorException, IOException, UnknownLanguageException;
}
