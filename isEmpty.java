package xls;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class isEmpty {
    public static boolean isempty(Sheet SheetName , Row row , int coloum) {
        Cell c = row.getCell(coloum);
        try{
            if(c.getStringCellValue() != null)
                return false;
            return true;
        }catch(Exception e )
        {
            return true;
        }

    }
}
