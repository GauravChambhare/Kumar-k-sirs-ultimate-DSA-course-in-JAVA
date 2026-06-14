import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class InsertionSortPart2 {
    static void insertionSort(int[] arr, int n){
        int value = arr[n];
        int i = n;
        while(i>0 && arr[i-1]>value){
            arr[i] = arr[i-1];
            i--;
        }
        arr[i] = value;
        printArr(arr);
        return;
    }
    static void printArr(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        return;
        
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
      for(int i=1; i<n; i++){
         insertionSort(arr, i);
      }
      return;
      
    }
}