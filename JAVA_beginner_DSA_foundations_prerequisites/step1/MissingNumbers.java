import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class MissingNumbers {
    public static void main(String args[]) {
      
      Scanner in = new Scanner(System.in);
      int sizeA = in.nextInt();
      int[] arrA = new int[sizeA];
      
      for(int i=0; i<sizeA; i++){
            arrA[i] = in.nextInt();
      }
      
      int sizeB = in.nextInt();
      int[] arrB = new int[sizeB];
      for(int i=0; i<sizeB; i++){
            arrB[i] = in.nextInt();
      }
      // declaring a frequency array of size 10001 as 
      // it is given that each element value in brr belongs to [1, 10^4]
      int[] freqarr = new int[10001];
      for(int b : arrB){
        freqarr[b]++;
      }
      for(int a : arrA){
        freqarr[a]--;
      }
      // now printing elements of arrB if that element has freq>1 in freqarr post above two operations
      for(int i=1; i<freqarr.length; i++){
        if(freqarr[i]>0){
            System.out.print(i + " ");
        }
      }
      // TC = O(M) ; SC = O(1)
      return;
    }
}