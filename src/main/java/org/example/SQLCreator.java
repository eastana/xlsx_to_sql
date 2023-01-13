package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SQLCreator {
    private final File writeFile;
    private final File sqlWriteFile;
    private static final String DELIMITER = ";";

    public SQLCreator(File writeFile, File sqlWriteFile) {
        this.writeFile = writeFile;
        this.sqlWriteFile = sqlWriteFile;
    }

    public void createSQL() throws FileNotFoundException {
        Scanner sc = new Scanner(writeFile);
        try (sc) {
            sc.useDelimiter(DELIMITER);
            StringBuilder s = new StringBuilder();
            String s1;
            String s2;
            while (sc.hasNext()) {
                s1 = "";
                s2 = "";

                s.append("UPDATE navigation_node \nSET title_kz = '");
                if (sc.hasNext()) {
                    s1 = sc.next();
                }
                if (sc.hasNext()) {
                    s2 = sc.next();
                }
                s.append(s2.trim()).append("' WHERE root = 'catalog-categories' AND code = '").append(s1.trim()).append("'; \n\n\n");
            }
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(sqlWriteFile), StandardCharsets.UTF_8))) {
                writer.write(s.toString());
                System.out.println(s);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
