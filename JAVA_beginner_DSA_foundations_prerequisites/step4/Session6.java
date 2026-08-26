package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.util.HashMap;
import java.util.Map;

// Que: Given an array "nums" of size "N" - find the total number of pairs (i, j) [i < j]
// such that (nums[i] + nums[j]) % 5 == 0 (nums[i] >= 0 for all i).
public class Session6 {

    public static int totalPairs(int[] arr) {
        // Map stores: remainder -> frequency of occurrences seen so far
        Map<Integer, Integer> remMap = new HashMap<>();
        int ans = 0;

        for (int j = 0; j < arr.length; j++) {
            // Single formula for positive & negative remainders
            int real = ((arr[j] % 5) + 5) % 5;

            // Complement remainder needed for (real + target) % 5 == 0
            int target = (5 - real) % 5;

            // If target remainder exists in map, add its frequency to ans
            if (remMap.containsKey(target)) {
                ans += remMap.get(target);
            }

            // Store CURRENT element's remainder (real), NOT target
            remMap.put(real, remMap.getOrDefault(real, 0) + 1);
        }

        return ans;
    }

    // main method to run locally
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5, 0};
        System.out.println("Total pairs with (sum % 5 == 0): " + totalPairs(nums)); // 3 -> (1,4), (2,3), (5,0)
    }
}
