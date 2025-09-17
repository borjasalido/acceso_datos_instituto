package org.ies.tierno.io;

import java.io.File;
import java.io.IOException;

public class CreatePathsIO {
    public static void main(String[] args) throws IOException {
        // Relative path (from the program’s working directory)
        File relative = new File("nio/docs/example.txt");

        // Show path
        System.out.println("Relative path: " + relative.getAbsolutePath());

        // Create parent directories if they don’t exist
        if (!relative.getParentFile().exists()) {
            relative.getParentFile().mkdirs();
        }

        // Create the file if it doesn’t exist
        if (!relative.exists()) {
            relative.createNewFile();
            System.out.println("File created at: " + relative.getAbsolutePath());
        }
    }
}
