import java.util.Scanner;

public class DivisionExceptionHandling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;

        System.out.println("=== Division Calculator with Exception Handling ===");

        while (run) {
            System.out.println("\nMenu:");
            System.out.println("1. Perform Division");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 2) {
                System.out.println("Exiting... Thank you!");
                break;
            }

            System.out.print("Enter Numerator: ");
            int num = sc.nextInt();

            System.out.print("Enter Denominator: ");
            int den = sc.nextInt();

            try {
                int result = num / den; // may throw ArithmeticException
                System.out.println("Result: " + result);
            }
            catch (ArithmeticException e) {
                System.out.println("Error: Cannot divide by zero!");
            }
            finally {
                System.out.println("Division operation completed.");
            }
        }

        sc.close();
    }
}
