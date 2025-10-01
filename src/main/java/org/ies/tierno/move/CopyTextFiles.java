package org.ies.tierno.move;


import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Log4j
public class CopyTextFiles {
    public static void main(String[] args) throws IOException {
        var sr = new Scanner(System.in);
        System.out.println("Dime una ruta que quieras copiar");
        var rutaOrigen = Path.of(sr.nextLine());
        System.out.println("Dime un a ruta donde quieras que se copie");
        var rutaDestino = Path.of(sr.nextLine());
        var matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.txt");

        if (Files.notExists(rutaOrigen)) {
            log.error("La ruta de origen no existe");
        } else {
            try (var sourcePaths = Files.list(rutaOrigen)) {
                sourcePaths
                        .filter(p -> Files.isRegularFile(p) && matcher.matches(p))
                        .forEach(source -> copy(source, rutaDestino, rutaOrigen));
            }
        }
    }

    private static void copy(Path source, Path rutaDestino, Path rutaOrigen) {
        try {
            var target = rutaDestino.resolve(rutaOrigen.relativize(source));
            if (Files.isDirectory(source)) {
                Files.createDirectories(target);
            } else {
                Files.copy(source, target, REPLACE_EXISTING, COPY_ATTRIBUTES);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}