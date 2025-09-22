package org.ies.tierno;

import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Log4j
public class ReadFile {

    public static void main(String[] args) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get("datos.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                log.info(linea);
            }
        } catch (IOException e) {
            log.info("Error al leer el fichero: " + e.getMessage());
        }
    }
}
