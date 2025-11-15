import java.util.Scanner;

/**
 * VehicleDemo.java
 * Multilevel Inheritance with User Input
 * Classes: Vehicle -> Car -> SportsCar
 * Demonstrates: constructors, super(), method overriding,
 * parent method access, polymorphism, user input.
 * 
 *  *BY
 * TUSHAR KALDATE
  PRN : 202401040191
  BATCH: D3

 * 
 */

class Vehicle {
    protected int speed;

    public Vehicle(int speed) {
        this.speed = speed;
    }

    public void showDetails() {
        System.out.println("Vehicle Details:");
        System.out.println("  Speed: " + speed + " km/h");
    }
}

class Car extends Vehicle {
    protected String brand;

    public Car(int speed, String brand) {
        super(speed);     // calling Vehicle constructor
        this.brand = brand;
    }

    @Override
    public void showDetails() {
        System.out.println("Car Details:");
        System.out.println("  Speed: " + speed + " km/h");
        System.out.println("  Brand: " + brand);
    }

    public void showParentDetails() {
        System.out.print("Calling Vehicle.showDetails() via super(): ");
        super.showDetails();
    }
}

class SportsCar extends Car {
    private boolean turbo;

    public SportsCar(int speed, String brand, boolean turbo) {
        super(speed, brand);   // calling Car constructor
        this.turbo = turbo;
    }

    @Override
    public void showDetails() {
        System.out.println("SportsCar Details:");
        System.out.println("  Speed : " + speed + " km/h");
        System.out.println("  Brand : " + brand);
        System.out.println("  Turbo : " + (turbo ? "Enabled" : "Disabled"));
    }

    public void showCarDetailsUsingSuper() {
        System.out.println("Calling Car.showDetails() using super():");
        super.showDetails();
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input from user
        System.out.print("Enter Speed of SportsCar: ");
        int speed = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Brand of SportsCar: ");
        String brand = sc.nextLine();

        System.out.print("Enable Turbo? (yes/no): ");
        String turboInput = sc.nextLine();
        boolean turbo = turboInput.equalsIgnoreCase("yes");

        // Create object from user input
        SportsCar scObj = new SportsCar(speed, brand, turbo);

        System.out.println("\n===== OUTPUT =====\n");

        // Level 3: SportsCar details
        scObj.showDetails();

        System.out.println();
        // Level 2: Car details via super
        scObj.showCarDetailsUsingSuper();

        System.out.println();
        // Level 1: Vehicle details via super of Car
        scObj.showParentDetails();

        System.out.println();
        // Polymorphism demo
        Vehicle vp = new SportsCar(280, "Lamborghini", true);
        System.out.println("Polymorphism Demo (Vehicle reference to SportsCar object):");
        vp.showDetails();

        sc.close();
    }
}
