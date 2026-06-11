import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class FindDigits {
    public static void main(String args[]) {
      
      Scanner in = new Scanner(System.in);
      int t = in.nextInt();

      for(int i=0; i<t; i++){
        // for each t distinct numbers
        // first fecth the no.
          int num = in.nextInt();
          // create a duplicate for our logic use
          int duplicate = num;
          int ans = 0;
          int digit = 0;
            // we are running below logic for no of digit time in a number 'duplicate'
          while(num>0){
            digit = num%10; // fetching last digit of a number 'num'
            num /=10; // removing last digit from the number 'num'
            if(digit==0) continue; // is digit is 0, then conitnue to next iteration if possible to avoid divison by zero arithmatic error when below check is performed.
            if(duplicate%digit==0){
                ans++;
            }
          }
          System.out.println(ans);
      }
        return;
      
    }
}