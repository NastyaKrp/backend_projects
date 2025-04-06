package org.example.strategies;


import java.io.*;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;


public class Jar implements ArchiveStrategy {

    private List<String> filePath;
    private String zipFile;
    @Override
    public void collectArchiveDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the path to file you want to archive");
        String filename = sc.nextLine();
        List<String> fn = new ArrayList<>();
        fn.add(filename);
        filePath = fn;
        System.out.println("Enter the name of archive");
        zipFile = sc.nextLine();
        try {
            ArchJAR();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void ArchJAR() throws IOException, FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(this.zipFile);
        JarOutputStream jos = new JarOutputStream(fos);

        for (String inputFilePath : this.filePath) {
            File inputFile = new File(inputFilePath);
            if (inputFile.isDirectory()) {
                for (File f : inputFile.listFiles()) {
                    byte[] buffer = new byte[1024];
                    FileInputStream fis = new FileInputStream(f);
                    JarEntry entry = new JarEntry(f.getName());
                    jos.putNextEntry(entry);
                    int bytesRead;
                    while ((bytesRead = fis.read(buffer)) != -1) {
                        jos.write(buffer, 0, bytesRead);
                    }
                    jos.closeEntry();
                    fis.close();
                }
            } else {
                byte[] buffer = new byte[1024];
                FileInputStream fis = new FileInputStream(inputFile);
                JarEntry entry = new JarEntry(inputFile.getName());
                jos.putNextEntry(entry);
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    jos.write(buffer, 0, bytesRead);
                }
                jos.closeEntry();
                fis.close();
            }
        }
        jos.flush();
        jos.close();
    }


}

