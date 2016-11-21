package task2.archivator;

import java.io.File;
import java.util.*;

public class AllDirectoriesFilesFinder {

    private File startDirectory;

    public AllDirectoriesFilesFinder(File startDirectory) {
        this.startDirectory = startDirectory;
    }

    public List<File> getAllFilesByDirectory() {
        List<File> files = new ArrayList<>();
        Queue<File> fileTree = new PriorityQueue<>();

        Collections.addAll(fileTree, startDirectory.listFiles());

        while (!fileTree.isEmpty()) {
            File currentFile = fileTree.remove();
            if (currentFile.isDirectory()) {
                Collections.addAll(fileTree, currentFile.listFiles());
            } else {
                files.add(currentFile);
            }
        }

        return files;
    }
}