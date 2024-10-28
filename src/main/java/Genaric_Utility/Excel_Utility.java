package Genaric_Utility;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;

public class Excel_Utility {
    public String getExcelData(String SheetName, int rownum, int cellnum) throws Throwable {

        FileInputStream file = new FileInputStream("./Excel/VTiger.xlsx");
        Workbook book = WorkbookFactory.create(file);
        Sheet sheet = book.getSheet(SheetName);
        Row row = sheet.getRow(rownum);
        Cell cell = row.getCell(cellnum);
        String exceldata = cell.getStringCellValue();
        file.close();
        return exceldata;
    }
    public String  getExceldataUsingDataFormatter(String SheetName, int rownum, int cellnum) throws Throwable
    {
        FileInputStream file = new FileInputStream("./Excel/VTiger.xlsx");
        Workbook book = WorkbookFactory.create(file);
        Sheet sheet = book.getSheet(SheetName);
        Row row = sheet.getRow(rownum);
        Cell cell = row.getCell(cellnum);
        DataFormatter format = new DataFormatter();
        String exceldata = format.formatCellValue(cell);
        file.close();
        return exceldata; 
         }
}
