package org.ies.tierno.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class IoWriteBuffered {
    public static void main(String[] args) throws IOException {
        File dir = new File("data");
        if (!dir.exists()) dir.mkdirs();

        File file = new File(dir, "notes.txt");

        try (OutputStream os = new FileOutputStream(file, false); // false = overwrite
             Writer writer = new OutputStreamWriter(os, StandardCharsets.UTF_8);
             BufferedWriter bw = new BufferedWriter(writer)) {

            bw.write("First line");
            bw.newLine();
            bw.write("Second line");
        }

        System.out.println("Wrote file at: " + file.getAbsolutePath());
    }
}
