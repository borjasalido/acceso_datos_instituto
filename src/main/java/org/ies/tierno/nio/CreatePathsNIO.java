package org.ies.tierno.nio;
import java.nio.file.*;
import java.io.IOException;

public class CreatePathsNIO {
    public static void main(String[] args) throws IOException {

        // Relative path
        Path relative = Path.of("docs", "example.txt");

        // Show path
        System.out.println("Relative path: " + relative.toAbsolutePath());

        // Create parent directories if they don’t exist
        Files.createDirectories(relative.getParent());

        // Create the file if it doesn’t exist
        if (Files.notExists(relative)) {
            Files.createFile(relative);
            System.out.println("File created at: " + relative.toAbsolutePath());
        }
    }
}