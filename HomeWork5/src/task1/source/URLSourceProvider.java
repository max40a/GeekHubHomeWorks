package task1.source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Implementation for loading content from specified URL.<br/>
 * Valid paths to load are http://someurl.com, https://secureurl.com, ftp://frpurl.com etc.
 */
public class URLSourceProvider implements SourceProvider {

    @Override
    public boolean isAllowed(String pathToSource) {
        try {
            new URL(pathToSource);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public String load(String pathToSource) throws SourceLoadingException {
        StringBuilder urlLoadedResult = new StringBuilder();

        try {
            URL url = new URL(pathToSource);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                String input;
                while ((input = reader.readLine()) != null) {
                    urlLoadedResult.append(input);
                }
            }
        } catch (IOException e) {
            throw new SourceLoadingException("ULR at the specified address is not available.", e);
        }

        return urlLoadedResult.toString();
    }
}