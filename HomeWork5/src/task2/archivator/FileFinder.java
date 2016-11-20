package task2.archivator;

import task2.filetype.FileType;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileFinder {

    private Map<FileType, List<File>> filesByCategory = new HashMap<>();

    public Map<FileType, List<File>> getMapOfSortedFiles(List<File> allFilesList) {
        for (FileType fileType : FileType.values()) {
            filesByCategory.put(fileType, findSpecificFiles(allFilesList, fileType.getFeaturePattern()));
        }
        return filesByCategory;
    }

    private List<File> findSpecificFiles(List<File> files, String featurePattern) {
        List<File> foundedFilesList = new ArrayList<>();

        for (File file : files) {
            if (file.getName().matches(featurePattern)) {
                foundedFilesList.add(file);
            }
        }

        return foundedFilesList;
    }
}
