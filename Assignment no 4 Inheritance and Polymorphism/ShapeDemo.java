import java.util.Scanner;

/**
 * Hierarchical Inheritance:
 * Shape (parent) -> Circle, Rectangle (children)
 * Demonstrates method overriding + polymorphism + user input
 * 
 *  *  *BY
 * TUSHAR KALDATE
  PRN : 202401040191
  BATCH: D3
 * 
 */

class Shape {
    // Parent class method to be overridden
    public double area() {
        return 0;
    }

    public void showArea() {
        System.out.println("Area: " + area());
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public void showArea() {
        System.out.println("Circle Area = " + area());
    }
}

class Rectangle extends Shape {
    private double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public void showArea() {
        System.out.println("Rectangle Area = " + area());
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("------ Calculate Circle Area ------");
        System.out.print("Enter radius: ");
        double radius = sc.nextDouble();

        System.out.println("\n------ Calculate Rectangle Area ------");
        System.out.print("Enter length: ");
        double length = sc.nextDouble();
        System.out.print("Enter width: ");
        double width = sc.nextDouble();

        System.out.println("\n===== OUTPUT =====");

        // Polymorphism demonstration
        Shape s1 = new Circle(radius);         // Shape reference → Circle object
        Shape s2 = new Rectangle(length, width); // Shape reference → Rectangle object

        s1.showArea();   // Calls Circle.area()
        s2.showArea();   // Calls Rectangle.area()

        sc.close();
    }
}
