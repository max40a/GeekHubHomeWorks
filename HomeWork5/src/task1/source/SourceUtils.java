package task1.source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SourceUtils {

    public static String toString(InputStream inputStream) throws IOException {
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
