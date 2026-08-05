package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.util.HashMap;
import java.util.Map;

// Find count of largest/smallest subarrays with sum k in a given array
public class HashingSession13 {

    // Returns {countOfSmallestLenSubarrays, countOfLargestLenSubarrays}
    // among all subarrays whose sum equals k.
    static int[] countLargestSmallest(int[] arr, int k) {
        // TODO: implement using prefix sum + hashing
        return new int[] {0, 0};
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, -4, 5, 3, -2, 4};
        int k = 6;
        int[] ans = countLargestSmallest(arr, k);
        System.out.println(
            "For subarrays with sum == " + k
            + ", count of smallest-length = " + ans[0]
            + " & count of largest-length = " + ans[1]
        );
    }
}
