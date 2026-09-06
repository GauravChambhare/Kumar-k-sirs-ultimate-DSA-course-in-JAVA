package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.util.HashMap;

public class Session20AmazonOAQuestion {

    /**
     * Returns the count of subarrays where the sum of elements modulo k matches the subarray length modulo k.
     * The function uses prefix sums and a HashMap to find the result efficiently.
     */
    public static long securityFeature(int[] arr, int k) {
        int n = arr.length;
        // Edge case: Single element array
        if (n == 1) {
            return ((arr[0] % k + k) % k == 1 % k)? 1 : 0;
        }
        long ans = 0;
        long[] p = new long[n + 1]; // p[0] = 0; p[i] = sum of arr[0] ... arr[i-1]
        
        // Build prefix sum array
        for (int i = 1; i <= n; i++) {
            p[i] = p[i - 1] + arr[i - 1];
        }

        HashMap<Long, Long> mp = new HashMap<>();
        // Initially, the "empty prefix" (p[0]=0, j=0) has occurred once with value 0.
        // Key is: ((p[j] mod k) - (j mod k) + k) mod k
        mp.put(0L, 1L);

        for (int j = 1; j <= n; j++) {
            long value = ((p[j] % k - j % k + k) % k);

            // If this key (value) has occurred before, all such occurrences are subarrays satisfying the property.
            ans += mp.getOrDefault(value, 0L);

            // Update the count for this value for future subarrays
            mp.put(value, mp.getOrDefault(value, 0L) + 1);
        }

        return ans;
    }

    // Local main method for quick testing
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("Result 1: " + securityFeature(arr1, k1));

        int[] arr2 = {1, 0, 1, 1};
        int k2 = 2;
        System.out.println("Result 2: " + securityFeature(arr2, k2));

        int[] arr3 = {0, 0, 0};
        int k3 = 2;
        System.out.println("Result 3: " + securityFeature(arr3, k3));

        int[] arr4 = {5, -3, -1, 0};
        int k4 = 3;
        System.out.println("Result 4: " + securityFeature(arr4, k4));

        int[] arr5 = {1};
        int k5 = 2;
        System.out.println("Result 5: " + securityFeature(arr5, k5));
    }
}
