import java.io.*;
import java.util.Scanner;

public class FileCopy {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter source file name: ");
        String source = sc.nextLine();

        System.out.print("Enter destination file name: ");
        String destination = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(source));
             BufferedWriter bw = new BufferedWriter(new FileWriter(destination))) {

            String line;

            // copy line by line
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }

            System.out.println("\nFile copied successfully!");
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
