package org.ies.tierno.nio;

import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

public class NioFileOverwriter {
    public static void main(String[] args) throws IOException {
        Path file = Path.of("data/notes.txt");
        Files.createDirectories(file.getParent()); // ensure folder exists

        String content = "First line\nSecond line\n";
        Files.writeString(file, content, StandardCharsets.UTF_16); // overwrite by default

        System.out.println("Wrote file at: " + file.toAbsolutePath());
    }
}