import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MarkAndToys { //tc O(nlogn) and sc = O(1) if input storing is not considered.
    public static void main(String args[]) {
      Scanner in = new Scanner(System.in);
      int n, k ; 
      n = in.nextInt(); // no of toys on sale
      k = in.nextInt(); // budget
      int[] arr= new int[n];
      for(int i=0; i<n; i++){
          arr[i] = in.nextInt();
      }
      // sorting the prices in ascending order
      Arrays.sort(arr);
      int currentSum=0;
      int ans=0;
      for(int i=0; i<n; i++){
        if(currentSum<=k){
            currentSum += arr[i];
            ans = currentSum<=k ? ans+1 : ans +0; // it is imp to check this post current current sum is updated. 
            // as it might happen that we did currentSum +=arr[i] and not it has exceeded buget, and without any checking if budget has exceeded we are still incrementing ans
        } else {
            break;
        }
      }
      System.out.println(ans);
      return;
    }
}