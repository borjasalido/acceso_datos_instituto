package org.ies.tierno.nio;

import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import static java.nio.file.StandardOpenOption.*;

public class NioWriteAppend {
    public static void main(String[] args) throws IOException {
        Path file = Path.of("data/notes.txt");
        Files.createDirectories(file.getParent());

        Files.writeString(file, "Appended line\n", StandardCharsets.UTF_8, CREATE, APPEND);
        System.out.println("Appended to: " + file.toAbsolutePath());
    }
}
