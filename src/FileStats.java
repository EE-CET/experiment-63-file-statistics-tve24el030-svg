import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileStats {
    public static void main(String[] args) {
        String fileName = "sample.txt";
        
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        // Use try-with-resources to ensure the reader is closed automatically
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            
            // Read the file line by line until it returns null
            while ((line = reader.readLine()) != null) {
                
                // Increment line count
                lineCount++;
                
                // Add the length of the current line to character count
                charCount += line.length();
                
                // Split the line into words and count them
                if (!line.trim().isEmpty()) {
                    String[] words = line.trim().split("\\s+");
                    wordCount += words.length;
                }
            }
            
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Output the results
        System.out.println("Lines: " + lineCount);
        System.out.println("Words: " + wordCount);
        System.out.println("Characters: " + charCount);
    }
}