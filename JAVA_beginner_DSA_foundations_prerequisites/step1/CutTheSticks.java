import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class CutTheSticks {
    
    final static int reducer(ArrayList<Integer> currentPile){
        int currentSize = currentPile.size();
        System.out.println(currentSize); // current size of pile before each iteration
        if(currentSize==0) return 0;
        // main reducing logic
        // find the smallest stick size first
        int smallestSize = Integer.MAX_VALUE;
        for(int i=0; i<currentSize; i++){
            if(smallestSize>currentPile.get(i)){
                smallestSize = currentPile.get(i); // tracking the current smallest value in pile
            }
        }
        // now substracting this value from all of the value of currentPile
        for(int i=0; i<currentSize; i++){
            currentPile.set(i, currentPile.get(i) - smallestSize);
        }
        // now all values in currentPile that are zero has to be removed/cleared.
        currentPile.removeIf(element -> element.equals(0));
        return currentPile.size();
        // return current size of remaining pile post removal of all 0 le ngth sticks
    }
    public static void main(String args[]) {
      
      Scanner in = new Scanner(System.in);
      int noOfStickes = in.nextInt();
      ArrayList<Integer> stickPile = new ArrayList<>(noOfStickes);
      for(int i=0; i<noOfStickes; i++){
        stickPile.add(in.nextInt());
      }
    // I have now created my stick pile
    // I can now either write code directly in my main function or in helper function
    while(noOfStickes>0){
        noOfStickes = reducer(stickPile);
    }
    
    return;
  }  
}