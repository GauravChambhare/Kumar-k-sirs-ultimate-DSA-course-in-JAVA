import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HalloweenSale {
    //helper function
    static int halloweenSale(int p, int d, int m, int s){
      int money = s;
      int currentPrice = p;
      int ans = 0;
      
      while(money>=currentPrice){
        money -=currentPrice;
        ans++;
        currentPrice = Math.max(currentPrice-d, m);
      }
      return ans;
    }
    
    public static void main(String args[]) {
      Scanner in = new Scanner(System.in);
      int p = in.nextInt();
      int d = in.nextInt();
      int m = in.nextInt();
      int s = in.nextInt();
      System.out.println(halloweenSale(p, d, m, s));
      return;
    }
}