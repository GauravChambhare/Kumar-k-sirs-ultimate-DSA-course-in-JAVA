import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class InsertionSortPart1 {
    public static void main(String args[]) {      
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      int[] arr = new int[n];
      for(int i=0; i<n; i++) { 
        arr[i] = in.nextInt();
      }
      int value = arr[n-1];
      int i=n-1;
      while(i>0 && arr[i-1]>value){
        arr[i] = arr[i-1];
        printArray(arr);
        i--;
      }
      arr[i] = value;
      printArray(arr); 
      
      return;     
    }
    static void printArray(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        return;
    }
}
