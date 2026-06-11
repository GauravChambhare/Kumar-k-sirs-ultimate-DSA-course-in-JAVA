import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;




public class CutTheSticks {
    public static void main(String args[]) {
      Scanner in = new Scanner(System.in);
      int n  = in.nextInt(); 
      int[] arr = new int[n];
      for(int i = 0 ;i<n;i++){
          arr[i] = in.nextInt();
      }
      // Optimised approach
      //Sorting the array first in O(nlogn)
      Arrays.sort(arr);
      int totalSticksRemaining = n;
      int curr = arr[0]; // smallest value remaining after sorting, this will keep getting updated as we move to next smallest values,i.e value greater just greater than curr
      int curr_count = 0; // count of curr(current element), initialized to 1 as curr is present once.
      System.out.println(totalSticksRemaining); // printing initial no of sticks
      for(int i=0; i<n; i++){
        if(curr==arr[i]){
            curr_count++;
        } else { // no is different than previous number
            totalSticksRemaining -= curr_count; // remaing sticks will be 
            curr_count = 1;
            curr = arr[i];
            System.out.println(totalSticksRemaining);
        }
      }
      return;
    }
}