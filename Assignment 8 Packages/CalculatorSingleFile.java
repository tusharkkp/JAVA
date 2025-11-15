import java.util.Scanner;

// ------ Addition Class ------
class Addition {
    public double add(double a, double b) {
        return a + b;
    }
}

// ------ Subtraction Class ------
class Subtraction {
    public double subtract(double a, double b) {
        return a - b;
    }
}

// ------ Multiplication Class ------
class Multiplication {
    public double multiply(double a, double b) {
        return a * b;
    }
}

// ------ Division Class ------
class Division {
    public double divide(double a, double b) {
        return a / b;
    }
}

// ------ Main Class ------
public class CalculatorSingleFile {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Addition add = new Addition();
        Subtraction sub = new Subtraction();
        Multiplication mul = new Multiplication();
        Division div = new Division();

        boolean run = true;

        System.out.println("=== Calculator (Single File Version) ===");

        while (run) {
            System.out.println("\nMenu:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 5) {
                System.out.println("Exiting... Thank you!");
                break;
            }

            System.out.print("Enter first number: ");
            double a = sc.nextDouble();

            System.out.print("Enter second number: ");
            double b = sc.nextDouble();

            switch (choice) {
                case 1 -> System.out.println("Result = " + add.add(a, b));
                case 2 -> System.out.println("Result = " + sub.subtract(a, b));
                case 3 -> System.out.println("Result = " + mul.multiply(a, b));
                case 4 -> {
                    if (b == 0)
                        System.out.println("Cannot divide by zero!");
                    else
                        System.out.println("Result = " + div.divide(a, b));
                }
                default -> System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}
