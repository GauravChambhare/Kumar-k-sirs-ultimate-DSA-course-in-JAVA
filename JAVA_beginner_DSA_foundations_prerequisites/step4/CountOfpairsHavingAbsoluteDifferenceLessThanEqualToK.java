package JAVA_beginner_DSA_foundations_prerequisites.step4;
import java.util.*;

public class CountOfpairsHavingAbsoluteDifferenceLessThanEqualToK {

    public static int bruteForceApproach(int[] arr, int k){
        int ans = 0;
        Arrays.sort(arr);
        int n = arr.length;
        // sorted the array in ascending order
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int diff = Math.abs(arr[j] - arr[i]);
                if(diff <= k){
                    ans++;
                }
            }
        }
        return ans;
    }

    public static int optimizedApproach(int[] arr, int k){
        int ans = 0;

        Arrays.sort(arr);
        for(int i = 0, j = 0; j < arr.length; j++){
            while(arr[j] - arr[i] > k){
                i++;
            }
            ans += j - i + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        // Example test case 1
        int[] arr1 = {1, 3, 5, 7, 9};
        int k1 = 4;
        System.out.println("Test case 1:");
        System.out.println("Array: " + Arrays.toString(arr1));
        System.out.println("k = " + k1);
        System.out.println("Brute Force Output: " + bruteForceApproach(Arrays.copyOf(arr1, arr1.length), k1));
        System.out.println("Optimized Output: " + optimizedApproach(Arrays.copyOf(arr1, arr1.length), k1));
        System.out.println();

        // Example test case 2
        int[] arr2 = {1, 1, 2, 4, 2, 3};
        int k2 = 2;
        System.out.println("Test case 2:");
        System.out.println("Array: " + Arrays.toString(arr2));
        System.out.println("k = " + k2);
        System.out.println("Brute Force Output: " + bruteForceApproach(Arrays.copyOf(arr2, arr2.length), k2));
        System.out.println("Optimized Output: " + optimizedApproach(Arrays.copyOf(arr2, arr2.length), k2));
        System.out.println();

        // Example test case 3
        int[] arr3 = {1, 5, 9, 14};
        int k3 = 3;
        System.out.println("Test case 3:");
        System.out.println("Array: " + Arrays.toString(arr3));
        System.out.println("k = " + k3);
        System.out.println("Brute Force Output: " + bruteForceApproach(Arrays.copyOf(arr3, arr3.length), k3));
        System.out.println("Optimized Output: " + optimizedApproach(Arrays.copyOf(arr3, arr3.length), k3));
        System.out.println();
    }
}
