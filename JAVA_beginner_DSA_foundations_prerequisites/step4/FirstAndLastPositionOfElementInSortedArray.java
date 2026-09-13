package JAVA_beginner_DSA_foundations_prerequisites.step4;

/**
 * Problem: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * Approach: sorted binary array template approach
 *
 * Time Complexity: O(log n), where n is the length of the input array nums.
 * Space Complexity: O(1), only a constant amount of extra space is used.
 */
public class FirstAndLastPositionOfElementInSortedArray {

    /**
     * Finds the first and last position of a target element in a sorted array.
     * @param nums Sorted input array
     * @param target Target value to look for
     * @return int array of size 2, ans[0]=first index, ans[1]=last index (both -1 if not found)
     */
    public static int[] searchRange(int[] nums, int target) {
        int N = nums.length;
        int L = -1, R = N, first, last;

        // Find leftmost (first) position
        while (L + 1 < R) {
            int mid = L + (R - L) / 2;
            if (nums[mid] < target) {
                L = mid;
            } else {
                R = mid;
            }
        }
        if (R == N || nums[R] != target) first = -1;
        else first = R;

        // Find rightmost (last) position
        int Lp = -1, Rp = N;
        while (Lp + 1 < Rp) {
            int mid = Lp + (Rp - Lp) / 2;
            if (nums[mid] <= target) {
                Lp = mid;
            } else {
                Rp = mid;
            }
        }
        if (Lp == -1 || nums[Lp] != target) last = -1;
        else last = Lp; 

        return new int[]{first, last};
    }

    // Example usage & testing
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] res = searchRange(nums, target);
        System.out.printf("First and Last Position of %d: [%d, %d]\n", target, res[0], res[1]);

        int[] nums2 = {5,7,7,8,8,10};
        int target2 = 6;
        int[] res2 = searchRange(nums2, target2);
        System.out.printf("First and Last Position of %d: [%d, %d]\n", target2, res2[0], res2[1]);

        int[] nums3 = {};
        int target3 = 0;
        int[] res3 = searchRange(nums3, target3);
        System.out.printf("First and Last Position of %d: [%d, %d]\n", target3, res3[0], res3[1]);
    }
}
