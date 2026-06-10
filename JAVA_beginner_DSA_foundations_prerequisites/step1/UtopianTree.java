import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class UtopianTree {
    public static void main(String args[]) {
      
      Scanner in = new Scanner(System.in);
      int n = in.nextInt(); // no of testcases
      for(int i=0; i<n; i++){
        int cycles = in.nextInt();
        int height = 1;
        for(int j=1; j<=cycles; j++){
            height = j%2!=0 ? height*2 : height+1;
        }
        System.out.println(height);
      }
      return;
    }
      
}