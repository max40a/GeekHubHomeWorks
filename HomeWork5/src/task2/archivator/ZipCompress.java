package task2.archivator;

import task2.exeptions.ArchivingException;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipCompress {

    public void doCompress(String archivePath, List<File> files) throws ArchivingException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(archivePath);
             ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(zipOutputStream)) {

            for (File file : files) {
                System.out.println("Archive file : " + file.getName());
                try (BufferedReader reader = new BufferedReader(new FileReader(file.getPath()))) {
                    zipOutputStream.putNextEntry(new ZipEntry(file.getPath()));
                    int i;
                    while ((i = reader.read()) != -1) {
                        bufferedOutputStream.write(i);
                    }
                    bufferedOutputStream.flush();
                }
            }
        } catch (IOException e) {
            throw new ArchivingException("It is impossible to create a zip archive.");
        }
    }
}