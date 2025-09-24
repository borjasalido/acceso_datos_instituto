package org.ies.tierno.readexercices;

import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Scanner;

@Log4j
public class Ej1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        log.info("Introduce una ruta");
        var path = Path.of(scanner.nextLine());
        try (var br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {
                log.info(line);
            }

        } catch (NoSuchFileException e) {
            log.error("No se ha encontrado el archivo " + path.toAbsolutePath());
        } catch (IOException e) {
            log.error("Error al leer el archivo", e);
        }
    }
}
