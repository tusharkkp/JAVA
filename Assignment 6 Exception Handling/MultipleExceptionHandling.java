import java.util.Scanner;

public class MultipleExceptionHandling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = {5, 10, 15, 20}; // sample array

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        System.out.print("Enter array index to access: ");
        int index = sc.nextInt();

        try {
            int result = a / b; // may throw ArithmeticException
            System.out.println("Division Result: " + result);

            System.out.println("Array Element: " + arr[index]); // may throw AIOOBE
        }
        catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid array index entered.");
        }

        System.out.println("Program completed.");
        sc.close();
    }
}
