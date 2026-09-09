package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Problem Statement:
 * Given an array of 'n' integers and an integer 'k', 
 * find the count of all subarrays which contain at most 'k' distinct integers.
 *
 * Example:
 * arr = [1, 2, 1, 2, 3], k = 2
 * Output: 7
 * Explanation: The 7 subarrays are:
 * [1], [2], [1], [2], [1,2], [2,1], [1,2]
 */

public class CountOfDistinctIntegersInArray {

    // Optimized method using sliding window technique
    public static int countSubarraysWithAtMostKDistinctOptimized(int[] arr, int k) {
        int n = arr.length;
        int ans = 0;
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0, j = 0; j < n; j++) {
            mp.put(arr[j], mp.getOrDefault(arr[j], 0) + 1);
            while (mp.size() > k && i <= j) {
                mp.put(arr[i], mp.get(arr[i]) - 1);
                if (mp.get(arr[i]) == 0) {
                    mp.remove(arr[i]);
                }
                i++;
            }
            ans += j - i + 1;
        }
        return ans;
    }

    // Brute-force method to count subarrays with at most k distinct integers
    public static int brute_force(int[] arr, int k) {
        int n = arr.length;
        int ans = 0;
        for (int start = 0; start < n; start++) {
            Set<Integer> distinct = new HashSet<>();
            for (int end = start; end < n; end++) {
                distinct.add(arr[end]);
                if (distinct.size() <= k) {
                    ans++;
                } else {
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // Hard-coded test case (sample)
        int[] arr = {1, 2, 1, 2, 3};
        int k = 2;
        // Output for both methods
        System.out.println("Array: [1, 2, 1, 2, 3]");
        System.out.println("k = 2");
        System.out.println("Optimized (Sliding Window) Output: " + countSubarraysWithAtMostKDistinctOptimized(arr, k));
        System.out.println("Brute Force Output: " + brute_force(arr, k));

        // You may add more test cases as needed
/*         // Example 2:
        int[] arr2 = {4, 4, 4, 4};
        int k2 = 1;
        System.out.println("\nArray: [4, 4, 4, 4]");
        System.out.println("k = 1");
        System.out.println("Optimized Output: " + countSubarraysWithAtMostKDistinctOptimized(arr2, k2));
        System.out.println("Brute Force Output: " + brute_force(arr2, k2));
*/
    }
}
