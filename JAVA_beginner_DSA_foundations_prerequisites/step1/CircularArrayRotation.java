import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CircularArrayRotation {
    
    public static void main(String args[]) {
        // Initialize scanner to read inputs from the user/HackerRank
        Scanner in = new Scanner(System.in);
        
        // n: Total number of elements
        // k: Total rotations to perform
        // q: Number of specific queries we need to answer
        int n = in.nextInt(); 
        int k = in.nextInt(); 
        int q = in.nextInt(); 
        
        // Create an array to hold the original elements
        int[] arr = new int[n];
        
        // Loop to populate the array with input values
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        
        // Continue processing as long as there are queries left (q decreases by 1 each loop)
        while(q-- > 0){
            // Read the index that the user is asking about in the "rotated" array
            int qryidx = in.nextInt();
            
            // Map the "rotated" index back to the "original" index 
            // to find the value that moved to that position.
            int valueAtqryidx = arr[(qryidx - k%n + n) % n];
            
            // Print the resulting value for this specific query
            System.out.println(valueAtqryidx);
        }
        
        // Explicitly ending the program
        return;
    }
}
