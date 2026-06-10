import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class BeautifulDaysAtTheMovies {
    
    final static int reverse(int num){
        int remainder = 0;
        int reverse = 0;
        int temp = num;
        while(temp>0){
            remainder = temp % 10;
            reverse = reverse*10 + remainder;
            temp /= 10;
        }
        return reverse;
    }
    
    public static void main(String args[]) {
      
      Scanner in = new Scanner(System.in);
      int start = in.nextInt();
      int end = in.nextInt();
      int divisor = in.nextInt();
      int ans = 0;
      while(start<=end){
        // for each no. in inclusive range [start, end]
        // if reverse of num - num is perfectly/evenly divisible by divisor then that is beautiful day
        if((reverse(start)-start)%divisor==0){ // main logic is this only
            ans++;
        }
        start++;
      }
      System.out.println(ans);
      return;
    }
}