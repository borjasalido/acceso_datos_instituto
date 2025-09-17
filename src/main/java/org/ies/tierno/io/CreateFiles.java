package org.ies.tierno.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CreateFiles {

    public static void createFile(String path) throws IOException {
        File file = new File(path);
        if(!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        if(!file.exists()) {
            file.createNewFile();
        } else {
            System.out.println("El archivo " + path +" ya existe");
        }
    }

    public static void main(String[] args) {
        try {
            createFile("/tmp/1/a.txt");
            createFile("/tmp/2/b.txt");
            createFile("1/a.txt");
            createFile("2/b.txt");
            System.out.println("Archivos creados satisfactoriamente");
        } catch (IOException e) {
            System.out.println("Error creando archivo " + e.getMessage());
        }
    }
}
