package task3;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ImageCrawler downloads all images to specified folder from specified resource.
 * It uses multi threading to make process faster. To start download images you should call downloadImages(String urlToPage) method with URL.
 * To shutdown the service you should call stop() method
 */
public class ImageCrawler {

    public static final int NUMBER_OF_THREADS = 10;

    private ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private String folder;

    public ImageCrawler(String folder) throws MalformedURLException {
        this.folder = folder;
    }

    /**
     * Call this method to start download images from specified URL.
     *
     * @param urlToPage
     * @throws IOException
     */
    public void downloadImages(String urlToPage) throws IOException {
        Collection<URL> urlList = new Page(new URL(urlToPage)).getImageLinks();
        for (URL url : urlList) {
            if (isImageURL(url)) {
                executorService.execute(new ImageTask(url, folder));
            }
        }
    }

    /**
     * Call this method before shutdown an application
     */
    public void stop() {
        executorService.shutdown();
    }

    private boolean isImageURL(URL url) {
        return url.toString().matches("([^\\s]+(\\.(?i)(jpg|png))$)");
    }
}
