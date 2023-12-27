package xls;


import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class addRestData {
    public static void createPreparedStatement(String filename , int totalColoum , String xlsFile) {
        File file = new File(filename);
        try{
            FileInputStream fis = new FileInputStream(file);
            Scanner myReader = new Scanner(fis);
            myReader.nextLine();
            String data = myReader.nextLine();
            AppendTextToFile.del(filename,data);
            String backupData = data;
            myReader.close();
            Row row = null;
            FileInputStream fs = new FileInputStream(xlsFile);
            Workbook WB = WorkbookFactory.create(fs);
            Sheet s = (Sheet) WB.getSheet(filename);
            int i = 1;
            try{
                while (i > 0  ){
                    row = s.getRow(i);
                    if(isEmpty.isempty(s,row,1))
                        break;
                    data = backupData;
                    data = data + mem(filename,totalColoum,xlsFile , i)[0];
                    Thread.sleep(20);
                    System.out.println(data);
                    AppendTextToFile.main(filename,data);
                    i++;
                }
            }catch (Exception e){
                System.out.println(e);
            }



        }catch (Exception e){
            System.out.println(e);
        }
    }



    public static String[] mem(String filename , int totalColoum , String xlsFile ,int i ) {
        String data ="";
        String me[] = new String[2];
        me[1] = "he";
        try {
            FileInputStream fs = new FileInputStream(xlsFile);
            Workbook WB = WorkbookFactory.create(fs);
            Sheet s = (Sheet) WB.getSheet(filename);

                data = data +" '"+i;
                Row r = ((org.apache.poi.ss.usermodel.Sheet) s).getRow(i);
                for(int j = 0 ; j < totalColoum;j++)
                {
                    Cell c = r.getCell(j);
                    DataFormatter dataFormatter = new DataFormatter();
                    String formattedCellStr = dataFormatter.formatCellValue(c);
                    data = data +"','"+ formattedCellStr;
                }

        }catch (Exception e ){
            System.out.println(e);
        }
        finally {
            data = data + "');";
            me[0] = data;

            return me;
        }
    }
}

