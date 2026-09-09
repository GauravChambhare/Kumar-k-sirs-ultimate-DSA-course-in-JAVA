package JAVA_beginner_DSA_foundations_prerequisites.step4;
import java.util.*;

public class CountOfSubarraysHavingSumGreaterThanEqualToK {

    /**
     * Explanation:
     * This approach uses the fact that:
     * Total number of subarrays with sum >= k = Total subarrays - count of subarrays with sum < k.
     * So, we count subarrays with sum less than k using a sliding window,
     * and subtract from total possible subarrays (n*(n+1)/2).
     */
    public static long approachUsingSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        long totalSubarrays = n * (long)(n + 1) / 2;
        long countLessThanK = 0;
        int windowSum = 0;

        for (int i = 0, j = 0; j < n; j++) {
            windowSum += arr[j];
            while (windowSum >= k && i <= j) {
                windowSum -= arr[i];
                i++;
            }
            countLessThanK += (j - i + 1);
        }

        return totalSubarrays - countLessThanK;
    }

    /**
     * Brute Force explanation:
     * This approach checks every possible subarray of the given array
     * and counts only those where the sum is >= k. It's O(n^2), meant for small input size.
     */
    public static long bruteForce(int[] arr, int k) {
        int n = arr.length;
        long count = 0;
        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int end = start; end < n; end++) {
                sum += arr[end];
                if (sum >= k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Example usage and test
        // Scanner can be used to read input if desired, here's a hardcoded demo
        int[] arr = {1, 1, 2, 4, 2, 3};
        int k = 4;

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("k = " + k);

        long resultSlidingWindow = approachUsingSlidingWindow(arr, k);
        long resultBruteForce = bruteForce(arr, k);

        System.out.println("Count of subarrays with sum >= k (Sliding Window): " + resultSlidingWindow);
        System.out.println("Count of subarrays with sum >= k (Brute Force): " + resultBruteForce);

        // You can uncomment this if you want to read from the user:
        /*
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(approachUsingSlidingWindow(arr, k));
        */
    }
}
/*
Sample Output:
Array: [1, 1, 2, 4, 2, 3]
k = 4
Count of subarrays with sum >= k (Sliding Window): 9
Count of subarrays with sum >= k (Brute Force): 9
*/