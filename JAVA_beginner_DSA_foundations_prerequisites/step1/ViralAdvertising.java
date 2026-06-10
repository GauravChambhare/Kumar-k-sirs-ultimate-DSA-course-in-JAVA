import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class ViralAdvertising {
    public static void main(String args[]) {
      
      Scanner in = new Scanner(System.in);
      int day = in.nextInt();
      int totalLikes = 0;
      int sharedTotal = 5;
      
      while(day-->0){
        totalLikes+=sharedTotal/2;
        sharedTotal = sharedTotal/2*3;
      }
      System.out.println(totalLikes);
      return;
    }
}