import java.util.Scanner;

public class GenericDisplayArrayUserInput {

    // Generic method to display any type of array
    public static <T> void displayArray(T[] arr) {
        for (T element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Integer Array
        System.out.print("Enter size of Integer array: ");
        int n1 = sc.nextInt();
        Integer[] intArr = new Integer[n1];
        System.out.println("Enter " + n1 + " integer values:");
        for (int i = 0; i < n1; i++) {
            intArr[i] = sc.nextInt();
        }

        // Double Array
        System.out.print("\nEnter size of Double array: ");
        int n2 = sc.nextInt();
        Double[] doubleArr = new Double[n2];
        System.out.println("Enter " + n2 + " double values:");
        for (int i = 0; i < n2; i++) {
            doubleArr[i] = sc.nextDouble();
        }

        // Character Array
        System.out.print("\nEnter size of Character array: ");
        int n3 = sc.nextInt();
        Character[] charArr = new Character[n3];
        System.out.println("Enter " + n3 + " characters:");
        for (int i = 0; i < n3; i++) {
            charArr[i] = sc.next().charAt(0);
        }

        // String Array
        System.out.print("\nEnter size of String array: ");
        int n4 = sc.nextInt();
        String[] strArr = new String[n4];
        System.out.println("Enter " + n4 + " strings:");
        for (int i = 0; i < n4; i++) {
            strArr[i] = sc.next();
        }

        // Display using generic method
        System.out.println("\n--- OUTPUT ---");

        System.out.println("Integer Array:");
        displayArray(intArr);

        System.out.println("Double Array:");
        displayArray(doubleArr);

        System.out.println("Character Array:");
        displayArray(charArr);

        System.out.println("String Array:");
        displayArray(strArr);

        sc.close();
    }
}
