package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Find count of largest/smallest subarrays with sum k in a given array
public class Session12{

    // Returns {countOfSmallestLenSubarrays, countOfLargestLenSubarrays}
    // among all subarrays whose sum equals k.
    static int[] countLargestSmallest(int[] arr, int k) {
        // Use long for prefix sums to handle potential integer overflow

        int maxLength = Integer.MIN_VALUE;
        int minLength = Integer.MAX_VALUE;
        int countMin = 0, countMax = 0;

        // Map from prefixSum (Long) -> list of indices where that sum was seen
        Map<Long, List<Integer>> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0L, new ArrayList<>(Arrays.asList(-1))); // Handles subarrays starting from index 0

        long currentPrefixSum = 0L;
        for (int i = 0; i < arr.length; i++) {
            currentPrefixSum += arr[i];
            long targetPrefixSum = currentPrefixSum - (long)k;

            if (prefixSumMap.containsKey(targetPrefixSum)) {
                List<Integer> indices = prefixSumMap.get(targetPrefixSum);
                for (int index : indices) {
                    int L = i - index;
                    // Update max length and its count
                    if (L > maxLength) {
                        maxLength = L;
                        countMax = 1;
                    } else if (L == maxLength) {
                        countMax++;
                    }
                    // Update min length and its count
                    if (L < minLength) {
                        minLength = L;
                        countMin = 1;
                    } else if (L == minLength) {
                        countMin++;
                    }
                }
            }
            prefixSumMap.computeIfAbsent(currentPrefixSum, v -> new ArrayList<>()).add(i);
        }

        if (minLength == Integer.MAX_VALUE) {
            return new int[] {0, 0};
        }
        return new int[] {countMin, countMax};
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, -4, 5, 3, -2, 4, -1, 3};
        int k = 1;
        int[] ans = countLargestSmallest(arr, k);
        System.out.println(
            "For subarrays with sum == " + k
            + ", count of smallest-length = " + ans[0]
            + " & count of largest-length = " + ans[1]
        );
    }
}