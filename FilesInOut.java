import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

/**
 * 
 * CSCU9T4 Java strings and files exercise.
 *
 */
public class FilesInOut {
    public static void main(String[] args) {
        File inputFile = new File("C:\\Users\\Lenovo\\Downloads\\CSCUT4Practical2-main\\CSCUT4Practical2-main\\input.txt");
        File outputFile = new File("output.txt");
        
        try (Scanner scanner = new Scanner(inputFile);
        	     PrintWriter writer = new PrintWriter(outputFile)) {

        	    while (scanner.hasNextLine()) {
        	        String line = scanner.nextLine();
        	        String[] words = line.split(" ");
        	        StringBuilder formattedName = new StringBuilder();
        	        String formattedDate = "";
 // format name
        	        for (int i = 0; i < words.length; i++) {
        	            String word = words[i];

        	            if (i == 0) {
        	                String formattedWord = Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
        	                formattedName.append(formattedWord);
        	            } else if (i == 1 && word.length() == 2) {
        	                formattedName.append(". ").append(word.toUpperCase());
        	            } else if (i == words.length - 1) {
        	                String formattedWord = Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
        	                formattedName.append(" ").append(formattedWord.replaceAll("\\d", ""));
        	            } else {
        	                String formattedWord = Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
        	                formattedName.append(" ").append(formattedWord.replaceAll("\\d", ""));
        	            }
        	        }
// format date
        	        int dateIndex = line.lastIndexOf(" ");
        	        String dateString = line.substring(dateIndex + 1);
        	        String day = dateString.substring(0, 2);
        	        String month = dateString.substring(2, 4);
        	        String year = dateString.substring(4);
        	        formattedDate = day + "/" + month + "/" + year;
 // write formatted output to file
        	        writer.println(formattedName.toString() + " " + formattedDate);
        	    }
            
    System.out.println("Output written to " + outputFile.getAbsolutePath());
        	} catch (FileNotFoundException e) {
        	    System.err.println("File not found: " + e.getMessage());
        	} catch (Exception e) {
        	    System.err.println("An error occurred: " + e.getMessage());
        	}
    }
    }

