package JAVA_beginner_DSA_foundations_prerequisites.step4;
import java.util.*;

/*
 * Que: Count All ((i,j) pairs such that b[i] - b[j] == k (count of such pairs.) [i<j].
*/
public class HashingSession7 {
    public static void main(String[] args) {
        // Approach 1 
        // BRUTE FORCE
        int[] arr = new int[]{1, 5, 2, 4, 1};
        int k = 3;
        int n = arr.length;
        /*
         * But since we will be considering pars i, j such that i<j
         * (5, 2) and (1, 4)
        */
        int ans =0;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i]-arr[j]==k){
                    ans++;
                }
            }
        }
        System.out.println("Brute force appraoch ans is : " + ans);

        // Now useing optimized approach
        // We will use HashMap
        int ans2=0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            // We need to check if there exist b[previousIndex] = b[i] + k
            int valNow = arr[i] + k;
            if(map.containsKey(valNow)){
                // means we have b[i] such that b[previousIndex] - k holds true
                int count = map.get(valNow); // no. of times valNow has occured previously
                ans2+=count;
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        System.out.println("Approach 2 ans is : "+ans2);
        return;
    }    
}
