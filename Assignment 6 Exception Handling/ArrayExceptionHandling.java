import java.util.Scanner;

public class ArrayExceptionHandling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = {10, 20, 30, 40, 50}; // fixed array
        boolean run = true;

        System.out.println("=== Array Exception Handling Program ===");

        while (run) {
            System.out.println("\nMenu:");
            System.out.println("1. Display element by index");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine()); 
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice! Please enter a number.");
                continue;
            }

            if (choice == 2) {
                System.out.println("Exiting...");
                break;
            }

            System.out.print("Enter index to display: ");
            try {
                int index = Integer.parseInt(sc.nextLine()); 
                System.out.println("Element at index " + index + ": " + arr[index]);
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Invalid index! Please enter between 0 and " + (arr.length - 1));
            }
            catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid integer index!");
            }
            finally {
                System.out.println("End of program.");
            }
        }

        sc.close();
    }
}
