package JAVA_beginner_DSA_foundations_prerequisites.step4;
import java.util.*;
// IBM OA question
// Given an array of integers a of size n and an integer d, count the number of distinct triplets (i, j, k)
//  such that 0 < i < j < k <= n and the sum (a[i] + a[j] + a[k]) is divisible by d
public class Session8Approach1 {
    // Time complexity O(N^2) Space complexity O(d)
    public static int countOfTriplets(int[] a, int d){
        int ans = 0;
        // we will fix right most element will be k in ourcase

        int[] pairs_rem_freq = new int[d];

        for(int k=0; k<a.length; k++){

            // ew calculate the remainderK
            int remainderK = (a[k]%d + d)%d ; // this is remainder value of k%d
            int targetRemIJ = (d - remainderK)%d; // this is the required remainder value for remainderK and its sum to be perfectly divisible by d
            ans = ans + pairs_rem_freq[targetRemIJ];
            // now for all pairs of which right element's index position is k-1 we are calculating such pair sum remainder values
            // example (a[0] + a[k])%d, (a[1] + a[k])%d,....(a[k-2] + a[k-1])%d

            for(int u=0; u<k; u++){
                int pairSumRem = (a[k] + a[u] ) % d;
                pairs_rem_freq[pairSumRem]++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        
        int[] a = new int[] {3, 3, 4, 7, 8};
        int d = 5;
        System.out.println("Count of satisying sum of triplets  % 5 == 0 for array {3, 3, 4, 7, 8}"  +" is "+ countOfTriplets(a, d));
    }
}
