package JAVA_beginner_DSA_foundations_prerequisites.step4;

public class Session16part1que1BinarySearchApproach {
    
    // find frequency of x in a given sorted array

    public static int binarySearchApproach(int[] arr, int x) {
        /*
         * This approach uses binary search to find the frequency of a given element x in a sorted array.
         * The idea is to find the index of the first occurrence of x (leftmost) and the last occurrence (rightmost),
         * and then the frequency is (last - first + 1).
         * 
         * Why this works: In a sorted array, duplicates of x will be together. Binary search helps find the boundaries efficiently in O(logN) time.
         */

        // Find the first occurrence of x
        int n = arr.length;
        int first = -1;
        int low = 0, high = n - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                first = mid;        // possible first, but look further left
                high = mid - 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (first == -1) {
            return 0; // x not found in array
        }

        // Find the last occurrence of x
        int last = -1;
        low = 0; high = n - 1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                last = mid;      // possible last, but look further right
                low = mid + 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // Frequency is the difference between last and first indices + 1
        return last - first + 1;
    }

    public static void main(String[] args) {
        // Example usage and some test cases
        int[] arr1 = {1, 2, 2, 2, 3, 4, 4, 5};
        int x1 = 2;
        System.out.println("Frequency of " + x1 + " is: " + binarySearchApproach(arr1, x1)); // Expected: 3

        int[] arr2 = {1, 1, 2, 2, 2, 2, 3, 3, 4, 5};
        int x2 = 1;
        System.out.println("Frequency of " + x2 + " is: " + binarySearchApproach(arr2, x2)); // Expected: 2

        int[] arr3 = {1, 1, 1, 1, 1};
        int x3 = 1;
        System.out.println("Frequency of " + x3 + " is: " + binarySearchApproach(arr3, x3)); // Expected: 5

        int[] arr4 = {1, 2, 3, 4, 5};
        int x4 = 6;
        System.out.println("Frequency of " + x4 + " is: " + binarySearchApproach(arr4, x4)); // Expected: 0

        int[] arr5 = {};
        int x5 = 1;
        System.out.println("Frequency of " + x5 + " is: " + binarySearchApproach(arr5, x5)); // Expected: 0
    }
}
