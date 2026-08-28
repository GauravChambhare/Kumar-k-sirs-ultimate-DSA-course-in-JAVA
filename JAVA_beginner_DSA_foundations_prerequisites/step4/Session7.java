package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.util.*;

public class Session7 {
    
    public static int countOfPairs(int[] a, int k){
        int ans = 0;
        int[] freqArr = new int[k];

        for(int j=0; j< a.length; j++){
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
