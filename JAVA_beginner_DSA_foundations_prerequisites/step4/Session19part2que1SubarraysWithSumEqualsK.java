package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.util.HashMap;

public class Session19part2que1SubarraysWithSumEqualsK {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = {1, 2, 3, 2, 1};
        int k1 = 3;
        System.out.println("Count of subarrays with sum " + k1 + " in arr1: " + sol.cntSubarrays(arr1, k1)); // Expected: 3

        int[] arr2 = {1, 1, 1};
        int k2 = 2;
        System.out.println("Count of subarrays with sum " + k2 + " in arr2: " + sol.cntSubarrays(arr2, k2)); // Expected: 2

        int[] arr3 = {10, 2, -2, -20, 10};
        int k3 = -10;
        System.out.println("Count of subarrays with sum " + k3 + " in arr3: " + sol.cntSubarrays(arr3, k3)); // Expected: 3
    }
}

class Solution {
    public int cntSubarrays(int[] arr, int k) {
        int count = 0;
        int currSum = 0;

        // Map to store: Key = prefix sum, Value = frequency of that prefix sum
        HashMap<Integer, Integer> map = new HashMap<>();

        // Base case: a prefix sum of 0 has occurred once (represents an empty prefix)
        map.put(0, 1);

        for (int num : arr) {
            currSum += num;

            // If (currSum - k) exists, add its frequency to the total count
            if (map.containsKey(currSum - k)) {
                count += map.get(currSum - k);
            }

            // Record/update the frequency of the current prefix sum
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }
}
