import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class ToDoListLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<String> tasks = new LinkedList<>();

        boolean run = true;
        System.out.println("=== To-Do List (LinkedList) ===");

        while (run) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Remove Completed Task");
            System.out.println("4. Display Tasks in Reverse Order");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input!");
                continue;
            }

            switch (choice) {

                // Add task
                case 1 -> {
                    System.out.print("Enter task: ");
                    String task = sc.nextLine();
                    tasks.add(task);
                    System.out.println("Task added.");
                }

                // View all tasks
                case 2 -> {
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks found.");
                    } else {
                        System.out.println("\n--- To-Do Tasks ---");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                }

                // Remove completed task
                case 3 -> {
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks to remove.");
                        break;
                    }
                    System.out.print("Enter task number to remove: ");
                    try {
                        int index = Integer.parseInt(sc.nextLine());
                        if (index < 1 || index > tasks.size()) {
                            System.out.println("Invalid task number.");
                        } else {
                            tasks.remove(index - 1);
                            System.out.println("Task removed.");
                        }
                    } catch (Exception e) {
                        System.out.println("Enter a valid number.");
                    }
                }

                // Display reverse order
                case 4 -> {
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks found.");
                    } else {
                        System.out.println("\n--- Tasks in Reverse Order ---");
                        ListIterator<String> it = tasks.listIterator(tasks.size());
                        int num = tasks.size();
                        while (it.hasPrevious()) {
                            System.out.println(num-- + ". " + it.previous());
                        }
                    }
                }

                case 5 -> {
                    System.out.println("Exiting...");
                    run = false;
                }

                default -> System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}
