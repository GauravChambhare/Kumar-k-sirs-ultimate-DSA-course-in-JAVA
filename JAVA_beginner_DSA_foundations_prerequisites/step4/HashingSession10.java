package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.util.HashMap;
import java.util.Map;

public class HashingSession10 {

    public static int noOfSubarraysBruteForce(int arr[], int k){

        int ans=0;
        if(arr.length==1){
            int ans1 = arr[0]==k ? 1 : 0;
            return ans1;
        }
        // we will initialize r from 1  
        for(int r=0; r<arr.length; r++){
            int sum=0;
            for(int l=r; l>=0; l--){
                sum+=arr[l];
                if(sum==k) ans++;
            }
        }
        return ans;
    }

    public static int noOfSubarraysOptimized(int arr[], int k){
        int ans=0;
        // although we are going to follow prefix sum approach, we dont necessarily need to declare a 
        // prefix sum array, instead we can use a temp var 
        Map<Integer, Integer> cSM = new HashMap<>();
        int currentSum = 0;
        // we are adding the base case below, which happens when the sum till now is ==k
        cSM.put(0, 1);
        for(int num : arr){
            currentSum += num;
            if(cSM.containsKey(currentSum-k)){  //i.e 
                ans += cSM.get(currentSum-k);
            }
            cSM.put(currentSum, cSM.getOrDefault(currentSum, 0)+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        
        int[] arr = new int[]{2, 4, 5, 8, 1, 6, 3};
        int k = 6; // i.e count no of subarrays whose sum of elements = 6 | 2, 4 & 6

        System.out.println(noOfSubarraysBruteForce(arr, k));
        return;
    }
}
