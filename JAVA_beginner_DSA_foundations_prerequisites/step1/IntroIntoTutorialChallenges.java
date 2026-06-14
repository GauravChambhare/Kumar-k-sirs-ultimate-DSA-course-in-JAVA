import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class IntroIntoTutorialChallenges { // TC is O(n) and SC is O(1)
    public static void main(String args[]) {
      Scanner in = new Scanner(System.in);
      int v = in.nextInt();
      int n = in.nextInt();
      int[] arr = new int[n];
      for(int i = 0 ;i<n;i++){
          arr[i] = in.nextInt();
      }
// finding the index of value v
      for(int i=0; i<n; i++){
          if(arr[i]==v) System.out.println(i);
      }
      return;
    }
}
