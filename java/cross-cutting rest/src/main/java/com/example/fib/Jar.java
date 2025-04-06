package com.example.fib;

import java.io.*;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class Jar {
    public static void ArchJAR(List<String> inputFilePaths, String outputFilePath) throws IOException, FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(outputFilePath);
        JarOutputStream jos = new JarOutputStream(fos);

        for (String inputFilePath : inputFilePaths) {
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

    public static void exJAR(String archivePath) {
        byte[] buffer = new byte[1024];
        try {
            ZipInputStream zis = new ZipInputStream(new FileInputStream(archivePath));
            ZipEntry ze = zis.getNextEntry();
            while (ze != null) {
                String fileName = ze.getName();
                File newFile = new File( "jnew" + fileName);
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                ze = zis.getNextEntry();
            }
            zis.closeEntry();
            zis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

