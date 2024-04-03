public class Multiplication { 

    public static String multiplication(int[] arr1, int[] arr2) {
        // Check for invalid input
        if (arr1.length == 0 || arr2.length == 0 || containsNegative(arr1) || containsNegative(arr2)) {
            throw new IllegalArgumentException("Invalid input. Arrays must not be empty and must contain only non-negative numbers.");
        }
        
        int[] result = new int[arr1.length + arr2.length]; // Initialize result array with zeros 

        for (int i = arr1.length - 1; i >= 0; i--) {
            for (int j = arr2.length - 1; j >= 0; j--) {
                int product = arr1[i] * arr2[j]; // Calculate product of current digits
                
                // Distribute the product over result array
                int sum = product + result[i + j + 1];
                result[i + j] += sum / 10;
                result[i + j + 1] = sum % 10;
            }
        }
        
        // Remove leading zeros
        StringBuilder resultString = new StringBuilder();
        boolean leadingZeros = true;
        for (int num : result) {
            if (leadingZeros && num == 0) {
                continue;
            }
            leadingZeros = false;
            resultString.append(num);
        }
        
        // If the result is an empty string (i.e., all zeros), set it to '0'
        if (resultString.length() == 0) {
            return "0";
        }
        
        return resultString.toString();
    }
    
    private static boolean containsNegative(int[] arr) {
        for (int num : arr) {
            if (num < 0) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        // Testing Function
        System.out.println(multiplication(new int[]{3}, new int[]{1, 2}));
        System.out.println(multiplication(new int[]{2, 5, 9}, new int[]{1, 9, 4, 0}));
        System.out.println(multiplication(new int[]{0, 0, 0}, new int[]{0, 0}));
        System.out.println(multiplication(new int[]{7, 5, 9}, new int[]{1, 8, 5}));
        System.out.println(multiplication(new int[]{3, 7, 5, 9, 2, 1, 6, 2, 3}, new int[]{6, 8, 0, 2, 5, 3}));
        System.out.println(multiplication(new int[]{56, 891}, new int[]{761, 34, 8}));
        try {
            System.out.println(multiplication(new int[]{-3, 7, 1}, new int[]{}));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
