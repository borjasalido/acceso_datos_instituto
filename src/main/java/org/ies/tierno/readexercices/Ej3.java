package org.ies.tierno.readexercices;

import lombok.extern.log4j.Log4j;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

@Log4j
public class Ej3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        log.info
                ("Introduzca la ruta de un fichero de entrada");
        String entry = sc.nextLine();
        Path ruta1 = Path.of(entry);

        log.info
                ("Introduzca la ruta de un fichero de salida");
        String exit = sc.nextLine();
        Path ruta2 = Path.of(exit);
        try {
            if(!Files.exists(ruta1)) {
                log.error("Error");
            }
            else{
                String contenido = Files.readString(ruta1);
                Files.createDirectories(ruta2.getParent());
                Files.writeString(ruta2, contenido, StandardCharsets.UTF_8,CREATE, APPEND);
            }

        }
        catch (Exception e){
            e.printStackTrace();
            log.error("Error de E/S");
        }
    }
} 