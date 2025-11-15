import java.util.Scanner;

/**
 * Demonstrates:
 * - Method Overriding
 * - super keyword
 * - Runtime Polymorphism
 * - User Input
 * BY
 * TUSHAR KALDATE
  PRN : 202401040191
  BATCH: D3
 */

class Bank {
    public double rateOfInterest() {
        return 5.0;   // Default base rate
    }

    public void showRate() {
        System.out.println("Bank Interest Rate: " + rateOfInterest() + "%");
    }
}

class SBI extends Bank {

    @Override
    public double rateOfInterest() {
        return 6.5;   // SBI specific rate
    }

    // Using super to show parent class method value
    public void showParentRate() {
        System.out.println("Using super in SBI:");
        System.out.println("  Parent Bank Rate = " + super.rateOfInterest() + "%");
        System.out.println("  SBI Rate         = " + this.rateOfInterest() + "%");
    }
}

class HDFC extends Bank {

    @Override
    public double rateOfInterest() {
        return 7.2;   // HDFC specific rate
    }
}

public class BankDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Choose Bank ===");
        System.out.println("1. SBI");
        System.out.println("2. HDFC");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        Bank bankRef;  // Parent reference - used for polymorphism

        System.out.println("\n===== OUTPUT =====");

        if (choice == 1) {
            bankRef = new SBI();
            bankRef.showRate();          // Polymorphic call

            System.out.println();
            ((SBI)bankRef).showParentRate();  // Using super demonstration

        } else if (choice == 2) {
            bankRef = new HDFC();
            bankRef.showRate();          // Polymorphic call

        } else {
            System.out.println("Invalid choice!");
            sc.close();
            return;
        }

        sc.close();
    }
}
