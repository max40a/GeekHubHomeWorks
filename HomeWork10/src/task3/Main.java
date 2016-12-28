package task3;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    static String taskLink = "http://trinixy.ru/16356-prikolnye_kartinki_ochen_mnogo.html";

    public static final String FOLDER_TO_DOWNLOAD = "C:\\1";

    public static void main(String[] args) throws IOException {
        ImageCrawler imageCrawler = new ImageCrawler(FOLDER_TO_DOWNLOAD);
        imageCrawler.downloadImages(taskLink);

        System.out.println("While it's loading you can enter another url to start download images:");

        Scanner scanner = new Scanner(System.in);
        String command;
        while (!"exit".equals(command = scanner.next())) {
            imageCrawler.downloadImages(command);
            System.out.println("...and another url:");
        }
        imageCrawler.stop();
    }
}
