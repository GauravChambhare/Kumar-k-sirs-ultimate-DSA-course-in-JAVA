package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

// https://leetcode.com/problems/two-sum/description/
//  TWO SUM PROBLEM
public class Session16part1que2TwoSum {
    
    public static int[] solverBruteForce(int[] arr, int target){
        // Use brute force (quadratic time) to find indices of two numbers that add up to target
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{}; // if no solution found
    }

    public static int[] solverHashMap(int[] arr, int target){
        // More efficient approach using a hash map (O(n) time)
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int complement = target - arr[i];
            if(numToIndex.containsKey(complement)){
                return new int[] {numToIndex.get(complement), i};
            }
            numToIndex.put(arr[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] resultBrute = solverBruteForce(arr, target);
        int[] resultHash = solverHashMap(arr, target);

        System.out.println("Brute force solution: " + Arrays.toString(resultBrute));
        System.out.println("Hash map solution: " + Arrays.toString(resultHash));

        // Try a test with no solution
        int[] arr2 = {1, 2, 3};
        int t2 = 7;
        System.out.println("No solution: " + Arrays.toString(solverBruteForce(arr2, t2)));
    }
}
