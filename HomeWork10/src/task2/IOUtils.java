package task2;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

public class IOUtils {

    public static Collection<URL> getUrlList(String pathToSourceURLFile) {
        Collection<URL> urlCollection = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(pathToSourceURLFile))) {
            String urlName;
            while ((urlName = reader.readLine()) != null) {
                urlCollection.add(new URL(urlName));
            }
        }catch (IOException e) {
            e.getMessage();
        }

        return urlCollection;
    }


    public static String getSiteHTMLContent(InputStream inputStream) throws IOException {
        StringBuilder source = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                source.append(line);
            }
        }

        return source.toString();
    }
}
