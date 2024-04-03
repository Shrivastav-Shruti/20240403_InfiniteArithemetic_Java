import java.util.Arrays;

public class Substraction { 

     public static String subtraction(int[] arr1, int[] arr2) {
        // Check for invalid input
        if (arr1.length == 0 || arr2.length == 0 || containsNegative(arr1) || containsNegative(arr2)) {
            throw new IllegalArgumentException("Invalid input. Arrays must not be empty and must contain only non-negative numbers.");
        }

        // Pad the smaller array with zeros to make both arrays of equal length
        int maxLength = Math.max(arr1.length, arr2.length);
        if (arr1.length < maxLength) {
            arr1 = padArray(arr1, maxLength);
        } else if (arr2.length < maxLength) {
            arr2 = padArray(arr2, maxLength);
        }

        // Compare the arrays digit by digit to determine the sign of the result
        int comparison = compareArrays(arr1, arr2);

        // If arr1 is smaller, swap arr1 and arr2
        if (comparison == -1) {
            int[] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }

        // Resultant array
        int[] res = new int[maxLength];
        int m = arr1.length - 1;
        int n = arr2.length - 1;
        int borrow = 0;

        // Iterate through the arrays and subtract corresponding digits
        while (m >= 0 || n >= 0) {
            int diff = (m >= 0 ? arr1[m] : 0) - (n >= 0 ? arr2[n] : 0) - borrow;
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            res[m] = diff;

            m--;
            n--;
        }

        // Convert the result array to a string
        StringBuilder resultString = new StringBuilder();
        for (int num : res) {
            resultString.append(num);
        }

        // Add negative sign if necessary
        if (comparison == -1) {
            resultString.insert(0, '-');
        }

        // Remove leading zeros
        while (resultString.charAt(0) == '0' && resultString.length() > 1) {
            resultString.deleteCharAt(0);
        }

        // Return the result
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

    private static int[] padArray(int[] arr, int targetLength) {
        int[] paddedArr = Arrays.copyOf(arr, targetLength);
        return paddedArr;
    }

    private static int compareArrays(int[] arr1, int[] arr2) {
        String str1 = Arrays.toString(arr1).replaceAll("\\D", "");
        String str2 = Arrays.toString(arr2).replaceAll("\\D", "");
        return str1.compareTo(str2);
    }

    public static void main(String[] args) {
        // Testing Function
        System.out.println(subtraction(new int[]{6, 0, 1, 5}, new int[]{7, 3, 5, 2}));
        System.out.println(subtraction(new int[]{4, 6, 5, 9}, new int[]{5, 9, 2}));
        System.out.println(subtraction(new int[]{7, 8, 9}, new int[]{1, 1, 8, 5}));
        try {
            System.out.println(subtraction(new int[]{}, new int[]{4, 8, 2}));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
