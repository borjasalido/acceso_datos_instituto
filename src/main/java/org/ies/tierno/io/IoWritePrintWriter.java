package org.ies.tierno.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class IoWritePrintWriter {
    public static void main(String[] args) throws IOException {
        File file = new File("data/report.txt");
        file.getParentFile().mkdirs();

        try (var os = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
             var pw = new PrintWriter(os)) {
            pw.println("Header");
            pw.printf("Item: %s | Price: %.5f%n", "Book", 19.99);
        }

        System.out.println("Report written: " + file.getAbsolutePath());
    }
}
