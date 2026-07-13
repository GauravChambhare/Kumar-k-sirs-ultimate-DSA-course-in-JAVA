package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.util.HashMap;
import java.util.Map;

// Find largest/smallest subarray with sum k in Given Array
public class HashingSession11 {
    
    static int[] optimized(int[] arr, int k){ 
        int n = arr.length;
        int[] P = new int[n];

        P[0] = arr[0];
        for(int i=1; i<n; i++){
            P[i] = P[i-1] + arr[i];
        }
        Map<Integer, Integer> map = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        int maxLen = Integer.MIN_VALUE;
        for(int j=0; j<n; j++){
            if(map.containsKey(P[j]-k)){
                int i = map.get(P[j]-k);
                int len = j-i;
                minLen = Math.min(len, minLen);
                maxLen = Math.max(len, maxLen);
            }
            map.put(P[j], j);
        }

        return new int[] {minLen, maxLen};
    }
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, -4, 5, 3, -2, 4};
        int k=6;
        int[] ans;
        ans = optimized(arr, k);
        System.out.println("For subarrays having subarray sum length == "+k+" , minLength is "+ans[0]+" & maxLength is "+ans[1]);
    }
}
