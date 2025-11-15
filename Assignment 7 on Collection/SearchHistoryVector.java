import java.util.Vector;
import java.util.HashSet;
import java.util.Scanner;
import java.util.ListIterator;

public class SearchHistoryVector {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vector<String> history = new Vector<>();
        boolean run = true;

        System.out.println("=== Recent Search Keywords (Vector) ===");

        while (run) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a new search term");
            System.out.println("2. Display all search terms");
            System.out.println("3. Remove duplicate terms (keep latest)");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            String line = sc.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(line);
            } catch (Exception e) {
                System.out.println("Invalid input. Enter a number (1-4).");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter search term: ");
                    String term = sc.nextLine().trim();
                    if (term.isEmpty()) {
                        System.out.println("Empty term not added.");
                    } else {
                        history.add(term); // add to the end (most recent at end)
                        System.out.println("Added: \"" + term + "\"");
                    }
                }

                case 2 -> {
                    if (history.isEmpty()) {
                        System.out.println("No search terms found.");
                    } else {
                        System.out.println("\n--- Search History (oldest → newest) ---");
                        for (int i = 0; i < history.size(); i++) {
                            System.out.println((i + 1) + ". " + history.get(i));
                        }
                    }
                }

                case 3 -> {
                    if (history.isEmpty()) {
                        System.out.println("No terms to process.");
                        break;
                    }
                    // Remove duplicates but keep the latest occurrence.
                    // Strategy: iterate from end to start, keep first-seen terms in a HashSet,
                    // build a temporary Vector in reverse order of kept items, then reverse it back.
                    HashSet<String> seen = new HashSet<>();
                    Vector<String> cleanedReversed = new Vector<>();

                    for (int i = history.size() - 1; i >= 0; i--) {
                        String t = history.get(i);
                        String key = t.toLowerCase(); // case-insensitive duplicate removal
                        if (!seen.contains(key)) {
                            cleanedReversed.add(t);
                            seen.add(key);
                        }
                    }

                    // reverse cleanedReversed into history
                    history.clear();
                    for (int i = cleanedReversed.size() - 1; i >= 0; i--) {
                        history.add(cleanedReversed.get(i));
                    }

                    System.out.println("Duplicates removed. Latest occurrences preserved.");
                }

                case 4 -> {
                    System.out.println("Exiting... Thank you!");
                    run = false;
                }

                default -> System.out.println("Invalid choice. Choose 1-4.");
            }
        }

        sc.close();
    }
}
