package task2;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;

public class Task implements Runnable{

    private URL url;
    private String folder;
    private Md5 md5;

    private String terminationFile = "hash_code.txt";

    public Task(URL url, String folder) {
        this.url = url;
        this.folder = folder;
        md5 = new Md5();
    }

    @Override
    public void run() {
        String pathToFile = folder + "\\" + buildFileName(url) + "_" + terminationFile;
        try(FileWriter writer = new FileWriter(pathToFile)) {
            writer.write(md5.getMD5HashSum(url));
        }catch (IOException | NoSuchAlgorithmException e) {
            e.getMessage();
        }
    }

    private String buildFileName(URL url) {
        return url.toString().replaceAll("[^a-zA-Z0-9-_\\.]", "_");
    }
}
