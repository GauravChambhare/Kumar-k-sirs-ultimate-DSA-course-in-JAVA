package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.util.HashSet;

public class Session18que1LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int[] nums3 = {1, 2, 0, 1};
        int[] nums4 = {}; // empty array

        System.out.println("Longest consecutive sequence in nums1: " + sol.longestConsecutive(nums1)); // 4
        System.out.println("Longest consecutive sequence in nums2: " + sol.longestConsecutive(nums2)); // 9
        System.out.println("Longest consecutive sequence in nums3: " + sol.longestConsecutive(nums3)); // 3
        System.out.println("Longest consecutive sequence in nums4: " + sol.longestConsecutive(nums4)); // 0
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if(len<2) return len;

        // declaring a hashset
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int globalMax = 1;

        for(Integer num : set){
            if(!set.contains(num-1)){ // only if x is a starting of a sequence we will proceed with inner loop
                int x = num;
                int currentLen = 1;
                while(set.contains(x+1)){
                    currentLen++;
                    x++;
                }
                // now I will update the globalMax value
                globalMax = Math.max(globalMax, currentLen);
            }
        }
        return globalMax;
    }
}
