import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileStats {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file name (with extension): ");
        String fileName = sc.nextLine();

        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = br.readLine()) != null) {
                lineCount++;
                charCount += line.length(); // count characters
                String[] words = line.trim().split("\\s+"); // split by space(s)

                if (!line.trim().isEmpty()) {
                    wordCount += words.length;
                }
            }

            // Output
            System.out.println("\n=== File Statistics ===");
            System.out.println("Total Lines      : " + lineCount);
            System.out.println("Total Words      : " + wordCount);
            System.out.println("Total Characters : " + charCount);
        }
        catch (IOException e) {
            System.out.println("Error: File not found or cannot be read.");
        }

        sc.close();
    }
}
