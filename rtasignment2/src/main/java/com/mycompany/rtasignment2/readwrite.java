/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rtasignment2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author User
 */
public class readwrite {

    Writer writer = null;

    boolean test = true;

    public void createFile() throws IOException {
        File file = new File("C:/Users/User/desktop/test.txt");
        writer = new BufferedWriter(new FileWriter(file));
    }

    public void readData() throws IOException, InvalidFormatException {
        System.out.println("Generating new txt file......\n");
        createFile();

        Workbook workbook = WorkbookFactory.create(new File("C:/Users/User/Documents/listAsg1.xlsx"));
        Sheet sheet = workbook.getSheetAt(0);
        System.out.println("Read from xlsx file......\n");
        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();
        System.out.println("Write to txt file......\n");
        Iterator<Row> rowIterator = sheet.rowIterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // Iterate over the columns of the current row
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String cellValue = dataFormatter.formatCellValue(cell);
                //System.out.print(cellValue + " ");
                writer.write(cellValue + " ");
            }
            //System.out.println();
            writer.write("\n");

        }
        System.out.println("Closing txt file......\n");
        closeFile();
    }

    public void closeFile() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
