import java.io.*;
import java.util.Scanner;

public class StudentFileHandling {

    // Write student record to file
    static void writeStudent(String roll, String name, String marks) throws IOException {
        FileWriter fw = new FileWriter("students.txt", true); // append mode
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(roll + "," + name + "," + marks);
        bw.newLine();
        bw.close();
        System.out.println("Student record saved.");
    }

    // Read all records from file
    static void readStudents() throws IOException {
        File file = new File("students.txt");
        if (!file.exists()) {
            System.out.println("No student records found!");
            return;
        }

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        System.out.println("\n--- Student Records ---");

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            System.out.println("Roll No: " + data[0] +
                               ", Name: " + data[1] +
                               ", Marks: " + data[2]);
        }

        br.close();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;

        System.out.println("=== Student File Handling System ===");

        while (run) {
            System.out.println("\nMenu:");
            System.out.println("1. Write Student Record");
            System.out.println("2. Read Student Records");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input!");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Roll No: ");
                    String roll = sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    String marks = sc.nextLine();

                    try {
                        writeStudent(roll, name, marks);
                    } catch (IOException e) {
                        System.out.println("Error writing to file: " + e.getMessage());
                    }
                }

                case 2 -> {
                    try {
                        readStudents();
                    } catch (IOException e) {
                        System.out.println("Error reading file: " + e.getMessage());
                    }
                }

                case 3 -> {
                    System.out.println("Exiting... Thank you!");
                    run = false;
                }

                default -> System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}
