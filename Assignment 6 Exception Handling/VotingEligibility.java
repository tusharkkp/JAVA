import java.util.Scanner;

public class VotingEligibility {

    // method that manually throws exception
    static void checkEligibility(int age) {
        if (age < 18) {
            throw new ArithmeticException("Not eligible to vote");
        }
        System.out.println("Eligible to vote");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        try {
            checkEligibility(age); // may throw exception
        }
        catch (ArithmeticException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("Program completed.");
        sc.close();
    }
}
