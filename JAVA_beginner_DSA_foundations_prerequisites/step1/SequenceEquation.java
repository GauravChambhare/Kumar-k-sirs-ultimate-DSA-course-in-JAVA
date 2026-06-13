import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SequenceEquation {
    public static void main(String args[]) {
    //   this is tricky question
    //   even if you understood what is asked, when you actually move to 
    //   implement it, you will get stuck. So go through below once again in future
    //   understand why this solution works, complexities and how to implement it.
    //   taking inputs
      Scanner in = new Scanner(System.in);
      int n ; 
      n = in.nextInt();
      ArrayList<Integer> arr1 = new ArrayList<>(n);
      for(int i=0; i<n; i++){
            arr1.add(in.nextInt());
      }
      // now I will declare new arraylist arr2
      ArrayList<Integer> arr2 = new ArrayList<>(n);
      for(int i=1; i<=n; i++){
        // I will add index position for each x
        arr2.add(arr1.indexOf(i)+1); // because our x belongs to [1, x]
      }
      // i will declare arralist to calcute value of y in p(p(y))=x
      ArrayList<Integer> arr3 = new ArrayList<>(n);
      for(int i=0; i<n; i++){
        // I will add index position for each x
        arr3.add(arr1.indexOf(arr2.get(i))+1); // because our x belongs to [1, x]
      } 
      for(Integer i : arr3){
        System.out.println(i); // final answers
      }
      return;
    }
}