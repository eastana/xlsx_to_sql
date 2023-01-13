package org.example;

import com.opencsv.CSVWriter;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel {
    private final File readPath;
    private final File writePath;
    private static final char DELIMITER = ';';

    public ReadExcel(File readPath, File writePath) {
        this.readPath = readPath;
        this.writePath = writePath;
    }

    public void read() throws IOException {
        Sheet sheet = new XSSFWorkbook(new FileInputStream(readPath)).getSheetAt(0);
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(writePath), DELIMITER, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
            List<String[]> d1 = new ArrayList<>();

            for (Row row : sheet) {
                String[] s1 = new String[3];

                int local = 0;
                int id = 0;

                for (Cell cell : row) {
                    if (cell.getCellType().equals(CellType.STRING) || cell.getCellType().equals(CellType.NUMERIC)) {
                        if (local == 0) {
                            s1[0] = cell.getStringCellValue();
                            id++;
                        } else if (local == 2) {
                            s1[1] = cell.getStringCellValue();
                            id++;
                        }
                    }
                    local++;
                }

                if (id == 2) {
                    d1.add(s1);
                }

            }
            writer.writeAll(d1);
            writer.close();
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }
}
