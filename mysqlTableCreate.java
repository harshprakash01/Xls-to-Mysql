package xls;

import java.io.*;

public class mysqlTableCreate {
    public static void createTable(String rowName[] , String sheetName , String file) {
        int j = 0;
        String mysqlCreateTable="CREATE TABLE "+ sheetName+"( userid int NOT NULL AUTO_INCREMENT " ;
        int i = 0;
        while (i < rowName.length  ){
            if(rowName[i] == null)
                break;
            rowName[i] = rowName[i].replaceAll("\\s","");
            mysqlCreateTable = mysqlCreateTable + "," +rowName[i] + " varchar(250)";
            j++;
            i++;
        }
        mysqlCreateTable = mysqlCreateTable + ",PRIMARY KEY (userid)); \n" + query2(rowName,sheetName);


        String query2 = "INSERT INTO " + sheetName +"(" ;

        writeInTheFile(sheetName,mysqlCreateTable);
        addRestData.createPreparedStatement(sheetName,j,file);
    }


    public static String query2(String rowName[] , String sheetName) {
        String query2 = "INSERT INTO " + sheetName +"(userid" ;

        int i = 0;
        while (i < rowName.length  ){
            if(rowName[i] == null)
                break;
            rowName[i] = rowName[i].replaceAll("\\s","");
            query2 = query2 + "," +rowName[i] ;
            i++;
        }
        query2 = query2+") values(";
        return query2;
    }

     static void writeInTheFile(String sheetName , String sqlQuery)  {
         File fis = new File(sheetName);
         try {
             FileWriter myWriter = new FileWriter(sheetName);
             myWriter.write(sqlQuery);
             myWriter.close();
             System.out.println("Successfully wrote to the file.");
         } catch (IOException e) {
             System.out.println("An error occurred.");
             e.printStackTrace();
         }
    }
}
