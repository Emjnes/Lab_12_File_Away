import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class Lab_12_File_Away {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose a text file");

        // Open file chooser dialog
        int userSelection = fileChooser.showOpenDialog(null);

        // If user selects a file
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToProcess = fileChooser.getSelectedFile();

            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileToProcess));
                String line;
                int lineCount = 0;
                int wordCount = 0;
                int characterCount = 0;

                // Read file line by line
                while ((line = reader.readLine()) != null) {
                    lineCount++;

                    // Count words
                    String[] words = line.split("\\s+");
                    wordCount += words.length;

                    // Count characters
                    characterCount += line.length();
                }

                // Close the reader
                reader.close();

                // Print summary report
                System.out.println("Summary Report:");
                System.out.println("File Name: " + fileToProcess.getName());
                System.out.println("Number of Lines: " + lineCount);
                System.out.println("Number of Words: " + wordCount);
                System.out.println("Number of Characters: " + characterCount);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No file selected.");
        }
    }
}
