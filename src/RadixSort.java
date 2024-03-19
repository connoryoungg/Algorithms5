import java.util.Arrays;


public class RadixSort {
    public static void radixSort(String[] arr) {
        // Find the maximum length string
        int maxLength = 0;
        for (String s : arr) {
            maxLength = Math.max(maxLength, s.length());
        }

        // Perform counting sort for each character from right to left
        for (int i = maxLength - 1; i >= 0; i--) {
            countingSort(arr, i);
        }
    }

    // Counting Sort for a specific character index
    private static void countingSort(String[] arr, int index) {
        final int RANGE = 256; // ASCII range

        int[] count = new int[RANGE];
        String[] temp = new String[arr.length];

        // Count occurrences of characters
        for (String s : arr) {
            int charIndex = (index < s.length()) ? (int) s.charAt(index) : 0;
            count[charIndex]++;
        }

        // Modify count array to store the actual position of each character
        for (int i = 1; i < RANGE; i++) {
            count[i] += count[i - 1];
        }

        // Build the sorted array
        for (int i = arr.length - 1; i >= 0; i--) {
            String s = arr[i];
            int charIndex = (index < s.length()) ? (int) s.charAt(index) : 0;
            temp[count[charIndex] - 1] = arr[i];
            count[charIndex]--;
        }

        // Copy sorted array back to the original array
        System.arraycopy(temp, 0, arr, 0, arr.length);
    }



    // Main method to test the implementation
    public static void main(String[] args) {
        String[] arr = {"gojo", "google", "jogo", "bill", "pup", "cipher", "watchmen", "knight", "it", "stand", "sandman",
                "hydra", "surtr"};
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(arr));

        // Sort the array using Radix Sort
        radixSort(arr);

        System.out.println("\nSorted Array:");
        System.out.println(Arrays.toString(arr));
    }
}



