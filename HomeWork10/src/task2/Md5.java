package task2;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5 {

    private String hashText;

    public String getMD5HashSum(URL url) throws NoSuchAlgorithmException, IOException {
        final MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.reset();
        messageDigest.update(getContent(url).getBytes());

        byte[] digest = messageDigest.digest();
        BigInteger bigInt = new BigInteger(1, digest);
        hashText = bigInt.toString(16);
        while (hashText.length() < 32) {
            hashText = "0" + hashText;
        }

        return hashText;
    }

    private String getContent(URL url) throws IOException {
        return ConnectionUtils.getSiteHTMLContent(url);
    }
}
