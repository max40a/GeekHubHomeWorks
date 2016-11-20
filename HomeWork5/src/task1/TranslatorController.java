package task1;

import task1.source.SourceLoader;
import task1.source.SourceLoadingException;
import task1.source.URLSourceProvider;

import java.util.Scanner;

public class TranslatorController {

    public static void main(String[] args) {

        SourceLoader sourceLoader = new SourceLoader();
        Translator translator = new Translator(new URLSourceProvider());

        Scanner scanner = new Scanner(System.in);
        String command = scanner.next();
        while (!"exit".equals(command)) {
            try {
                String source;
                try {
                    source = sourceLoader.loadSource(command);
                } catch (SourceLoadingException e) {
                    throw new TranslateException(e);
                }
                String translation = translator.translate(source);

                System.out.println("Original: " + source);
                System.out.println("Translation: " + translation);

            } catch (TranslateException e) {
                System.err.println(e.getMessage());
                System.err.println("Enter valid File path or URL address.");
            }
            command = scanner.next();
        }
    }
}