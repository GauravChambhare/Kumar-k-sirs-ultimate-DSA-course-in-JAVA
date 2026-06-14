import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RunningTimeOfAlgorithms {
    static int insertionSort(int[] arr, int n){
        int value = arr[n];
        int i = n;
        int shifts = 0;
        // The problem explicitly states: "Do not shift an element if it is not necessary". Check if your loop continues even when arr[j] <= value, which would cause unnecessary shifts and overcounting.
        while(i>0 && arr[i-1]>value){
            arr[i] = arr[i-1];
            shifts+=1;
            i--;
        }
        if(arr[i]!=value){
            arr[i] = value; 
        }
        return shifts;
    }
    
    public static void main(String args[]) {
      
      Scanner in = new Scanner(System.in);
      int n ; 
      n = in.nextInt();
      int[] arr;
      arr = new int[n];
      for(int i = 0 ;i<n;i++){
          arr[i] = in.nextInt();
      }
      // main logic 
      int ans=0;
      for(int i=1; i<n; i++){
         ans +=insertionSort(arr, i);
      }
      System.out.println(ans);
      return;
    }
}