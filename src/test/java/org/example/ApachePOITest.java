package org.example;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
//https://www.javatpoint.com/apache-poi-merging-cells
public class ApachePOITest {

    public static void main(String[] args) throws IOException {
        Workbook wb=new HSSFWorkbook();
        FileOutputStream fos=new FileOutputStream(System.getProperty("user.dir")+"\\XLSTest.xls");
        Sheet sheet1= wb.createSheet("First Sheet");
        Sheet sheet2= wb.createSheet("Second Sheet");
        Sheet sheet3=wb.createSheet("newSheet");
        Row row=sheet3.createRow(2);
        Cell cell=row.createCell(5);
        cell.setCellValue("Test");
        wb.write(fos);
        fos.close();

    }
}
