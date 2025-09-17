package org.ies.tierno;

import java.io.IOException;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class Notas {
    public static void main(String[] args)  {
        Path file = Path.of("/tmp/nota.txt");

        try {
            // Escribir en el fichero
            Files.writeString(file, "Recordar comprar pan\n", StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo");
        }
        try{
            // Leer del fichero
            String content = Files.readString(file, StandardCharsets.UTF_8);

            System.out.println("La nota guardada es: " + content);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
    }
}