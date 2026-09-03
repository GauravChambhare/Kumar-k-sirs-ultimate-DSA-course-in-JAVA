package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.util.HashMap;
import java.util.Map;

public class Session16part2que1MaxDistancebetweenTwoOccurences {
    
    static class Solution {
        public int maxDistance(int[] arr) {
            
            int n = arr.length;
            if(n < 2) return 0;
            
            Map<Integer, Integer> firstOccurence = new HashMap<>();
            int maxDistance = 0;
            // Populating the first occurrence as well as finding length;
            for(int i = 0; i < n; i++) {
                if(!firstOccurence.containsKey(arr[i])) {
                    firstOccurence.put(arr[i], i);
                } else {
                    int len = i - firstOccurence.get(arr[i]);
                    maxDistance = Math.max(len, maxDistance);
                }
            }
            return maxDistance;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // Example test cases
        int[] arr1 = {1, 2, 3, 2, 1, 4, 1};
        System.out.println("Max distance (arr1): " + sol.maxDistance(arr1)); // Expected: 6 (between arr[0] and arr[6])

        int[] arr2 = {4, 4, 4, 4};
        System.out.println("Max distance (arr2): " + sol.maxDistance(arr2)); // Expected: 3

        int[] arr3 = {1, 2, 3, 4, 5};
        System.out.println("Max distance (arr3): " + sol.maxDistance(arr3)); // Expected: 0

        int[] arr4 = {1};
        System.out.println("Max distance (arr4): " + sol.maxDistance(arr4)); // Expected: 0

        int[] arr5 = {};
        System.out.println("Max distance (arr5): " + sol.maxDistance(arr5)); // Expected: 0
    }
}
