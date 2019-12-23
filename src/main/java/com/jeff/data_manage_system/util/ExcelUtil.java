package com.jeff.data_manage_system.util;

import org.apache.commons.math3.analysis.function.Ceil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtil {

    public static Iterator<Row> getRowIterator(File excelFile) throws IOException {
        InputStream excelInputStream = new FileInputStream(excelFile);
        XSSFWorkbook workbook = new XSSFWorkbook(excelInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        return sheet.rowIterator();
    }

    public static List<String> getCellValues(Row row) {
        List<String> cellValueList = new ArrayList<>();
        int count = row.getLastCellNum();
        for(int i = 0; i < count; i++){
            Cell cell = row.getCell(i);
            cell.setCellType(CellType.STRING);
            cellValueList.add(row.getCell(i).getStringCellValue());
        }
        return cellValueList;
    }
}
