public class Addition {
    
    public static int[] addArrays(int[] arr1, int[] arr2) {
        // Check for empty arrays
        if (arr1.length == 0 || arr2.length == 0) {
            throw new IllegalArgumentException("Invalid input. Arrays must not be empty.");
        }

        // Initialize result array
        int[] res = new int[Math.max(arr1.length, arr2.length)];
        int carry = 0; // Initialize carry to 0 

        // Check for negative numbers in input arrays
        if (containsNegative(arr1) || containsNegative(arr2)) {
            throw new IllegalArgumentException("Invalid input. Arrays must contain only non-negative numbers.");
        }

        // Find the maximum length from both arrays
        int maxLength = Math.max(arr1.length, arr2.length); 

        // Pad the shorter array with zeros on the left and concatenate
        int[] paddedArr1 = padArray(arr1, maxLength);
        int[] paddedArr2 = padArray(arr2, maxLength);

        // After having the same length, add both arrays and store in res, handle the carry also
        for(int i = maxLength - 1; i >= 0; i--) {
            int sum = paddedArr1[i] + paddedArr2[i] + carry;   
            res[i] = sum % 10; 
            carry = sum / 10;
        } 

        // Check if carry is greater than 0, then add it to the result at the beginning
        if (carry > 0) {  
            res = prepend(res, carry);
        }  

        return res;
    }

    private static int[] padArray(int[] arr, int targetLength) {
        int[] paddedArr = new int[targetLength];
        for (int i = 0; i < arr.length; i++) {
            paddedArr[i + (targetLength - arr.length)] = arr[i];
        }
        return paddedArr;
    }

    private static int[] prepend(int[] arr, int element) {
        int[] newArr = new int[arr.length + 1];
        newArr[0] = element;
        System.arraycopy(arr, 0, newArr, 1, arr.length);
        return newArr;
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
        int[] result1 = addArrays(new int[]{9, 9}, new int[]{1, 1, 1});
        int[] result2 = addArrays(new int[]{5, 5, 5, 5}, new int[]{9, 9, 9});
        int[] result3 = addArrays(new int[]{1, 2, 3}, new int[]{7, 8, 9});
        int[] result4 = addArrays(new int[]{1, 0, 0, 0}, new int[]{9, 9, 9});
        int[] result5 = addArrays(new int[]{1, 5, 6}, new int[]{0, 2, 3}); // Providing an array with only non-negative numbers

    
        printArray(result1);
        printArray(result2);
        printArray(result3);
        printArray(result4);
        printArray(result5);

    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
