package org.ies.tierno.readexercices;

import lombok.extern.log4j.Log4j;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@Log4j
public class Ej2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        log.info("Introduce la ruta");
        File file = new File(scanner.nextLine());
        if(file.getParentFile() != null && !file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        log.info("Introduce el contenido del archivo:");
        String content = scanner.nextLine();

        try(var pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8))){
            pw.println(content);
        } catch (IOException e ) {
            log.error("Error al escribir el archivo", e);
        }
    }
}
