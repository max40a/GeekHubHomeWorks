package task1.source;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Implementation for loading content from local file system.
 * This implementation supports absolute paths to local file system without specifying file:// protocol.
 * Examples c:/1.txt or d:/pathToFile/file.txt
 */
public class FileSourceProvider implements SourceProvider {

    @Override
    public boolean isAllowed(String pathToSource) {
        return new File(pathToSource).isFile();
    }

    @Override
    public String load(String pathToSource) throws SourceLoadingException {
        StringBuilder fileLoadedResult = new StringBuilder();

        try {
            try (BufferedReader reader = new BufferedReader(new FileReader(pathToSource))) {
                String input;
                while ((input = reader.readLine()) != null) {
                    fileLoadedResult.append(input);
                }
            }
        } catch (IOException e) {
            throw new SourceLoadingException("File read error : file not found.", e);
        }

        return fileLoadedResult.toString();
    }
}