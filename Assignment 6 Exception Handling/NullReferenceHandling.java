public class NullReferenceHandling {
    public static void main(String[] args) {

        String str = null; // null string

        try {
            System.out.println("String length: " + str.length()); // throws NullPointerException
        }
        catch (NullPointerException e) {
            System.out.println("Error: Cannot access length because the string is null.");
        }
        finally {
            System.out.println("Program executed safely.");
        }
    }
}
