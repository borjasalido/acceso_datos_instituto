package org.ies.tierno.nio;

import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.List;

import java.nio.file.StandardOpenOption;


public class NioWriteLines {
    public static void main(String[] args) throws IOException {
        Path file = Path.of("data/lines.txt");
        Files.createDirectories(file.getParent());

        List<String> lines = List.of("alpha", "beta", "gamma");
        Files.write(file, lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND); // overwrite

        System.out.println("Lines written to: " + file.toAbsolutePath());
    }
}