import java.util.ArrayList;
import java.util.Scanner;

// Abstract base class
abstract class BankAccount {
    protected String accountNumber;
    protected double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    abstract double calculateInterest(); // interest calculation

    String getAccountNumber() { return accountNumber; }
    double getBalance() { return balance; }

    void deposit(double amt) { if (amt > 0) balance += amt; }
    boolean withdraw(double amt) {
        if (amt > 0 && amt <= balance) { balance -= amt; return true; }
        return false;
    }

    // short display
    public String toString() {
        return String.format("%s | Acc#: %s | Balance: %.2f",
            this.getClass().getSimpleName(), accountNumber, balance);
    }
}

// SavingsAccount with 4% rate
class SavingsAccount extends BankAccount {
    private double rate = 4.0;

    SavingsAccount(String accNo, double bal) { super(accNo, bal); }

    @Override
    double calculateInterest() { return (balance * rate) / 100.0; }
}

// CurrentAccount with 2% rate
class CurrentAccount extends BankAccount {
    private double rate = 2.0;

    CurrentAccount(String accNo, double bal) { super(accNo, bal); }

    @Override
    double calculateInterest() { return (balance * rate) / 100.0; }
}

public class BankAccountSystem {
    private static ArrayList<BankAccount> accounts = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        System.out.println("=== Welcome to Simple Bank System ===");

        while (running) {
            printMenu();
            int choice = readInt("Enter choice: ");
            System.out.println();

            switch (choice) {
                case 1 -> createAccountMenu();
                case 2 -> listAccounts();
                case 3 -> calculateInterestMenu();
                case 4 -> depositMenu();
                case 5 -> withdrawMenu();
                case 6 -> {
                    System.out.println("Exiting... Thank you!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
            System.out.println();
        }

        sc.close();
    }

    // menu display
    private static void printMenu() {
        System.out.println("Menu:");
        System.out.println("1. Create Account (Savings / Current)");
        System.out.println("2. List All Accounts");
        System.out.println("3. Calculate Interest for an Account");
        System.out.println("4. Deposit");
        System.out.println("5. Withdraw");
        System.out.println("6. Exit");
    }

    // create account
    private static void createAccountMenu() {
        System.out.println("Create Account:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        int type = readInt("Choose account type: ");
        sc.nextLine(); // consume newline

        String accNo = readString("Enter Account Number: ");
        double bal = readDouble("Enter Initial Balance: ");

        // check duplicate account number
        if (findAccount(accNo) != null) {
            System.out.println("Account number already exists. Try again.");
            return;
        }

        BankAccount acc;
        if (type == 1) acc = new SavingsAccount(accNo, bal);
        else if (type == 2) acc = new CurrentAccount(accNo, bal);
        else { System.out.println("Invalid account type."); return; }

        accounts.add(acc);
        System.out.println("Account created: " + acc);
    }

    // list accounts
    private static void listAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }
        System.out.println("Registered Accounts:");
        for (BankAccount a : accounts) System.out.println(" - " + a);
    }

    // calculate interest via polymorphism
    private static void calculateInterestMenu() {
        String accNo = readString("Enter Account Number to calculate interest: ");
        BankAccount a = findAccount(accNo);
        if (a == null) { System.out.println("Account not found."); return; }
        double interest = a.calculateInterest(); // polymorphic call
        System.out.printf("Account: %s\nBalance: %.2f\nInterest Earned: %.2f\n",
            a.getAccountNumber(), a.getBalance(), interest);
    }

    // deposit
    private static void depositMenu() {
        String accNo = readString("Enter Account Number to deposit: ");
        BankAccount a = findAccount(accNo);
        if (a == null) { System.out.println("Account not found."); return; }
        double amt = readDouble("Enter deposit amount: ");
        if (amt <= 0) { System.out.println("Enter positive amount."); return; }
        a.deposit(amt);
        System.out.printf("Deposit successful. New Balance: %.2f\n", a.getBalance());
    }

    // withdraw
    private static void withdrawMenu() {
        String accNo = readString("Enter Account Number to withdraw from: ");
        BankAccount a = findAccount(accNo);
        if (a == null) { System.out.println("Account not found."); return; }
        double amt = readDouble("Enter withdrawal amount: ");
        if (a.withdraw(amt)) {
            System.out.printf("Withdrawal successful. New Balance: %.2f\n", a.getBalance());
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    // helper: find by account number
    private static BankAccount findAccount(String accNo) {
        for (BankAccount a : accounts)
            if (a.getAccountNumber().equalsIgnoreCase(accNo)) return a;
        return null;
    }

    // input helpers with simple validation
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try { return Integer.parseInt(sc.nextLine().trim()); }
            catch (Exception e) { System.out.println("Invalid input. Enter integer."); }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try { return Double.parseDouble(sc.nextLine().trim()); }
            catch (Exception e) { System.out.println("Invalid input. Enter number."); }
        }
    }

    private static String readString(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }
}
