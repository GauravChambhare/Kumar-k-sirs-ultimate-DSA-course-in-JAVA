package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.util.HashMap;
import java.util.Map;

// Que: Given an array "nums" of size "N" - find the total number of pairs (i, j) [i < j]
// such that nums[i] + nums[j] = target.
// Note: input array is not necessarily sorted.
public class Session5 {

    public static int totalPairs(int[] arr, int target) {
        int ans = 0;
        Map<Integer, Integer> freqmap = new HashMap<>();

        for (int i : arr) {
            int complement = target - i;
            // 1. Add the FULL count of valid left-side partners
            if (freqmap.containsKey(complement)) {
                ans += freqmap.get(complement); // Use freqmap.getOrDefault(complement, 0) to omit if-check
            }

            // 2. Register current element only once
            freqmap.put(i, freqmap.getOrDefault(i, 0) + 1);
        }

        return ans;
    }

    // main method to run locally
    public static void main(String[] args) {
        int[] arr1 = new int[] {1, 5, 7, 1};
        int target1 = 6;
        System.out.println("Total pairs with sum == " + target1 + " : " + totalPairs(arr1, target1)); // 2 -> (1,5), (5,1)

        int[] arr2 = new int[] {1, 2, 3, 4, 3};
        int target2 = 6;
        System.out.println("Total pairs with sum == " + target2 + " : " + totalPairs(arr2, target2)); // 2 -> (2,4), (3,3)
    }
}
