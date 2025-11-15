import java.util.Scanner;

/**
 * Real-Life Scenario:
 * Employee (parent) → Manager, Developer (children)
 * Demonstrates: Inheritance, Method Overriding, User Input
  *  *  *BY
 * TUSHAR KALDATE
  PRN : 202401040191
  BATCH: D3
 */

class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("  Name   : " + name);
        System.out.println("  Salary : " + salary);
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary); // Call parent constructor
        this.bonus = bonus;
    }

    @Override
    public void displayDetails() {
        System.out.println("Manager Details:");
        System.out.println("  Name   : " + name);
        System.out.println("  Salary : " + salary);
        System.out.println("  Bonus  : " + bonus);
        System.out.println("  Total Compensation : " + (salary + bonus));
    }
}

class Developer extends Employee {
    private String programmingLanguage;

    public Developer(String name, double salary, String programmingLanguage) {
        super(name, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void displayDetails() {
        System.out.println("Developer Details:");
        System.out.println("  Name               : " + name);
        System.out.println("  Salary             : " + salary);
        System.out.println("  Programming Lang   : " + programmingLanguage);
    }
}

public class EmployeeDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee emp;

        System.out.println("=== Employee Type ===");
        System.out.println("1. Manager");
        System.out.println("2. Developer");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        if (choice == 1) {
            System.out.print("Enter Bonus: ");
            double bonus = sc.nextDouble();
            emp = new Manager(name, salary, bonus);

        } else if (choice == 2) {
            System.out.print("Enter Programming Language: ");
            String lang = sc.nextLine();
            emp = new Developer(name, salary, lang);

        } else {
            System.out.println("Invalid choice!");
            sc.close();
            return;
        }

        System.out.println("\n===== OUTPUT =====");
        emp.displayDetails(); // Polymorphic call

        sc.close();
    }
}
