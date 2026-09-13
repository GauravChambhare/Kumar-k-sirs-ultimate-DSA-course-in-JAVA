package JAVA_beginner_DSA_foundations_prerequisites.step4;

/**
 * Finds the number in a sorted array that is closest to x.
 * Uses the sorted binary array template approach.
 *
 * Time Complexity: O(log n), where n is the length of the array.
 * Space Complexity: O(1)
 */
public class FindNumberClosestToXinArray {

    /**
     * Returns the element in arr closest to x.
     * If two elements are equally close, returns the smaller one.
     * Assumes arr is sorted in non-decreasing order.
     */
    public static int solver(int[] arr, int x) {
        int n = arr.length;
        int L = -1, R = n;
        // Binary search for first element >= x (Lower Bound)
        while (L + 1 < R) {
            int mid = L + (R - L) / 2;
            if (arr[mid] < x) {
                L = mid;
            } else {
                R = mid;
            }
        }
        // Now: arr[L] < x <= arr[R] (if indices are valid)
        int closest;
        if (R == n) { // All elements < x
            closest = arr[n - 1];
        } else if (L == -1) { // All elements >= x
            closest = arr[0];
        } else {
            // Decide if arr[L] or arr[R] is closer to x
            if (x - arr[L] <= arr[R] - x) {
                closest = arr[L];
            } else {
                closest = arr[R];
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        // Example sorted arrays with test cases
        int[] arr1 = {1, 4, 6, 8, 10};
        int x1 = 7;
        System.out.printf("Closest to %d in arr1: %d\n", x1, solver(arr1, x1)); // expect 6

        int x2 = 9;
        System.out.printf("Closest to %d in arr1: %d\n", x2, solver(arr1, x2)); // expect 8 or 10, should be 8

        int x3 = 10;
        System.out.printf("Closest to %d in arr1: %d\n", x3, solver(arr1, x3)); // expect 10

        int x4 = 1;
        System.out.printf("Closest to %d in arr1: %d\n", x4, solver(arr1, x4)); // expect 1

        int x5 = 0;
        System.out.printf("Closest to %d in arr1: %d\n", x5, solver(arr1, x5)); // expect 1

        int x6 = 11;
        System.out.printf("Closest to %d in arr1: %d\n", x6, solver(arr1, x6)); // expect 10
    }
}
