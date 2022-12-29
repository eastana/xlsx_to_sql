package org.example;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        final String readExcelFile = Objects.requireNonNull(Main.class.getClassLoader().getResource("code-kaz-Filtered.xlsx")).getPath();
        final String writeCSVFile = Objects.requireNonNull(Main.class.getClassLoader().getResource("codeName.csv")).getPath();
        final String sqlCreatorFile = Objects.requireNonNull(Main.class.getClassLoader().getResource("kazTitle.csv")).getPath();

        new ReadExcel(readExcelFile, writeCSVFile).read();
        new SQLCreator(sqlCreatorFile).createSQL();

    }
}

