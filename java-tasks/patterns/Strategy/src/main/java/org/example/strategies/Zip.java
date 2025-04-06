package org.example.strategies;

import java.io.*;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class Zip implements ArchiveStrategy {

    private String filePath;
    private String zipFile;
    @Override
    public void collectArchiveDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the path to file you want to archive");
        filePath = sc.nextLine();
        System.out.println("Enter the name of archive");
        zipFile = sc.nextLine();
        try {
            Z();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void Z() throws Exception
    {
        try(ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(this.zipFile));
            FileInputStream fis = new FileInputStream(this.filePath);)
        {
            ZipEntry entry1 = new ZipEntry(this.filePath);
            zout.putNextEntry(entry1);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zout.write(buffer);
            zout.closeEntry();
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }


}
