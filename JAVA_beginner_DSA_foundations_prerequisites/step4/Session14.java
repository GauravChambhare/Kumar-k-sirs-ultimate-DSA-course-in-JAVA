package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.util.Scanner;

public class Session14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println("Maximum sum of two non-overlapping subarrays: " + maxTwoNonOverlappingSubarraysSum(nums));
    }

    public static int maxTwoNonOverlappingSubarraysSum(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0; // Cannot split into two non-empty subarrays

        // Step 1: Precompute left[i] -> Max subarray sum in nums[0...i]
        int[] left = new int[n];
        int currentMax = nums[0];
        left[0] = nums[0];

        for (int i = 1; i < n; i++) {
            // Kadane's logic: extend previous sum or start fresh
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            // Maintain overall max seen so far on the left side
            left[i] = Math.max(left[i - 1], currentMax);
        }

        // Step 2: Precompute right[i] -> Max subarray sum in nums[i...n-1]
        int[] right = new int[n];
        currentMax = nums[n - 1];
        right[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            // Kadane's logic from right to left
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            // Maintain overall max seen so far on the right side
            right[i] = Math.max(right[i + 1], currentMax);
        }

        // Step 3: Try all valid split points i where left is nums[0...i] and right is nums[i+1...n-1]
        int maxTotalSum = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            maxTotalSum = Math.max(maxTotalSum, left[i] + right[i + 1]);
        }

        return maxTotalSum;
    }
}