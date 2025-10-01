package org.ies.tierno.move;


import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.file.StandardCopyOption.*;

@Log4j
public class ReursiveMoveTextFiles {
    public static void main(String[] args) throws IOException {
        var sr = new Scanner(System.in);
        System.out.println("Dime una ruta que quieras copiar");
        var sourceDir = Path.of(sr.nextLine());
        System.out.println("Dime un a ruta donde quieras que se copie");
        var destDir = Path.of(sr.nextLine());
        var matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.txt");

        if (Files.notExists(sourceDir)) {
            log.error("La ruta de origen no existe");
        } else {
            try (var sourcePaths = Files.walk(sourceDir)) {
                sourcePaths
                        .filter(p -> Files.isRegularFile(p) && matcher.matches(p))
                        .forEach(source -> {
                            try {
                                var dest = destDir.resolve(sourceDir.relativize(source));
                                Files.createDirectories(dest.getParent());
                                Files.move(source, dest, REPLACE_EXISTING, ATOMIC_MOVE);
                            }catch (IOException e) {
                                log.error("Error al mover el archivo",e );
                            }
                        });
            }
        }
    }

}