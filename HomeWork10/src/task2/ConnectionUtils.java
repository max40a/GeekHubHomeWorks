package task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ConnectionUtils {

    public static String getSiteHTMLContent(URL url) throws IOException {
        StringBuilder source = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                source.append(line);
            }
        }

        return source.toString();
    }
}
