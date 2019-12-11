package com.jeff.datamanagesystem.service.impl;

import com.jeff.datamanagesystem.service.ExcelService;
import com.jeff.datamanagesystem.entity.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class ExcelServiceImpl implements ExcelService{

    @Override
    public List<ImageInfo> GetImageInfoList() throws IOException {
        List<ImageInfo> list = new ArrayList<>();
        InputStream ExcelFileToRead = new FileInputStream("excelFiles/ImageInfo.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);

        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row;
        XSSFCell cell;

        Iterator rows = sheet.rowIterator();
        row = (XSSFRow) rows.next();

        while(rows.hasNext()){
            row = (XSSFRow) rows.next();

            Integer id = Integer.getInteger(row.getCell(0).getStringCellValue());
            String country = row.getCell(1).getStringCellValue();
            String position = row.getCell(2).getStringCellValue();
            Integer typeID = Integer.getInteger(row.getCell(3).getStringCellValue());
            String type = row.getCell(4).getStringCellValue();
            Double ppi = row.getCell(5).getNumericCellValue();
            Double longitude = row.getCell(6).getNumericCellValue();
            Double latitude = row.getCell(7).getNumericCellValue();
            Date gatherTime = row.getCell(8).getDateCellValue();
            Integer gatherDuration = Integer.getInteger(row.getCell(9).getStringCellValue());
            Double scale = row.getCell(10).getNumericCellValue();
            String url = row.getCell(11).getStringCellValue();
            String thumbUrl = row.getCell(12).getStringCellValue();

            ImageInfo img = new ImageInfo(id, country, position, typeID, type, ppi, longitude,
                    latitude, gatherTime, gatherDuration, scale, url, thumbUrl,
                    null, null, null);

            list.add(img);
        }

        for(XSSFShape shape : sheet.getDrawingPatriarch().getShapes()){
            XSSFClientAnchor anchor = (XSSFClientAnchor) shape.getAnchor();
            if(shape instanceof XSSFPicture){
                XSSFPicture pic = (XSSFPicture) shape;

                int rowNum = anchor.getRow2();
                String fileName = sheet.getRow(rowNum).getCell(0).getStringCellValue();

                FileOutputStream out = new FileOutputStream("excelFiles\\images\\" + fileName + ".jpg");
                out.write(pic.getPictureData().getData());
            }
        }

        return list;
    }

    @Override
    public List<Type> GetTypeList() throws IOException {
        List<Type> list = new ArrayList<>();
        InputStream ExcelFileToRead = new FileInputStream("excelFiles/Type.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);

        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row;

        Iterator rows = sheet.rowIterator();
        row = (XSSFRow) rows.next();

        while(rows.hasNext()){
            row = (XSSFRow) rows.next();

            String name = row.getCell(0).getStringCellValue();
            String description = row.getCell(1).getStringCellValue();

            Type type = new Type(null, name, description, null, null, null);

            list.add(type);
        }

        return list;
    }

    @Override
    public List<User> GetUserList() throws IOException{
        List<User> list = new ArrayList<>();
        InputStream ExcelFileToRead = new FileInputStream("excelFiles/User.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);

        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row;

        Iterator rows = sheet.rowIterator();
        row = (XSSFRow) rows.next();

        while(rows.hasNext()){
            row = (XSSFRow) rows.next();

            Integer id = Integer.getInteger(row.getCell(0).getStringCellValue());
            String username = row.getCell(1).getStringCellValue();
            String password = row. getCell(2).getStringCellValue();
            String email = row.getCell(3).getStringCellValue();
            String name = row.getCell(4).getStringCellValue();
            Integer status = Integer.getInteger(row.getCell(5).getStringCellValue());
            String statusName = row.getCell(6).getStringCellValue();

            User user = new User(id, username, password, email, name, status, statusName,
                    null, null);

            list.add(user);
        }

        return list;
    }


//    public static final String OFFICE_EXCEL_XLS = "xls";
//    public static final String OFFICE_EXCEL_XLSX = "xlsx";
//
//    public static List<String> readXLSFlie() throws IOException{
//        List<String> list = new ArrayList<>();
//
//        InputStream ExcelFileToRead = new FileInputStream("excelFiles/test1.xls");
//        HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
//
//        HSSFSheet sheet = wb.getSheetAt(0);
//        HSSFRow row;
//        HSSFCell cell;
//
//        Iterator rows = sheet.rowIterator();
//
//        while(rows.hasNext()){
//            row = (HSSFRow) rows.next();
//            Iterator cells = row.cellIterator();
//
//            StringBuilder str = new StringBuilder("");
//            while(cells.hasNext()){
//                cell = (HSSFCell)cells.next();
//                str.append(cell.getStringCellValue()).append('#');
//            }
//            list.add(str.toString());
//        }
//
//        return list;
//    }
//
//    public static List<String> readXLSXFile() throws IOException{
//        List<String> list = new ArrayList<>();
//
//        InputStream ExcelFileToRead = new FileInputStream("excelFiles/test2.xlsx");
//        XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
//
//        XSSFSheet sheet = wb.getSheetAt(0);
//        XSSFRow row;
//        XSSFCell cell;
//
//        Iterator rows = sheet.rowIterator();
//
//        while(rows.hasNext()){
//            row = (XSSFRow) rows.next();
//            Iterator cells = row.cellIterator();
//
//            StringBuilder str = new StringBuilder("");
//            while(cells.hasNext())
//            {
//
//                cell = (XSSFCell) cells.next();
//                str.append(cell.getStringCellValue()).append('#');
//            }
//            list.add(str.toString());
//        }
//
//        return list;
//    }

}
