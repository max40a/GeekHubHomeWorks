package task1.source;

import java.io.*;

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
        try{
            return SourceUtils.toString(new FileInputStream(pathToSource));
        } catch (IOException e) {
            throw new SourceLoadingException("File read error : file not found.", e);
        }
    }
}