/**
 * StudentDemo.java
 * Demonstrates: Single Inheritance, Constructors, super, method overriding (polymorphism),
 * constructor chaining and clean OOP practices.
 
 *BY TUSHAR KALDATE
  PRN : 202401040191
  BATCH: D3

 */

class Person {
    // protected so subclasses can access directly for demonstration (encapsulation still maintained)
    protected String name;
    protected int age;

    // Default constructor
    public Person() {
        this.name = "Unknown";
        this.age = 0;
    }

    // Parameterized constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        // For demonstration, show constructor being called (can be commented out later)
        // System.out.println("Person constructor called");
    }

    // Method to display person details (can be overridden by subclasses)
    public void display() {
        System.out.println("Person -> Name: " + name + ", Age: " + age);
    }
}

class Student extends Person {
    private int rollNumber;

    // Constructor chaining: calling parent constructor with super(...)
    public Student(String name, int age, int rollNumber) {
        super(name, age);              // initialize parent attributes
        this.rollNumber = rollNumber;  // initialize child attribute
        // System.out.println("Student constructor called");
    }

    // Overloaded constructor: default roll number
    public Student(String name, int age) {
        this(name, age, 0); 
        // calls the above constructor (constructor chaining)
    }

    // A method specific to Student
    public int getRollNumber() {
        return rollNumber;
    }

    // Overriding display() to provide student-specific details
    @Override
    public void display() {
        System.out.println("Student Details:");
        System.out.println("  Name       : " + name);         // inherited attribute
        System.out.println("  Age        : " + age);          // inherited attribute
        System.out.println("  Roll Number: " + rollNumber);   // student attribute
    }

    // Show parent class behaviour explicitly using super
    public void showParentDisplay() {
        System.out.print("Parent display called via super(): ");
        super.display(); // call parent's display method
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        // Create Student using parameterized constructor (demonstrates super usage)
        Student s1 = new Student("Tushar Kaldate", 20, 101);
        s1.display();

        System.out.println();

        // Show how parent class method can be invoked from child using super
        s1.showParentDisplay();

        System.out.println();

        // Polymorphism demo: parent reference pointing to child object
        Person pRef = new Student("Anita", 19, 102);
        System.out.println("Polymorphism demo (Person reference -> Student object):");
        // This will call Student.display() because of dynamic dispatch (method overriding)
        pRef.display();

        System.out.println();

        // Using overloaded constructor
        Student s2 = new Student("Rohan", 18); // roll defaults to 0
        s2.display();
    }
}
