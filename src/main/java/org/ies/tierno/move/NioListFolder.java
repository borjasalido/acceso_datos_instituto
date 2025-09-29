package org.ies.tierno.move;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NioListFolder {
    public static void main(String[] args) throws IOException {
        Path dir = Path.of("data");
        try (var stream = Files.list(dir)) {
            stream.forEach(path -> System.out.println(path));
        }
    }
}
