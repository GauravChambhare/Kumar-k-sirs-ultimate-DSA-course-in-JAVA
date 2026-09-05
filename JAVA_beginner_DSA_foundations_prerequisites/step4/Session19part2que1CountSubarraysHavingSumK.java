package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.util.HashMap;

public class Session19part2que1CountSubarraysHavingSumK {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 2, 2, 1};
        int k1 = 1;
        System.out.println("Pairs with difference " + k1 + " in nums1: " + sol.countKDifference(nums1, k1)); // Output: 4

        int[] nums2 = {1, 3};
        int k2 = 3;
        System.out.println("Pairs with difference " + k2 + " in nums2: " + sol.countKDifference(nums2, k2)); // Output: 0

        int[] nums3 = {3, 2, 1, 5, 4};
        int k3 = 2;
        System.out.println("Pairs with difference " + k3 + " in nums3: " + sol.countKDifference(nums3, k3)); // Output: 3
    }
}

class Solution {
    public int countKDifference(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1) return 0;

        HashMap<Integer, Integer> mp = new HashMap<>();
        int ans = 0;
        for (int j = 0; j < n; j++) {
            int complementPos = nums[j] + k;
            int complementNeg = nums[j] - k;

            if (mp.containsKey(complementPos)) {
                ans += mp.get(complementPos);
            }
            if (mp.containsKey(complementNeg)) {
                ans += mp.get(complementNeg);
            }

            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);
        }
        return ans;
    }
}

// APPROACH 2: USING FREQUENCY ARRAY (OPTIMIZED FOR CONSTRAINED INPUTS)
//
// If you know the constraints are:
//   1 <= nums[i] <= 100
//   k >= 0
// The below class could be used for even faster performance.
//
class SolutionWithFreqArray {
    public int countKDifference(int[] nums, int k) {
        int ans = 0;
        int[] freqarr = new int[101];

        for (int num : nums) {
            int complementPos = num + k;
            int complementNeg = num - k;

            if (complementNeg >= 1 && complementNeg <= 100) {
                ans += freqarr[complementNeg];
            }

            if (complementPos >= 1 && complementPos <= 100) {
                ans += freqarr[complementPos];
            }

            freqarr[num]++;
        }

        return ans;
    }
}
