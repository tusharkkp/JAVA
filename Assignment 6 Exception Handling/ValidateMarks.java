import java.io.IOException;
import java.util.Scanner;

public class ValidateMarks {

    // method that throws IOException
    static void validateMarks(int marks) throws IOException {
        if (marks < 0 || marks > 100) {
            throw new IOException("Invalid marks! Must be between 0 and 100.");
        }
        System.out.println("Valid marks");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean run = true;
        System.out.println("=== Student Marks Validation System ===");

        while (run) {
            System.out.println("\nMenu:");
            System.out.println("1. Validate Marks");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid choice! Enter a number.");
                continue;
            }

            if (choice == 2) {
                System.out.println("Exiting...");
                break;
            }

            if (choice == 1) {
                System.out.print("Enter marks (0 - 100): ");
                try {
                    int marks = Integer.parseInt(sc.nextLine());
                    validateMarks(marks); // may throw IOException
                }
                catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                catch (NumberFormatException e) {
                    System.out.println("Error: Please enter numeric marks only.");
                }
            } 
            else {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}
