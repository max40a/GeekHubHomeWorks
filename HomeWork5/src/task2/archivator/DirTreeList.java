package task2.archivator;

import java.io.File;
import java.util.*;

public class DirTreeList {

    private String dirName;

    public DirTreeList(String dirName) {
        this.dirName = dirName;
    }

    public List<File> getAllFilesByDirectory() {
        File rootDir = new File(dirName);

        List<File> files = new ArrayList<>();
        Queue<File> fileTree = new PriorityQueue<>();

        Collections.addAll(fileTree, rootDir.listFiles());

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