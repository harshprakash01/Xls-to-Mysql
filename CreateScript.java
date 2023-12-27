package xls;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class CreateScript {
    public static void ReadFirstLine(String sheetName , Workbook wb,String file){
        String[] firstColoum = new String[100];
        Sheet sheet = wb.getSheet(sheetName);
        Row row = sheet.getRow(0);
        int i = 0 ;
        while (!isEmpty.isempty(sheet,row,i)){
            Cell c = row.getCell(i);
            firstColoum[i] = c.getStringCellValue();
            i++;
        }
        mysqlTableCreate.createTable(firstColoum,sheetName,file);
    }
}



