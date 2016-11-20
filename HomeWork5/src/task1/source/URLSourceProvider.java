package task1.source;

import java.io.IOException;
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
        try {
            return SourceUtils.toString(new URL(pathToSource).openStream());
        } catch (IOException e) {
            throw new SourceLoadingException("ULR at the specified address is not available.", e);
        }
    }
}