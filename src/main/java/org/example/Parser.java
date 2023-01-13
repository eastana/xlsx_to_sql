package org.example;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

public class Parser {
    public Parser() {
    }

    public void run() throws IOException, URISyntaxException {
        final File readExcelFile = new File(Objects.requireNonNull(Parser.class.getClassLoader().getResource("code-kaz-Filtered.xlsx")).toURI());
        final File writeCSVFile = new File(Objects.requireNonNull(Parser.class.getClassLoader().getResource("codeName.csv")).toURI());
        final File sqlCreatorFile = new File(Objects.requireNonNull(Parser.class.getClassLoader().getResource("init.sql")).toURI());

        new ReadExcel(readExcelFile, writeCSVFile).read();
        new SQLCreator(writeCSVFile, sqlCreatorFile).createSQL();
    }
}
