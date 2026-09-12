package JAVA_beginner_DSA_foundations_prerequisites.step4;

/**
 * Google OA-style Quadruplets Problem
 * ------------------------------------
 * Given an array of integers, count the number of quadruplets (i, j, k, l) such that:
 *   - 1 <= i < j < k < l <= n
 *   - a[i] + a[j] > k1
 *   - a[k] + a[l] > k2
 * 
 * This version runs hard-coded test cases and prints results directly (no system input).
 */
public class FindNoOfQuadrapuletsSatisfyingConditionsGoogleOA {

    /**
     * Brute-force/Optimized counting approach for quadruplets meeting the problem's conditions.
     * The array is 1-indexed for direct translation from the original code.
     * 
     * @param a array (1-indexed, index 0 is ignored)
     * @param n number of elements (length-1)
     * @param k1 first threshold
     * @param k2 second threshold
     * @return number of quadruplets (i, j, k, l) satifying given conditions
     */
    public static long countQuadruplets(long[] a, int n, long k1, long k2) {
        long c = 0;
        // j goes from 2 to n-2 so that i < j < k < l and within bounds
        for (int j = 2; j <= n - 2; j++) {
            int i = j - 1;
            long c1 = 0;
            // Count valid (i, j) pairs for this j
            while (i >= 1) {
                if (a[i] + a[j] > k1) {
                    c1++;
                }
                i--;
            }
            // Count valid (k, l) pairs for this j
            long c2 = 0;
            int k = j + 1;
            int l = n;
            while (k < l) {
                if (a[k] + a[l] > k2) {
                    c2 += (l - k); // All pairs (k, k+1)...(k, l)
                    l--;           // Move l to try smaller pairs
                } else {
                    k++;           // Try larger k
                }
            }
            c += c1 * c2;
        }
        return c;
    }

    public static void main(String[] args) {
        // Hard-coded test cases
        // Example 1
        long[] arr1 = {0, 2, 4, 7, 9, 3}; // 1-based indexing (ignore index 0)
        long k1_1 = 5;
        long k2_1 = 8;
        int n1 = arr1.length - 1;
        System.out.println("Test case 1:");
        System.out.println("Array: [2, 4, 7, 9, 3], k1 = 5, k2 = 8");
        System.out.println("Quadruplet count: " + countQuadruplets(arr1, n1, k1_1, k2_1));
        System.out.println();

        // Example 2
        long[] arr2 = {0, 1, 2, 3, 4, 5}; // [1,2,3,4,5]
        long k1_2 = 4;
        long k2_2 = 7;
        int n2 = arr2.length - 1;
        System.out.println("Test case 2:");
        System.out.println("Array: [1, 2, 3, 4, 5], k1 = 4, k2 = 7");
        System.out.println("Quadruplet count: " + countQuadruplets(arr2, n2, k1_2, k2_2));
        System.out.println();

        // Example 3
        long[] arr3 = {0, 1, 6, 3, 8};
        long k1_3 = 7;
        long k2_3 = 8;
        int n3 = arr3.length - 1;
        System.out.println("Test case 3:");
        System.out.println("Array: [1, 6, 3, 8], k1 = 7, k2 = 8");
        System.out.println("Quadruplet count: " + countQuadruplets(arr3, n3, k1_3, k2_3));
        System.out.println();
    }
}
