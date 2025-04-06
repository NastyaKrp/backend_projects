package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Zip {
    public static void Arch(String path) throws IOException {
        try(ZipInputStream zin = new ZipInputStream(new FileInputStream(path)))
        {
            ZipEntry entry;
            String name;
            long size;
            while((entry=zin.getNextEntry())!=null){

                name = entry.getName();
                size = entry.getSize();
                //System.out.printf("File name: %s \t File size: %d \n", name, size);

                FileOutputStream fout = new FileOutputStream("new" + name);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }

    public static void Z(String filename, String zip_file) throws Exception
    {
        try(ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(zip_file));
            FileInputStream fis = new FileInputStream(filename);)
        {
            ZipEntry entry1 = new ZipEntry(filename);
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
