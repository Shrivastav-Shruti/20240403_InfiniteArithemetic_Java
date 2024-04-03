public class Division {

    public static String division(int dividend, int divisor) {
        // Check for division by zero
        if (divisor == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }

        // Perform division
        int quotient = dividend / divisor;
        int remainder = dividend % divisor;

        // Return the result as a string
        return "Quotient: " + quotient + ", Remainder: " + remainder;
    }

    public static void main(String[] args) {
        // Testing Function
        System.out.println(division(10, 3));
        System.out.println(division(20, 5));
        System.out.println(division(15, 7));
        try {
            System.out.println(division(12, 0));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

