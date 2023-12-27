package xls;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class read {

    public static List<String>  read(String file) {
        Properties p = new Properties();
        try {
            FileInputStream fs = new FileInputStream(file);
            Workbook wb = WorkbookFactory.create(fs);
            List<String> sheetNames = new ArrayList<String>();
            for (int i=0; i<wb.getNumberOfSheets(); i++) {
                sheetNames.add( wb.getSheetName(i) );
            }
            System.out.println(sheetNames);

            for(int i = 0 ; i < sheetNames.size() ; i++){
                CreateScript.ReadFirstLine(sheetNames.get(i) , wb ,file);
            }
            return sheetNames;
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
