package JAVA_beginner_DSA_foundations_prerequisites.step4;

/**
 * Question:
 * Given a sorted array of integers (in non-decreasing order) and an integer x,
 * find the index of the number in the array that is just greater than x and as close as possible to x.
 * If no such number exists (i.e., all elements are <= x), return -1.
 *
 * Approach:
 * - Use binary search to find the smallest index r such that arr[r] > x.
 * - Time Complexity: O(log n) where n is the number of elements in the array.
 * - Space Complexity: O(1)
 */
public class FindNoJustGreaterThanXAndAsCloseAsPossibleToX {

    /**
     * Returns the index of the smallest element greater than x.
     * Returns -1 if no such element exists.
     *
     * @param arr sorted integer array (non-decreasing order)
     * @param x   integer to compare against
     * @return index of the element just greater than x, or -1 if not found
     */
    public static int solver(int[] arr, int x) {
        int n = arr.length;
        int l = -1, r = n;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > x)
                r = mid;
            else
                l = mid;
        }
        return (r == n) ? -1 : r;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 6, 8, 10};
        int x1 = 7;
        // should print 3 (arr[3]=8, just greater than 7)
        System.out.printf("Index just greater than %d: %d (value: %d)\n",
                          x1, solver(arr1, x1), solver(arr1, x1) >= 0 ? arr1[solver(arr1, x1)] : -1);

        int x2 = 10;
        // should print -1 (no number greater than 10)
        System.out.printf("Index just greater than %d: %d\n", x2, solver(arr1, x2));

        int x3 = 0;
        // should print 0 (arr[0]=1)
        System.out.printf("Index just greater than %d: %d (value: %d)\n",
                          x3, solver(arr1, x3), solver(arr1, x3) >= 0 ? arr1[solver(arr1, x3)] : -1);

        int x4 = 4;
        // should print 2 (arr[2]=6)
        System.out.printf("Index just greater than %d: %d (value: %d)\n",
                          x4, solver(arr1, x4), solver(arr1, x4) >= 0 ? arr1[solver(arr1, x4)] : -1);

        int[] arr2 = {2, 2, 2, 8, 9};
        int x5 = 2;
        // should print 3 (arr[3]=8)
        System.out.printf("Index just greater than %d: %d (value: %d)\n",
                          x5, solver(arr2, x5), solver(arr2, x5) >= 0 ? arr2[solver(arr2, x5)] : -1);

        int x6 = 11;
        // should print -1 (no such element)
        System.out.printf("Index just greater than %d: %d\n", x6, solver(arr1, x6));
    }
}
