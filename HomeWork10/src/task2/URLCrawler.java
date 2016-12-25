package task2;

import java.net.URL;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class URLCrawler {
    public static final int NUMBER_OF_THREADS = 10;

    private ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private String folder;
    private String pathToSource;

    public URLCrawler(String folder, String pathToSource) {
        this.folder = folder;
        this.pathToSource = pathToSource;
    }

    public void getHashMd5ForURL() {
        Collection<URL> urlCollection = URLListGenerator.getUrlList(pathToSource);
        for (URL url : urlCollection) {
            executorService.execute(new Task(url, folder));
        }
    }

    public void stop() {
        executorService.shutdown();
    }
}
