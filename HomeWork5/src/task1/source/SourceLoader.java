package task1.source;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * SourceLoader should contain all implementations of SourceProviders to be able to load different sources.
 */
public class SourceLoader {

    private List<SourceProvider> sourceProviders = new ArrayList<>();

    public SourceLoader() {
        sourceProviders.add(new URLSourceProvider());
        sourceProviders.add(new FileSourceProvider());
    }

    public String loadSource(String pathToSource) throws SourceLoadingException {
        for (SourceProvider source : sourceProviders) {
            if(source.isAllowed(pathToSource)) {
                return source.load(pathToSource);
            }
        }
        return null;
    }
}