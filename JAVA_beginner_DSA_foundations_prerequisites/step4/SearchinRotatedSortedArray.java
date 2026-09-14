package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.util.Scanner;

/*
    Problem: Search in Rotated Sorted Array

    You are given an integer array 'nums' which is sorted in ascending order and then rotated at some pivot unknown to you beforehand.

    You are given a target value to search. If found in the array return its index, otherwise return -1.

    The array contains unique elements.

    Example:
    Input: nums = [4,5,6,7,0,1,2], target = 0
    Output: 4

    Constraints:
    - Time Complexity: O(log n)
    - Space Complexity: O(1)

    Approach:
    Uses the binary search template where lo = -1 and hi = n.
    This template divides the space as (lo, hi), and contracts it by moving lo or hi based on conditions.

    https://leetcode.com/problems/search-in-rotated-sorted-array/description/
*/

public class SearchinRotatedSortedArray {

    public static int finder(int[] nums, int target){
        int n = nums.length;
        int lo = -1;
        int hi = n;

        while(lo + 1 < hi){
            int mid = lo + (hi - lo) / 2;

            if(nums[mid] == target){
                return mid;
            }

            // Figure out which half is sorted
            if(nums[0] <= nums[mid]){
                // Left part is sorted
                if(nums[0] <= target && target < nums[mid]){
                    hi = mid;
                } else {
                    lo = mid;
                }
            } else {
                // Right part is sorted
                if(nums[mid] < target && target <= nums[n - 1]){
                    lo = mid;
                } else {
                    hi = mid;
                }
            }
        }
        return -1;
    }

    // For local run and testing
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array size:");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }

        System.out.println("Enter target value:");
        int target = sc.nextInt();

        int idx = finder(nums, target);

        if(idx != -1){
            System.out.println("Target found at index: " + idx);
        } else {
            System.out.println("Target not found in array.");
        }
        sc.close();
    }
}
