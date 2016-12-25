package task2;

public class Main {

    static final String FOLDER_TO_DOWNLOAD = "C:\\1";
    static final String PATH_TO_FILE_WITH_URL_CONTAINS = "C:\\Users\\Retro\\IdeaProjects\\GeekHubHomeWorks\\HomeWork10\\src\\task2\\URLs";

    public static void main(String[] args)  {
        URLCrawler urlCrawler = new URLCrawler(FOLDER_TO_DOWNLOAD, PATH_TO_FILE_WITH_URL_CONTAINS);
        urlCrawler.getHashMd5ForURL();
        urlCrawler.stop();
    }
}
