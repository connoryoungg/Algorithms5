import java.util.HashSet;

public class SubsetCheck {
    public static boolean isSubset(int[] S, int[] T) {
        // Create a HashSet to store elements of set T
        HashSet<Integer> setT = new HashSet<>();

        // Add all elements of T to the HashSet
        for (int num : T) {
            setT.add(num);
        }

        // Check if every element of S is present in set T
        for (int num : S) {
            if (!setT.contains(num)) {
                return false; // S is not a subset of T
            }
        }

        return true; // S is a subset of T
    }

    public static void main(String[] args) {
        // Example usage:
        int[] S = {32, 3};
        int[] T = {1, 2, 3, 52, 32, 54};

        int[] S2 = {89, 32, 54, 32, 3};
        int[] T2 = {54, 32, 99};

        if (isSubset(S, T)) {
            System.out.println("S is a subset of T");
        } else {
            System.out.println("S is not a subset of T");
        }

        if (isSubset(S2, T2)) {
            System.out.println("S is a subset of T");
        } else {
            System.out.println("S is not a subset of T");
        }
    }
}

