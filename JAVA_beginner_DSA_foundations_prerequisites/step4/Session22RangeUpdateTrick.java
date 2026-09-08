package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.util.Scanner;

public class Session22RangeUpdateTrick {

    // Optimized Range Update Solution
    public int[] solve(int[] arr, int q, Scanner sc) {
        // 1. Create a result array with an extra element to handle the right boundary + 1
        int[] result = new int[arr.length + 1];

        // 2. Process each range update query
        for (int i = 0; i < q; i++) {
            int left = sc.nextInt();
            int right = sc.nextInt();

            // Mark the start and end of the update range
            // This adds 1 at the left index and subtracts 1 after the right index
            result[left] = result[left] + 1;
            result[right + 1] = result[right + 1] - 1;
        }

        // 3. Compute the prefix sum to get the final values
        // We iterate through the array to accumulate the changes
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i] + result[i - 1];
        }

        // Remove the extra element at the end before returning
        int[] finalResult = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            finalResult[i] = arr[i] + result[i];
        }

        return finalResult;
    }

    // Add a main method to allow running on local machine
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Example input:
        // First line: n (size of array), q (number of queries)
        // Next line: n integers (initial array)
        // Next q lines: 2 integers (left and right for each query)

        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Session22RangeUpdateTrick obj = new Session22RangeUpdateTrick();
        int[] result = obj.solve(arr, q, sc);

        // Print the final array after all the range updates
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();

        sc.close();
    }
}
