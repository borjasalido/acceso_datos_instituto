package org.ies.tierno.io;

import java.io.File;

public class FileExample {
    public static void main(String[] args) {
        // Ruta absoluta
        File absolute = new File("/tmp/ejemplo.txt");

        // Ruta relativa (se interpreta desde el directorio actual de ejecución)
        File relative = new File("docs/ejemplo.txt");

        // Mostrar resultados
        System.out.println("Ruta absoluta: " + absolute.getPath());
        System.out.println("Ruta relativa convertida a absoluta: " + relative.getAbsolutePath());
    }
}
