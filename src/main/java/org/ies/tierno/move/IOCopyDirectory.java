package org.ies.tierno.move;

import lombok.extern.log4j.Log4j;
import java.io.*;

@Log4j
public class IOCopyDirectory {
    public static void copyDir(File src, File dst) throws IOException {
        if (src.isDirectory()) {
            dst.mkdirs();
            File[] children = src.listFiles();
            if (children != null) {
                for (File c : children) {
                    copyDir(c, new File(dst, c.getName()));
                }
            }
        } else {
            try (InputStream in = new BufferedInputStream(new FileInputStream(src));
                 OutputStream out = new BufferedOutputStream(new FileOutputStream(dst))) {
                in.transferTo(out);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        File srcDir = new File("data");
        File dstDir = new File("backup/data-copy");
        copyDir(srcDir, dstDir);
        System.out.println("Directory copied to: " + dstDir.getAbsolutePath());
    }
}
