package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
/*
 * Count all i,j pairs where i<j and abs(b[i]-b[j]) = k [k>=0]
 * 
*/

public class HashingSession8 {
        public static void main(String[] args) {
        // Approach 1 
        // BRUTE FORCE
        int[] arr = new int[]{1, 5, 2, 4, 1};
        int k = 3;
        int n = arr.length;
                int ans =0;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(Math.abs(arr[i]-arr[j])==k){ // this time we are checking for absolte difference
                    ans++;
                }
            }
        }
        System.out.println("Brute force approach ans is : " + ans);

        // Now useing optimized approach
        // We will use HashMap
        int ans2=0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int j=0; j<n; j++){
            int valuei = arr[j] + k;
            if(map.containsKey(valuei)){
                int count = map.get(valuei);
                ans2 +=count;
            }
            int value2 = arr[j] - k;
            if(map.containsKey(value2)){
                int count = map.get(value2);
                ans2 +=count;
            }
            map.put(arr[j], map.getOrDefault(arr[j],0)+1);
        }
        System.out.println("Optimised force approach ans is : " + ans2);        
        return;
    }
}
