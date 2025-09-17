package org.ies.tierno.nio;

import java.nio.file.Path;

public class PathExample {
    public static void main(String[] args)  {
        // Ruta absoluta
        Path absolutePath = Path.of("/tmp/ejemplo.txt");

        // Ruta relativa
        Path relativePath = Path.of("docs", "other", "ejemplo.txt");

        System.out.println("Ruta absoluta: " + absolutePath);
        System.out.println("Ruta relativa: " + relativePath.toAbsolutePath());
    }
}
