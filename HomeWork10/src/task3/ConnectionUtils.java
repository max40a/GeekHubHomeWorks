package task3;

import java.io.*;
import java.net.URL;

/**
 * Utils class that contains useful method to interact with URLConnection
 */
public class ConnectionUtils {

    /**
     * Downloads content for specified URL and returns it as a byte array.
     * Should be used for small files only. Don't use it to download big files it's dangerous.
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static byte[] getData(URL url) throws IOException {
        byte[] content = new byte[1024];

        try (BufferedInputStream in = new BufferedInputStream(url.openStream());
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            int data;
            while ((data = in.read(content)) > 0) {
                out.write(content, 0, data);
            }
            return out.toByteArray();
        }
    }

    public static String toString(URL url) throws IOException {
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
