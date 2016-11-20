package task2;

import task2.archivator.FileFinder;
import task2.archivator.DirTreeList;
import task2.archivator.ZipCompress;
import task2.exeptions.DirectoryNotFoundException;
import task2.filetype.FileType;
import task2.exeptions.ArchivingException;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String pathToStartDirectory;
        String pathToFinishDirectory;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please, enter the name of the directory where the unzipped files are located :");
        pathToStartDirectory = scanner.next();
        System.out.print("Please, enter the name of the directory where to place your archived files : ");
        pathToFinishDirectory = scanner.next();

        try {
            File startDirectory = new File(pathToStartDirectory);
            File finishDirectory = new File(pathToFinishDirectory);

            if (!(startDirectory.isDirectory() || finishDirectory.isDirectory())) {
                throw new DirectoryNotFoundException("This path is not a directory.");
            }

            DirTreeList dirTreeList = new DirTreeList(pathToStartDirectory);
            FileFinder fileFinder = new FileFinder();
            ZipCompress compressor = new ZipCompress();

            Map<FileType, List<File>> filesByCategory = fileFinder.getMapOfSortedFiles(dirTreeList.getAllFilesByDirectory());
            for (Map.Entry<FileType, List<File>> entry : filesByCategory.entrySet()) {
                compressor.doCompress(pathToFinishDirectory + entry.getKey().getNameOfArchive(), entry.getValue());
            }
        } catch (ArchivingException | DirectoryNotFoundException e) {
            System.err.println(e.getMessage());
        }

    }
}