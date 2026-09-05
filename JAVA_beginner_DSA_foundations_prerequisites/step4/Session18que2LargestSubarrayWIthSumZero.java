package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.util.HashMap;
import java.util.Map;

/**
 * Question: Find the length of the largest subarray with sum zero.
 *
 * Given an array of integers, return the length of the longest contiguous subarray whose elements sum to zero.
 *
 * Example:
 *   Input: arr = [15, -2, 2, -8, 1, 7, 10, 23]
 *   Output: 5
 *   Explanation: The largest subarray with sum 0 is [-2, 2, -8, 1, 7] with length 5.
 */
public class Session18que2LargestSubarrayWIthSumZero {
    public static void main(String[] args) {
        Solution2 sol = new Solution2();

        int[] arr1 = {15, -2, 2, -8, 1, 7, 10, 23};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {1, 0, 3, 4, -4, -3, 0, 0};
        int[] arr4 = {0, 0, 0, 0};

        System.out.println("Largest subarray with sum 0 (arr1): " + sol.maxLength(arr1)); // 5
        System.out.println("Largest subarray with sum 0 (arr2): " + sol.maxLength(arr2)); // 0
        System.out.println("Largest subarray with sum 0 (arr3): " + sol.maxLength(arr3)); // 6
        System.out.println("Largest subarray with sum 0 (arr4): " + sol.maxLength(arr4)); // 4
    }
}

class Solution2 {
    public int maxLength(int[] arr) {
        int len = arr.length;
        if(len == 0){
            return 0;
        } else if (len == 1){
            return (arr[0] == 0) ? 1 : 0;
        }
        int ans = 0;
        // Use HashMap to store (prefix sum, first index reached)
        Map<Integer, Integer> mp = new HashMap<>();
        int prefixSum = 0;
        // Important to handle prefix sum "0" at start
        mp.put(0, -1);

        for(int i = 0; i < len; i++){
            prefixSum += arr[i];
            if(mp.containsKey(prefixSum)){
                int prevIdx = mp.get(prefixSum);
                int currLen = i - prevIdx;
                ans = Math.max(ans, currLen);
            } else {
                mp.put(prefixSum, i);
            }
        }
        return ans;
    }
}