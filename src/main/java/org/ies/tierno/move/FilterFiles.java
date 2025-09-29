package org.ies.tierno.move;
import java.nio.file.*;
import java.io.IOException;

public class FilterFiles {
    public static void main(String[] args) throws IOException {
        Path root = Path.of("data");
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.txt");

        try (var paths = Files.walk(root)) {
            paths.filter(p -> matcher.matches(p))
                    .forEach(path -> System.out.println(path));
        }
    }
}