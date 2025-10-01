package org.ies.tierno.move;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class RecursiveDeletePdf {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        System.out.println("Escriba una ruta de directorio.");
        var rt1 = Path.of(sc.nextLine());
        if (!Files.exists(rt1) ) {
            System.err.println("No existe el directorio de origen");
        } else if(!Files.isDirectory(rt1)) {
            System.out.println("No es un directorio");
        }else {
            var matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.pdf");
            try (var paths = Files.walk(rt1)) {
                paths.filter(p -> Files.isRegularFile(p) && matcher.matches(p))
                        .forEach(path -> {
                            try {
                                Files.delete(path);
                            } catch (IOException e) {
                                e.getStackTrace();
                            }
                        });
            } catch (IOException e) {
                e.getStackTrace();
            }
        }
    }
}