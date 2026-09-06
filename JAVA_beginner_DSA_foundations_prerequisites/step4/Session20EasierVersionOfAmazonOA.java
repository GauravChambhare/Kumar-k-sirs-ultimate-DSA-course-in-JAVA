package JAVA_beginner_DSA_foundations_prerequisites.step4;
import java.util.*;

public class Session20EasierVersionOfAmazonOA {

    /*
    Count Subarrays Where Subarray Sum Equals Length (Sum = j - i + 1)
    Given an array of integers arr, find the number of continuous subarrays (i, j) such that 
    the sum of the subarray elements is equal to its length (j - i + 1).
    */

    // This method finds the number of such subarrays in arr
    public static int secutiryFeature(int[] arr, int n) {
        int ans = 0;
        // Edge case: if there's only 1 element, only possible if arr[0] == 1
        if(n == 1) {
            return (arr[0] == 1) ? 1 : 0;
        }

        // Use prefix sum and hash map approach.
        // We will maintain a prefix sum (sum of all elements from 0 to i)
        // such that we can check sum of any subarray quickly.

        // We need to use arr[0..n-1] (not 1-based index), so adjust loop below accordingly
        int[] p = new int[n+1]; // p[0] = 0, p[i] stores sum of arr[0] to arr[i-1]

        for(int i = 1; i <= n; i++) {
            p[i] = p[i-1] + arr[i-1];
        }

        // Map to store frequency of (prefix sum - current index)
        Map<Integer, Integer> mp = new HashMap<>();

        // We must put (0, 1) in the map to handle the case where the subarray starts at index 0.
        // That is, for any j, if p[j] - j == 0, we should count subarrays starting at index 0.
        // Otherwise, these would be missed.
        mp.put(0, 1);

        for(int j = 1; j <= n; j++) {
            int val = p[j] - j;

            // If `val` has occurred before, it means for some i < j, p[i] - i == val,
            // so the subarray arr[i...j-1] has the property: sum = length
            ans += mp.getOrDefault(val, 0);

            // Record the count of this value for future subarrays
            mp.put(val, mp.getOrDefault(val, 0) + 1);
        }

        return ans;
    }

    // main method for local testing
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 1};
        System.out.println("Subarrays (arr1): " + secutiryFeature(arr1, arr1.length)); // Expected: 6

        int[] arr2 = {1, 0, 1, 1};
        System.out.println("Subarrays (arr2): " + secutiryFeature(arr2, arr2.length)); // Expected: 6

        int[] arr3 = {0, 0, 0};
        System.out.println("Subarrays (arr3): " + secutiryFeature(arr3, arr3.length)); // Expected: 0

        int[] arr4 = {1};
        System.out.println("Subarrays (arr4): " + secutiryFeature(arr4, arr4.length)); // Expected: 1

        int[] arr5 = {5, -3, -1, 0};
        System.out.println("Subarrays (arr5): " + secutiryFeature(arr5, arr5.length)); // Example with negatives
    }
}