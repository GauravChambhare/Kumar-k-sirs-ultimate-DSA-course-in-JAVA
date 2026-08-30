package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.util.*;

// Given an array “nums” of size “N” - find the total number of pairs(i,j) [i<j] such that (nums[i] + nums[j])%k = 0 (nums[i]>=0,K>=2)
//  TC is O(N) and SC is O(1)
public class Session7 {
    
    public static int countOfPairs(int[] a, int k){
        int ans = 0;
        int[] freqArr = new int[k]; // we can slo used hashMpa if we want to

        for(int j=0; j< a.length; j++){
            //
            int reminderJ = (a[j]%k + k)%k;  // remainder value of j index position value
            int reminderTraget =  ( k - reminderJ ) % k;
            ans += freqArr[reminderTraget];
            freqArr[reminderJ]++;
        }


        return ans;

    }

    public static void main(String[] args) {
    // 2,3 | 2,3 | 3,2 | 3,2| 5,5 | 2,3 | 2,3
        System.out.println("Count of satiisfying pairs is : "+ countOfPairs(new int[]{2, 3, 5, 2, 2, 5, 3}, 5));
    }
}
