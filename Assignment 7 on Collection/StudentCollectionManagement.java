import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    double marks;

    Student(int rollNo, String name, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name + ", Marks: " + marks;
    }
}

public class StudentCollectionManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();

        boolean run = true;
        System.out.println("=== Student Collection Management System ===");

        while (run) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by Roll No");
            System.out.println("4. Remove Student by Roll No");
            System.out.println("5. Display Students Sorted by Marks");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input! Enter a number.");
                continue;
            }

            switch (choice) {

                // Add student
                case 1 -> {
                    try {
                        System.out.print("Enter Roll No: ");
                        int r = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter Name: ");
                        String n = sc.nextLine();

                        System.out.print("Enter Marks: ");
                        double m = Double.parseDouble(sc.nextLine());

                        list.add(new Student(r, n, m));
                        System.out.println("Student added successfully.");
                    } catch (Exception e) {
                        System.out.println("Invalid input! Student not added.");
                    }
                }

                // Display all students
                case 2 -> {
                    if (list.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        System.out.println("\n--- Student List ---");
                        for (Student s : list) System.out.println(s);
                    }
                }

                // Search by roll number
                case 3 -> {
                    System.out.print("Enter Roll No to search: ");
                    int r = Integer.parseInt(sc.nextLine());
                    boolean found = false;

                    for (Student s : list) {
                        if (s.rollNo == r) {
                            System.out.println("Student Found: " + s);
                            found = true;
                            break;
                        }
                    }

                    if (!found) System.out.println("Student not found.");
                }

                // Remove student by roll number
                case 4 -> {
                    System.out.print("Enter Roll No to remove: ");
                    int r = Integer.parseInt(sc.nextLine());
                    boolean removed = list.removeIf(s -> s.rollNo == r);

                    if (removed) System.out.println("Student removed.");
                    else System.out.println("Student not found.");
                }

                // Sort by marks
                case 5 -> {
                    if (list.isEmpty()) {
                        System.out.println("No students to sort.");
                    } else {
                        Collections.sort(list, Comparator.comparingDouble(s -> s.marks));
                        System.out.println("\n--- Students Sorted by Marks (Ascending) ---");
                        for (Student s : list) System.out.println(s);
                    }
                }

                case 6 -> {
                    System.out.println("Exiting... Thank you!");
                    run = false;
                }

                default -> System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}
