package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.util.Scanner;

public class MinimumInRotatedSortedArray {
    

    public static int solver(int[] arr){
        int n = arr.length;
        int lo = 0, hi = n - 1;
        // we have to find the minimum value among the given input array.
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] > arr[n - 1]) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return Math.min(arr[lo], arr[hi]);
    }

    // For local run and testing
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int minValue = solver(arr);
        System.out.println("The minimum value in the rotated sorted array is: " + minValue);

        sc.close();
    }
}
