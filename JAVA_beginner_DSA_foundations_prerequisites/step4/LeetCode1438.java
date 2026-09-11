package JAVA_beginner_DSA_foundations_prerequisites.step4;

// LeetCode 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
// Problem link: https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
/**
 * Given an array of integers nums and an integer limit, return the size of the longest
 * non-empty subarray such that the absolute difference between any two elements of this subarray is less than or equal to limit.
 * 
 * Example:
 * Input: nums = [8,2,4,7], limit = 4
 * Output: 2
 * Explanation: All subarrays are:
 * [8] with maximum absolute diff |8-8| = 0 <= 4.
 * [8,2] with max abs diff |8-2| = 6 > 4.
 * [8,2,4] with max abs diff = 6 > 4.
 * [8,2,4,7] with max abs diff = 6 > 4.
 * [2] with max abs diff = 0 <= 4.
 * [2,4] with max abs diff = 2 <= 4.
 * [2,4,7] with max abs diff = 5 > 4.
 * [4] with max abs diff = 0 <= 4.
 * [4,7] with max abs diff = 3 <= 4.
 * [7] with max abs diff = 0 <= 4.
 * Therefore, the size of the longest such subarray is 2.
 */

import java.util.*;

public class LeetCode1438 {

    /**
     * Optimized Approach using TreeMap
     * Maintains a window [i, j] such that the absolute difference between max and min is <= limit
     * TreeMap is used to keep track of window's values and their frequencies
     */
    public static int longestSubarrayOptimized(int[] nums, int limit) {
        TreeMap<Integer, Integer> ts = new TreeMap<>();
        int globalMax = 0;
        int n = nums.length;
        
        int i = 0;
        for(int j = 0; j < n; j++){
            // Insert nums[j] into the TreeMap with correct frequency
            ts.put(nums[j], ts.getOrDefault(nums[j], 0) + 1);
            
            // While the difference between max and min exceeds the limit, move window's start forward
            while(ts.lastKey() - ts.firstKey() > limit && i <= j){
                int freq = ts.get(nums[i]);
                if(freq == 1){
                    ts.remove(nums[i]);
                } else {
                    ts.put(nums[i], freq - 1);
                }
                i++;
            }
            // Update the maximum subarray length seen so far
            globalMax = Math.max(globalMax, j - i + 1);
        }
        return globalMax;
    }

    /**
     * Approach using a custom TreeMultiSet
     * Alternative implementation to maintain an ordered multiset
     * Not used frequently in standard Java but implemented here for educational purpose
     */
    static class TreeMultiSet<T> implements Iterable<T> {
        private final TreeMap<T, Integer> map;
        private int size;

        public TreeMultiSet() {
            map = new TreeMap<>();
            size = 0;
        }

        public TreeMultiSet(boolean reverse) {
            if (reverse) {
                map = new TreeMap<>(Collections.reverseOrder());
            } else {
                map = new TreeMap<>();
            }
            size = 0;
        }

        public void clear() {
            map.clear();
            size = 0;
        }

        public int size() {
            return size;
        }

        public int setSize() {
            return map.size();
        }

        public boolean contains(T a) {
            return map.containsKey(a);
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public Integer get(T a) {
            return map.getOrDefault(a, 0);
        }

        public void add(T a, int count) {
            int cur = get(a);
            map.put(a, cur + count);
            size += count;
            if (cur + count == 0) {
                map.remove(a);
            }
        }

        public void addOne(T a) {
            add(a, 1);
        }

        public void remove(T a, int count) {
            add(a, Math.max(-get(a), -count));
        }

        public void removeOne(T a) {
            remove(a, 1);
        }

        public void removeAll(T a) {
            remove(a, Integer.MAX_VALUE - 10);
        }

        public T ceiling(T a) {
            return map.ceilingKey(a);
        }

        public T floor(T a) {
            return map.floorKey(a);
        }

        public T first() {
            return map.firstKey();
        }

        public T last() {
            return map.lastKey();
        }

        public T higher(T a) {
            return map.higherKey(a);
        }

        public T lower(T a) {
            return map.lowerKey(a);
        }

        public T pollFirst() {
            T a = first();
            removeOne(a);
            return a;
        }

        public T pollLast() {
            T a = last();
            removeOne(a);
            return a;
        }

        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                private final Iterator<T> iter = map.keySet().iterator();
                private int count = 0;
                private T curElement;

                public boolean hasNext() {
                    return iter.hasNext() || count > 0;
                }

                public T next() {
                    if (count == 0) {
                        curElement = iter.next();
                        count = get(curElement);
                    }
                    count--;
                    return curElement;
                }
            };
        }
    }

    /**
     * Alternative approach using custom TreeMultiSet
     * This can be helpful if replicating TreeMap functionality is required for certain platforms
     */
    public static int longestSubarrayWithTreeMultiSet(int[] nums, int limit) {
        TreeMultiSet<Integer> ts = new TreeMultiSet<>();
        int globalMax = 0;
        int n = nums.length;

        int i = 0;
        for(int j = 0; j < n; j++){
            // Add current element to the TreeMultiSet
            ts.addOne(nums[j]);

            // Reduce window from left until the max - min difference is within limit
            while(ts.last() - ts.first() > limit && i <= j){
                ts.removeOne(nums[i]);
                i++;
            }
            globalMax = Math.max(globalMax, j - i + 1);
        }
        return globalMax;
    }

    /**
     * Main method to demonstrate/test both approaches on hard-coded test cases
     */
    public static void main(String[] args) {
        // Hardcoded Test Case 1
        int[] nums1 = {8,2,4,7};
        int limit1 = 4;

        // Hardcoded Test Case 2
        int[] nums2 = {10,1,2,4,7,2};
        int limit2 = 5;

        // Hardcoded Test Case 3
        int[] nums3 = {4,2,2,2,4,4,2,2};
        int limit3 = 0;

        System.out.println("Testing LeetCode 1438 on hardcoded inputs:\n");

        System.out.println("Approach 1: TreeMap");
        System.out.println("Test case 1: " + Arrays.toString(nums1) + ", limit = " + limit1 +
                " => Output: " + longestSubarrayOptimized(nums1, limit1));
        System.out.println("Test case 2: " + Arrays.toString(nums2) + ", limit = " + limit2 +
                " => Output: " + longestSubarrayOptimized(nums2, limit2));
        System.out.println("Test case 3: " + Arrays.toString(nums3) + ", limit = " + limit3 +
                " => Output: " + longestSubarrayOptimized(nums3, limit3));

        System.out.println("\nApproach 2: TreeMultiSet");
        System.out.println("Test case 1: " + Arrays.toString(nums1) + ", limit = " + limit1 +
                " => Output: " + longestSubarrayWithTreeMultiSet(nums1, limit1));
        System.out.println("Test case 2: " + Arrays.toString(nums2) + ", limit = " + limit2 +
                " => Output: " + longestSubarrayWithTreeMultiSet(nums2, limit2));
        System.out.println("Test case 3: " + Arrays.toString(nums3) + ", limit = " + limit3 +
                " => Output: " + longestSubarrayWithTreeMultiSet(nums3, limit3));
    }
}
