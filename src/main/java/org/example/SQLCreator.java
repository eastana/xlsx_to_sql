package org.example;

import java.io.*;
import java.util.Scanner;

public class SQLCreator {
    private final String writeFile;

    public SQLCreator(String writeFile) {
        this.writeFile = writeFile;
    }

    public void createSQL() throws FileNotFoundException {
        Scanner sc = new Scanner(new File(writeFile));
        try (sc) {
            sc.useDelimiter(";");
            StringBuilder s = new StringBuilder();
            String s1 = "";
            String s2 = "";
            while (sc.hasNext()) {
                s1 = "";
                s2 = "";

                s.append("UPDATE navigation_node \nSET title_kz = \'");
                if (sc.hasNext()) {
                    s1 = sc.next();
                }
                if (sc.hasNext()) {
                    s2 = sc.next();
                }
                s.append(s2.trim()).append("\' WHERE root = 'catalog-categories' AND code = \'").append(s1.trim()).append("\'; \n\n\n");
            }
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(writeFile), "utf-8"))) {
                writer.write(s.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
