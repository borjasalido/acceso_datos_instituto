package org.ies.tierno.move;

import java.nio.file.*;
import static java.nio.file.StandardCopyOption.*;
import java.util.stream.Stream;

public class NioCopyDirectory {
    public static void main(String[] args) throws Exception {
        Path srcDir = Path.of("data");
        Path dstDir = Path.of("backup/data-copy");

        try (Stream<Path> sourcePaths = Files.walk(srcDir)) {
            sourcePaths.forEach(source -> {
                try {
                    Path target = dstDir.resolve(srcDir.relativize(source));

                    if (Files.isDirectory(source)) {
                        Files.createDirectories(target);
                    } else {
                        Files.copy(source, target, REPLACE_EXISTING, COPY_ATTRIBUTES);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }
        System.out.println("Directory copied to: " + dstDir.toAbsolutePath());
    }
}
