import java.util.Scanner;

// Abstract class
abstract class Employee {
    protected String name;
    protected double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract double calculateBonus(); // abstract method

    void showDetails() {
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("Bonus: " + calculateBonus());
    }
}

// Manager → 20% bonus
class Manager extends Employee {
    Manager(String name, double salary) {
        super(name, salary);
    }
    @Override
    double calculateBonus() { return salary * 0.20; }
}

// Developer → 10% bonus
class Developer extends Employee {
    Developer(String name, double salary) {
        super(name, salary);
    }
    @Override
    double calculateBonus() { return salary * 0.10; }
}

// Intern → 0 bonus
class Intern extends Employee {
    Intern(String name, double salary) {
        super(name, salary);
    }
    @Override
    double calculateBonus() { return 0; }
}

public class EmployeeSalaryManagement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;

        System.out.println("=== Employee Salary Management System ===");

        while (run) {
            System.out.println("\nMenu:");
            System.out.println("1. Calculate Manager Bonus");
            System.out.println("2. Calculate Developer Bonus");
            System.out.println("3. Calculate Intern Bonus");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 4) {
                System.out.println("Exiting... Thank you!");
                run = false;
                break;
            }

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            Employee emp;

            switch (choice) {
                case 1 -> emp = new Manager(name, salary);
                case 2 -> emp = new Developer(name, salary);
                case 3 -> emp = new Intern(name, salary);
                default -> {
                    System.out.println("Invalid choice!");
                    continue;
                }
            }

            System.out.println("\n=== Employee Details ===");
            emp.showDetails(); // polymorphic call
        }

        sc.close();
    }
}
