package util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class EncodingUtils {

    private EncodingUtils() {
    }

    public static String encode(String text, String charset) throws UnsupportedEncodingException {
        return URLEncoder.encode(text, charset);
    }
}
