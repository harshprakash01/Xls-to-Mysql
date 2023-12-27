package xls;

import java.io.*;

public class AppendTextToFile {

    public static void main(String filePath , String newText) {
        try {
            // Create a FileWriter in append mode
            FileWriter fileWriter = new FileWriter(filePath, true);

            // Create a BufferedWriter to write text
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Write the new text on a new line
            bufferedWriter.newLine();
            bufferedWriter.write(newText);

            // Close the BufferedWriter
            bufferedWriter.close();

            System.out.println("Text added to the file successfully.");

        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static void del(String filePath , String lineToDelete) {
        try {
            // Read the file
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                // Skip the line to be deleted
                if (!line.equals(lineToDelete)) {
                    content.append(line).append(System.lineSeparator());
                }
            }

            bufferedReader.close();

            // Write the updated content back to the file
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
            bufferedWriter.write(content.toString());
            bufferedWriter.close();

            System.out.println("Line deleted from the file successfully.");

        } catch (IOException e) {
            System.err.println("Error processing the file: " + e.getMessage());
            e.printStackTrace();
        }
    }


}





