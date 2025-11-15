import java.util.Scanner;

// Abstract class
abstract class Vehicle {
    abstract void start();
    abstract void stop();
}

// Car implementation
class Car extends Vehicle {
    @Override
    void start() { System.out.println("Car starts with a key."); }
    @Override
    void stop() { System.out.println("Car stops with hydraulic brakes."); }
}

// Bike implementation
class Bike extends Vehicle {
    @Override
    void start() { System.out.println("Bike starts with a kick."); }
    @Override
    void stop() { System.out.println("Bike stops with drum brakes."); }
}

// Truck implementation
class Truck extends Vehicle {
    @Override
    void start() { System.out.println("Truck starts with a heavy ignition system."); }
    @Override
    void stop() { System.out.println("Truck stops with air brakes."); }
}

public class VehicleAbstractDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        Vehicle v;

        System.out.println("=== Vehicle Start/Stop System ===");

        while (run) {
            System.out.println("\nMenu:");
            System.out.println("1. Car");
            System.out.println("2. Bike");
            System.out.println("3. Truck");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 4) {
                System.out.println("Exiting... Thank you!");
                break;
            }

            switch (choice) {
                case 1 -> v = new Car();
                case 2 -> v = new Bike();
                case 3 -> v = new Truck();
                default -> {
                    System.out.println("Invalid choice!");
                    continue;
                }
            }

            // polymorphic calls
            System.out.println("\n=== Vehicle Actions ===");
            v.start();
            v.stop();
        }

        sc.close();
    }
}
