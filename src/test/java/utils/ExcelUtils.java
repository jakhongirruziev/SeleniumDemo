package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtils {
    private XSSFWorkbook workbook;
    private final XSSFSheet sheet;


    public ExcelUtils(String excelFilePath, String sheetName) {
        try {
            workbook = new XSSFWorkbook(excelFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = workbook.getSheet(sheetName);
    }

    public int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    public int getColumnCount() {
        return sheet.getRow(0).getPhysicalNumberOfCells();
    }

    public String getCellData(int rowNum, int columnNum) {
        return sheet.getRow(rowNum).getCell(columnNum).getStringCellValue();
    }
}
