import java.util.Scanner;

// Abstract base class
abstract class BankAccount {
    protected String accountNumber;
    protected double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    abstract double calculateInterest(); // abstract method
}

// SavingsAccount subclass
class SavingsAccount extends BankAccount {
    private double rate = 4.0; // 4% interest

    SavingsAccount(String accNo, double bal) {
        super(accNo, bal);
    }

    @Override
    double calculateInterest() {
        return (balance * rate) / 100;
    }
}

// CurrentAccount subclass
class CurrentAccount extends BankAccount {
    private double rate = 2.0; // 2% interest

    CurrentAccount(String accNo, double bal) {
        super(accNo, bal);
    }

    @Override
    double calculateInterest() {
        return (balance * rate) / 100;
    }
}

public class BankAccountDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account; // polymorphism

        System.out.println("=== Bank Account Interest Calculator ===");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.print("Choose account type: ");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();

        System.out.print("Enter Balance: ");
        double bal = sc.nextDouble();

        if (choice == 1) {
            account = new SavingsAccount(accNo, bal);
        } else if (choice == 2) {
            account = new CurrentAccount(accNo, bal);
        } else {
            System.out.println("Invalid Choice!");
            sc.close();
            return;
        }

        // polymorphic method call
        double interest = account.calculateInterest();

        System.out.println("\n===== OUTPUT =====");
        System.out.println("Account Number: " + accNo);
        System.out.println("Balance: " + bal);
        System.out.println("Interest Earned: " + interest);

        sc.close();
    }
}
