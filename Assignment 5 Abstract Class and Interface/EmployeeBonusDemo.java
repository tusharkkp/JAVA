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

    void display() {
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
    double calculateBonus() {
        return salary * 0.20;
    }
}

// Developer → 10% bonus
class Developer extends Employee {
    Developer(String name, double salary) {
        super(name, salary);
    }

    @Override
    double calculateBonus() {
        return salary * 0.10;
    }
}

// Intern → No bonus
class Intern extends Employee {
    Intern(String name, double salary) {
        super(name, salary);
    }

    @Override
    double calculateBonus() {
        return 0;
    }
}

public class EmployeeBonusDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee emp; // polymorphism

        System.out.println("=== Employee Bonus Calculator ===");
        System.out.println("1. Manager");
        System.out.println("2. Developer");
        System.out.println("3. Intern");
        System.out.print("Choose employee type: ");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        if (choice == 1)
            emp = new Manager(name, salary);
        else if (choice == 2)
            emp = new Developer(name, salary);
        else if (choice == 3)
            emp = new Intern(name, salary);
        else {
            System.out.println("Invalid choice!");
            sc.close();
            return;
        }

        System.out.println("\n===== EMPLOYEE DETAILS =====");
        emp.display(); // polymorphic call

        sc.close();
    }
}
